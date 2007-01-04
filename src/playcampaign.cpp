/* $Id$ */
/*
   Copyright (C) 2003-2005 by David White <davidnwhite@verizon.net>
   Copyright (C) 2005 by Philippe Plantier <ayin@anathas.org>
   Part of the Battle for Wesnoth Project http://www.wesnoth.org

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY.

   See the COPYING file for more details.
*/

#include "global.hpp"

#include <map>

#include "playcampaign.hpp"
#include "config.hpp"
#include "filesystem.hpp"
#include "gamestatus.hpp"
#include "map_create.hpp"
#include "playmp_controller.hpp"
#include "playsingle_controller.hpp"
#include "replay.hpp"
#include "replay_controller.hpp"
#include "log.hpp"
#include "preferences.hpp"
#include "dialogs.hpp"
#include "gettext.hpp"
#include "game_errors.hpp"
#include "sound.hpp"
#include "wassert.hpp"

#define LOG_G LOG_STREAM(info, general)

namespace {

struct player_controller
{
	player_controller()
	{}

	player_controller(const std::string& controller, const std::string& description) :
		controller(controller), description(description)
	{}

	std::string controller;
	std::string description;
};

typedef std::map<std::string, player_controller> controller_map;

}

void play_replay(display& disp, game_state& gamestate, const config& game_config,
		const game_data& units_data, CVideo& video)
{
	std::string type = gamestate.campaign_type;
	if(type.empty())
		type = "scenario";

	config const* scenario = NULL;

	//'starting_pos' will contain the position we start the game from.
	config starting_pos;

	recorder.set_save_info(gamestate);
	if (gamestate.snapshot.child("side") != NULL){
		gamestate = read_game(units_data, &gamestate.snapshot);
	}

	//see if we load the scenario from the scenario data -- if there is
	//no snapshot data available from a save, or if the user has selected
	//to view the replay from scratch
	if(!recorder.at_end()) {
		//if the starting state is specified, then use that,
		//otherwise get the scenario data and start from there.
		if(gamestate.starting_pos.empty() == false) {
			LOG_G << "loading starting position...\n";
			starting_pos = gamestate.starting_pos;
			scenario = &starting_pos;
		} else {
			LOG_G << "loading scenario: '" << gamestate.scenario << "'\n";
			scenario = game_config.find_child(type,"id",gamestate.scenario);
			LOG_G << "scenario found: " << (scenario != NULL ? "yes" : "no") << "\n";
		}
	}

	controller_map controllers;

	const std::string current_scenario = gamestate.scenario;

	try {
		// preserve old label eg. replay
		if (gamestate.label.empty())
			gamestate.label = (*scenario)["name"];

		play_replay_level(units_data,game_config,scenario,video,gamestate);

		gamestate.snapshot = config();
		recorder.clear();
		gamestate.replay_data.clear();

	} catch(game::load_game_failed& e) {
		gui::show_error_message(disp, _("The game could not be loaded: ") + e.message);
	} catch(game::game_error& e) {
		gui::show_error_message(disp, _("Error while playing the game: ") + e.message);
	} catch(gamemap::incorrect_format_exception& e) {
		gui::show_error_message(disp, std::string(_("The game map could not be loaded: ")) + e.msg_);
	}
}

void clean_autosaves(const std::string &label)
{
	std::vector<save_info> games = get_saves_list();
	std::string prefix = label + "-" + _("Auto-Save");
	std::cerr << "Cleaning autosaves with prefix '" << prefix << "'\n";
	for (std::vector<save_info>::iterator i = games.begin(); i != games.end(); i++) {
		if (i->name.compare(0,prefix.length(),prefix) == 0) {
			std::cerr << "Deleting autosave '" << i->name << "'\n";
			delete_game(i->name);
		}
	}
}

