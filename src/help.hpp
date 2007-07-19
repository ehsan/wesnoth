/* $Id$ */
/*
   Copyright (C) 2003 by David White <davidnwhite@verizon.net>
   Part of the Battle for Wesnoth Project http://www.wesnoth.org/

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY.

   See the COPYING file for more details.
*/
#ifndef HELP_HPP_INCLUDED
#define HELP_HPP_INCLUDED

#include <string>
#include <vector>

class config;
class display;
struct game_data;
class gamemap;

#include "hotkeys.hpp"
#include "construct_dialog.hpp"

namespace help {

struct help_manager {
	help_manager(const config *game_config, const game_data *game_info, gamemap *map);
	~help_manager();
};

struct section;
/// Open a help dialog using a toplevel other than the default. This
/// allows for complete customization of the contents, although not in a
/// very easy way.
void show_help(display &disp, const section &toplevel, const std::string show_topic="",
			   int xloc=-1, int yloc=-1);

/// Open the help browser. The help browser will have the topic with id
/// show_topic open if it is not the empty string. The default topic
/// will be shown if show_topic is the empty string.
void show_help(display &disp, const std::string show_topic="", int xloc=-1, int yloc=-1);

class help_button : public gui::dialog_button, public hotkey::command_executor {
public:
	help_button(display& disp, const std::string &help_topic);
	int action(gui::dialog_process_info &info);
	const std::string topic() const { return topic_; }
	void join();
	void leave();
private:
	void show_help();
	bool can_execute_command(hotkey::HOTKEY_COMMAND cmd, int/*index*/ =-1) const;

	display &disp_;
	const std::string topic_;
	hotkey::basic_handler *help_hand_;
};


} // End namespace help.

#endif
