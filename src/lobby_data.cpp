/* $Id$ */
/*
   Copyright (C) 2009 by Tomasz Sniatowski <kailoran@gmail.com>
   Part of the Battle for Wesnoth Project http://www.wesnoth.org/

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License version 2
   or at your option any later version.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY.

   See the COPYING file for more details.
*/

#include "lobby_data.hpp"

#include "config.hpp"
#include "game_preferences.hpp"
#include "filesystem.hpp"
#include "foreach.hpp"
#include "formula_string_utils.hpp"
#include "gettext.hpp"
#include "network.hpp"
#include "log.hpp"
#include "map.hpp"
#include "map_exception.hpp"
#include "wml_exception.hpp"

static lg::log_domain log_config("config");
#define ERR_CF LOG_STREAM(err, log_config)

chat_message::chat_message(const time_t& timestamp, const std::string& user, const std::string& message)
: timestamp(timestamp), user(user), message(message)
{
}

chat_message::chat_message(const std::string& user, const std::string& message)
: timestamp(time(0)), user(user), message(message)
{
}

chat_log::chat_log()
: history_()
{
}

void chat_log::add_message(const time_t& timestamp, const std::string& user, const std::string& message)
{
	history_.push_back(chat_message(timestamp, user, message));
}


void chat_log::add_message(const std::string& user, const std::string& message) {
	add_message(time(NULL), user, message);
}

std::string chat_log::assemble_text()
{
	std::stringstream ss;
	foreach (const chat_message& ch, history_) {
		ss << "<" << ch.user << ">" << ch.message << "\n";
	}
	return ss.str();
}

void chat_log::clear()
{
	history_.clear();
}

room_info::room_info(const std::string& name)
: name_(name), members_()
{
}

bool room_info::is_member(const std::string& user) const
{
	return members_.find(user) != members_.end();
}

void room_info::add_member(const std::string& user)
{
	members_.insert(user);
}

void room_info::remove_member(const std::string& user)
{
	members_.erase(user);
}

user_info::user_info()
	: name()
	, game_id()
	, location()
	, relation(ME)
	, state(LOBBY)
	, registered()
{
}

user_info::user_info(const config& c)
	: name(c["name"])
	, game_id(c["game_id"])
	, location(c["location"])
	, relation(ME)
	, state(c["available"] == "no" ? GAME : LOBBY)
	, registered(utils::string_bool(c["registered"]))
{
	if (name == preferences::login()) {
		relation = ME;
	} else if (preferences::is_ignored(name)) {
		relation = IGNORED;
	} else if (preferences::is_friend(name)) {
		relation = FRIEND;
	} else {
		relation = NEUTRAL;
	}
}

void user_info::update_state(const std::string& selected_game_id, const room_info* current_room /*= NULL*/)
{
	if (!game_id.empty() && game_id == selected_game_id) {
		state = SEL_GAME;
	} else if (state == LOBBY && current_room != NULL && current_room->is_member(name)) {
		state = SEL_ROOM;
	}
}

game_info::game_info() :
	mini_map(),
	id(),
	map_data(),
	name(),
	scenario(),
	remote_scenario(false),
	map_info(),
	map_size_info(),
	gold(),
	xp(),
	vision(),
	status(),
	time_limit(),
	vacant_slots(0),
	current_turn(0),
	reloaded(false),
	started(false),
	fog(false),
	shroud(false),
	observers(false),
	use_map_settings(false),
	verified(false),
	password_required(false),
	have_era(false)
{
}

namespace {

std::string make_short_name(const std::string long_name)
{
	if (long_name.empty()) return "";
	std::string sh;
	bool had_space = true;
	for (size_t i = 1; i < long_name.size(); ++i) {
		if (long_name[i] == ' ') {
			had_space = true;
		} else if (had_space && long_name[i] != '?') {
			sh += long_name[i];
			had_space = false;
		}
	}
	return sh;
}

} //end anonymous namespace