LEVEL_RESULT play_game(display& disp, game_state& gamestate, const config& game_config,
		const game_data& units_data, CVideo& video,
		upload_log &log,
		io_type_t io_type, bool skip_replay)
{
	std::string type = gamestate.campaign_type;
	if(type.empty())
		type = "scenario";

	config const* scenario = NULL;

	//'starting_pos' will contain the position we start the game from.
	config starting_pos;

	recorder.set_save_info(gamestate);

	//see if we load the scenario from the scenario data -- if there is
	//no snapshot data available from a save, or if the user has selected
	//to view the replay from scratch
	if(gamestate.snapshot.child("side") == NULL || !recorder.at_end()) {
		//if the starting state is specified, then use that,
		//otherwise get the scenario data and start from there.
		if(gamestate.starting_pos.empty() == false) {
			LOG_G << "loading starting position...\n";
			starting_pos = gamestate.starting_pos;
			scenario = &starting_pos;
		} else {
			LOG_G << "loading scenario: '" << gamestate.scenario << "'\n";
			scenario = game_config.find_child(type,"id",gamestate.scenario);
			LOG_G << "scenario found: " << (scenario != NULL ? "yes" : "no") << "\n";
		}
	} else {
		LOG_G << "loading snapshot...\n";
		//load from a save-snapshot.
		starting_pos = gamestate.snapshot;
		scenario = &starting_pos;
		gamestate = read_game(units_data, &gamestate.snapshot);
	}

	controller_map controllers;

	if(io_type == IO_SERVER) {
		const config::child_list& sides_list = scenario->get_children("side");
		for(config::child_list::const_iterator side = sides_list.begin();
				side != sides_list.end(); ++side) {
			std::string id = (**side)["save_id"];
			if(id.empty())
				continue;
			controllers[id] = player_controller((**side)["controller"],
					(**side)["description"]);
		}
	}

	while(scenario != NULL) {
		//If we are a multiplayer client, tweak the controllers
		if(io_type == IO_CLIENT) {
			if(scenario != &starting_pos) {
				starting_pos = *scenario;
				scenario = &starting_pos;
			}

			const config::child_list& sides_list = starting_pos.get_children("side");
			for(config::child_list::const_iterator side = sides_list.begin();
					side != sides_list.end(); ++side) {
				if((**side)["controller"] == "network" &&
						(**side)["current_player"] == preferences::login()) {
					(**side)["controller"] = preferences::client_type();
				} else if((**side)["controller"] != "null") {
					(**side)["controller"] = "network";
				}
			}
		}

		const config::child_list& story = scenario->get_children("story");
		const std::string current_scenario = gamestate.scenario;

		bool save_game_after_scenario = true;

		const set_random_generator generator_setter(&recorder);

		try {
			// preserve old label eg. replay
			if (gamestate.label.empty())
				gamestate.label = (*scenario)["name"];

			//if the entire scenario should be randomly generated
			if((*scenario)["scenario_generation"] != "") {
				LOG_G << "randomly generating scenario...\n";
				const cursor::setter cursor_setter(cursor::WAIT);

				static config scenario2;
				scenario2 = random_generate_scenario((*scenario)["scenario_generation"], scenario->child("generator"));
				//level_ = scenario;

				gamestate.starting_pos = scenario2;
				scenario = &scenario2;
			}

			std::string map_data = (*scenario)["map_data"];
			if(map_data == "" && (*scenario)["map"] != "") {
				map_data = read_map((*scenario)["map"]);
			}

			//if the map should be randomly generated
			if(map_data == "" && (*scenario)["map_generation"] != "") {
				const cursor::setter cursor_setter(cursor::WAIT);
				map_data = random_generate_map((*scenario)["map_generation"],scenario->child("generator"));

				//since we've had to generate the map, make sure that when we save the game,
				//it will not ask for the map to be generated again on reload
				static config new_level;
				new_level = *scenario;
				new_level.values["map_data"] = map_data;
				scenario = &new_level;

				gamestate.starting_pos = new_level;
				LOG_G << "generated map\n";
			}

			sound::play_no_music();

			LEVEL_RESULT res;
			switch (io_type){
			case IO_NONE:
				res = playsingle_scenario(units_data,game_config,scenario,video,gamestate,story,log, skip_replay);
				break;
			case IO_SERVER:
			case IO_CLIENT:
				res = playmp_scenario(units_data,game_config,scenario,video,gamestate,story,log, skip_replay);
				break;
			}


			gamestate.snapshot = config();
			if (res == DEFEAT) {
				// tell all clients that the campaign won't continue
				if(io_type == IO_SERVER) {
					config end;
					end.add_child("end_scenarios");
					network::send_data(end);
				}
				gui::show_dialog(disp, NULL,
				                 _("Defeat"),
				                 _("You have been defeated!"),
				                 gui::OK_ONLY);
			}
			if(res == QUIT && io_type == IO_SERVER) {
					config end;
					end.add_child("end_scenarios");
					network::send_data(end);
			}
			//ask to save a replay of the game
			if(res == VICTORY || res == DEFEAT) {
				const std::string orig_scenario = gamestate.scenario;
				gamestate.scenario = current_scenario;

				std::string label = gamestate.label + _(" replay");

				bool retry = true;

				while(retry) {
					retry = false;

					const int should_save = dialogs::get_save_name(disp,
							_("Do you want to save a replay of this scenario?"),
							_("Name:"),
							&label, gui::OK_CANCEL, _("Save Replay"));
					if(should_save == 0) {
						try {
							config snapshot;

							recorder.save_game(label, snapshot, gamestate.starting_pos);
						} catch(game::save_game_failed&) {
							gui::show_error_message(disp, _("The replay could not be saved"));
							retry = true;
						};
					}
				}

				gamestate.scenario = orig_scenario;
			}

			recorder.clear();
			gamestate.replay_data.clear();

			//continue without saving is like a victory, but the
			//save game dialog isn't displayed
			if(res == LEVEL_CONTINUE_NO_SAVE) {
				res = VICTORY;
				save_game_after_scenario = false;
			}
			if(res != VICTORY)
				return res;
		} catch(game::load_game_failed& e) {
			gui::show_error_message(disp, _("The game could not be loaded: ") + e.message);
			return QUIT;
		} catch(game::game_error& e) {
			gui::show_error_message(disp, _("Error while playing the game: ") + e.message);
			return QUIT;
		} catch(gamemap::incorrect_format_exception& e) {
			gui::show_error_message(disp, std::string(_("The game map could not be loaded: ")) + e.msg_);
			return QUIT;
		}

		//if the scenario hasn't been set in-level, set it now.
		if(gamestate.scenario == current_scenario)
			gamestate.scenario = (*scenario)["next_scenario"];

		if(io_type == IO_CLIENT) {
			config cfg;

			std::string msg;
			if (gamestate.scenario.empty())
				msg = _("Receiving data...");
			else
				msg = _("Downloading next scenario...");

			do {
				cfg.clear();
				network::connection data_res = gui::network_receive_dialog(disp,
						msg, cfg);
				if(!data_res)
					throw network::error(_("Connection timed out"));
			} while(cfg.child("next_scenario") == NULL &&
					cfg.child("end_scenarios") == NULL);

			if(cfg.child("next_scenario")) {
				starting_pos = (*cfg.child("next_scenario"));
				scenario = &starting_pos;
				gamestate = read_game(units_data, scenario);
			} else if(scenario->child("end_scenarios")) {
				scenario = NULL;
				gamestate.scenario = "null";
			} else {
				return QUIT;
			}

		} else {
			scenario = game_config.find_child(type,"id",gamestate.scenario);

			if(io_type == IO_SERVER && scenario != NULL) {
				starting_pos = *scenario;
				scenario = &starting_pos;

				// Tweaks sides to adapt controllers and descriptions.
				const config::child_list& sides_list = starting_pos.get_children("side");
				for(config::child_list::const_iterator side = sides_list.begin();
						side != sides_list.end(); ++side) {
					std::string id = (**side)["save_id"];
					if(id.empty()) {
						continue;
					}

					/*Upadate side info to match current_player info to
					  allow it taking the side in next scenario and to be
					  set in the players list on side server */
					controller_map::const_iterator ctr = controllers.find(id);
					if(ctr != controllers.end()) {
						player_info *player = gamestate.get_player(id);
						if (player) {
							(**side)["current_player"] = player->name;
							//TODO : remove (see TODO line 276 in server/game.cpp)
							(**side)["user_description"] = player->name;
						}
						(**side)["controller"] = ctr->second.controller;
					}
				}

				// Sends scenario data
				config cfg;
				cfg.add_child("next_scenario", *scenario);

				// Adds player information, and other state
				// information, to the configuration object
				wassert(cfg.child("next_scenario") != NULL);
				write_game(gamestate, *cfg.child("next_scenario")/*, WRITE_SNAPSHOT_ONLY*/);
				network::send_data(cfg);

			} else if(io_type == IO_SERVER && scenario == NULL) {
				config end;
				end.add_child("end_scenarios");
				network::send_data(end);
			}
		}

		if(scenario != NULL) {
			// update the label
			std::string oldlabel = gamestate.label;
			gamestate.label = (*scenario)["name"];

			//if this isn't the last scenario, then save the game
			if(save_game_after_scenario) {
				gamestate.starting_pos = config();

				bool retry = true;

				while(retry) {
					retry = false;

					const int should_save = dialogs::get_save_name(disp,
						_("Do you want to save your game? (Also erases Auto-Save files)"),
						_("Name:"),
						&gamestate.label);


					if(should_save == 0) {
						try {
							save_game(gamestate);
							if (!oldlabel.empty())
								clean_autosaves(oldlabel);
						} catch(game::save_game_failed&) {
							gui::show_error_message(disp, _("The game could not be saved"));
							retry = true;
						}
					}
				}
			}

			//update the replay start
			//FIXME: this should only be done if the scenario was not tweaked.
			gamestate.starting_pos = *scenario;
		}

		recorder.set_save_info(gamestate);
	}

	if (!gamestate.scenario.empty() && gamestate.scenario != "null") {
		gui::show_error_message(disp, _("Unknown scenario: '") + gamestate.scenario + '\'');
		return QUIT;
	}

	return VICTORY;
}