game_info::game_info(const config& game, const config& game_config)
: mini_map()
, id(game["id"])
, map_data(game["map_data"])
, name(game["name"])
, scenario()
, remote_scenario(false)
, map_info()
, map_size_info()
, era()
, era_short()
, gold(game["mp_village_gold"])
, xp(game["experience_modifier"] + "%")
, vision()
, status()
, time_limit()
, vacant_slots(lexical_cast_default<size_t>(game["slots"], 0))
, current_turn(0)
, reloaded(game["savegame"] == "yes")
, started(false)
, fog(game["mp_fog"] == "yes")
, shroud(game["mp_shroud"] == "yes")
, observers(game["observer"] != "no")
, use_map_settings(game["mp_use_map_settings"] == "yes")
, verified(true)
, password_required(game["password"] == "yes")
, have_era(true)
{
	std::string turn = game["turn"];
	std::string slots = game["slots"];
	if (!game["mp_era"].empty())
	{
		const config &era_cfg = game_config.find_child("era", "id", game["mp_era"]);
		utils::string_map symbols;
		symbols["era_id"] = game["mp_era"];
		if (era_cfg) {
			era = era_cfg["name"];
			era_short = era_cfg["short_name"];
			if (era_short.empty()) {
				era_short = make_short_name(era);
			}
		} else {
			have_era = (game["require_era"] == "no");
			era = vgettext("Unknown era: $era_id", symbols);
			era_short = "?" + make_short_name(era);
			verified = false;
		}
	} else {
		era = _("Unknown era");
		era_short = "??";
		verified = false;
	}
	map_info = era;

	if (map_data.empty()) {
		map_data = read_map(game["mp_scenario"]);
	}

	if (map_data.empty()) {
		map_info += " - ??x??";
	} else {
		try {
			gamemap map(game_config, map_data);
			//mini_map = image::getMinimap(minimap_size_, minimap_size_, map, 0);
			map_size_info = lexical_cast_default<std::string, int>(map.w(), "??")
				+ std::string("x") + lexical_cast_default<std::string, int>(map.h(), "??");
			map_info += " - " + map_size_info;
		} catch (incorrect_map_format_exception &e) {
			ERR_CF << "illegal map: " << e.msg_ << "\n";
			verified = false;
		} catch (twml_exception& e) {
			ERR_CF <<  "map could not be loaded: " << e.dev_message << '\n';
			verified = false;
		}
	}
	map_info += " ";
	if (!game["mp_scenario"].empty())
	{
		// check if it's a multiplayer scenario
		const config *level_cfg = &game_config.find_child("multiplayer", "id", game["mp_scenario"]);
		if (!*level_cfg) {
			// check if it's a user map
			level_cfg = &game_config.find_child("generic_multiplayer", "id", game["mp_scenario"]);
		}
		if (*level_cfg) {
			scenario = level_cfg->get_attribute("name");
			map_info += scenario;
			// reloaded games do not match the original scenario hash,
			// so it makes no sense to test them, they always would appear
			// as remote scenarios
			if (!reloaded) {
				if (const config& hashes = game_config.child("multiplayer_hashes")) {
					std::string hash = game["hash"];
					bool hash_found = false;
					foreach (const config::attribute &i, hashes.attribute_range()) {
						if (i.first == game["mp_scenario"] && i.second == hash) {
							hash_found = true;
							break;
						}
					}
					if(!hash_found) {
						remote_scenario = true;
						map_info += " - ";
						map_info += _("Remote scenario");
						verified = false;
					}
				}
			}
		} else {
			utils::string_map symbols;
			symbols["scenario_id"] = game["mp_scenario"];
			scenario = vgettext("Unknown scenario: $scenario_id", symbols);
			map_info += scenario;
			verified = false;
		}
	} else {
		scenario = _("Unknown scenario");
		map_info += scenario;
		verified = false;
	}
	if (reloaded) {
		map_info += " - ";
		map_info += _("Reloaded game");
		verified = false;
	}

	if (!turn.empty()) {
		started = true;
		int index = turn.find_first_of('/');
		if (index > -1){
			const std::string current_turn_string = turn.substr(0, index);
			current_turn = lexical_cast<unsigned int>(current_turn_string);
		}
		status = _("Turn ") + turn;
	} else {
		started = false;
		if (vacant_slots > 0) {
			status = std::string(_n("Vacant Slot:", "Vacant Slots:",
					vacant_slots)) + " " + game["slots"];
		}
	}

	if (fog) {
		vision = _("Fog");
		if (shroud) {
			vision += "/";
			vision += _("Shroud");
		}
	} else if (shroud) {
		vision = _("Shroud");
	} else {
		vision = _("none");
	}
	if (game["mp_countdown"] == "yes" ) {
		time_limit =   game["mp_countdown_init_time"] + "+"
		             + game["mp_countdown_turn_bonus"] + "/"
		             + game["mp_countdown_action_bonus"];
	} else {
		time_limit = "";
	}
}

game_filter_stack::game_filter_stack()
: filters_()
{
}

game_filter_stack::~game_filter_stack()
{
	foreach (game_filter_base* f, filters_) {
		delete f;
	}
}

void game_filter_stack::append(game_filter_base *f)
{
	filters_.push_back(f);
}

void game_filter_stack::clear()
{
	foreach (game_filter_base* f, filters_) {
		delete f;
	}
	filters_.clear();
}

bool game_filter_and_stack::match(const game_info &game) const
{
	foreach (game_filter_base* f, filters_) {
		if (!f->match(game)) return false;
	}
	return true;
}

bool game_filter_or_stack::match(const game_info &game) const
{
	foreach (game_filter_base* f, filters_) {
		if (f->match(game)) return true;
	}
	return false;
}

bool game_filter_string_part::match(const game_info &game) const
{
	const std::string& gs = game.*member_;
	return std::search(gs.begin(), gs.end(), value_.begin(), value_.end(),
		chars_equal_insensitive) != gs.end();
}

lobby_info::lobby_info(const config& game_config)
: game_config_(game_config), gamelist_(), gamelist_initialized_(false)
, rooms_(), games_(), games_filtered_(), users_()
, game_filter_(), game_filter_invert_(false)
{
}

void lobby_info::process_gamelist(const config &data)
{
	gamelist_ = data;
	gamelist_initialized_ = true;
	parse_gamelist();
}

bool lobby_info::process_gamelist_diff(const config &data)
{
	if (!gamelist_initialized_) return false;
	try {
		gamelist_.apply_diff(data);
	} catch(config::error& e) {
		ERR_CF << "Error while applying the gamelist diff: '"
			<< e.message << "' Getting a new gamelist.\n";
		network::send_data(config("refresh_lobby"), 0, true);
		return false;
	}
	parse_gamelist();
	return true;
}

void lobby_info::parse_gamelist()
{
	users_.clear();
	foreach (const config& c, gamelist_.child_range("user")) {
		users_.push_back(user_info(c));
	}
	games_.clear();
	foreach (const config& c, gamelist_.child("gamelist").child_range("game")) {
		games_.push_back(game_info(c, game_config_));
	}
}

room_info* lobby_info::get_room(const std::string &name)
{
	foreach (room_info& r, rooms_) {
		if (r.name() == name) return &r;
	}
	return NULL;
}

const room_info* lobby_info::get_room(const std::string &name) const
{
	foreach (const room_info& r, rooms_) {
		if (r.name() == name) return &r;
	}
	return NULL;
}

bool lobby_info::has_room(const std::string &name) const
{
	return get_room(name) != NULL;
}

chat_log& lobby_info::get_whisper_log(const std::string &name)
{
	return whispers_[name];
}

void lobby_info::open_room(const std::string &name)
{
	rooms_.push_back(room_info(name));
}

void lobby_info::close_room(const std::string &name)
{
	room_info* r = get_room(name);
	if (r) {
		rooms_.erase(rooms_.begin() + (r - &rooms_[0]));
	}
}

const std::vector<game_info>& lobby_info::games_filtered()
{
	return games_filtered_;
}

void lobby_info::add_game_filter(game_filter_base *f)
{
	game_filter_.append(f);
}

void lobby_info::clear_game_filter()
{
	game_filter_.clear();
}

void lobby_info::set_game_filter_invert(bool value)
{
	game_filter_invert_ = value;
}

void lobby_info::apply_game_filter()
{
	games_filtered_.clear();
	if (game_filter_invert_) {
		std::remove_copy_if(games_.begin(), games_.end(),
			std::back_inserter(games_filtered_), game_filter_);
	} else {
		std::remove_copy_if(games_.begin(), games_.end(),
			std::back_inserter(games_filtered_), std::not1(game_filter_));
	}
}