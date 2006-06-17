/* $Id$ */
/*
   Copyright (C) 2003 by David White <davidnwhite@verizon.net>
   Copyright (C) 2005 by Guillaume Melquiond <guillaume.melquiond@gmail.com>
   Part of the Battle for Wesnoth Project http://www.wesnoth.org/

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY.

   See the COPYING file for more details.
*/

#include "global.hpp"

#include "binary_or_text.hpp"
#include "config.hpp"
#include "filesystem.hpp"
#include "serialization/binary_wml.hpp"
#include "serialization/parser.hpp"

#include <sstream>

bool detect_format_and_read(config &cfg, std::istream &in, std::string* error_log)
{
	unsigned char c = in.peek();
	if (c < 4) {
		read_compressed(cfg, in);
		return true;
	} else {
		read(cfg, in, error_log);
		return false;
	}
}

void write_possibly_compressed(std::ostream &out, config &cfg, bool compress)
{
	if (compress)
		write_compressed(out, cfg);
	else
		write(out, cfg);
}

config_writer::config_writer(std::ostream &out, bool compress, const std::string &textdomain)
	: out_(out), compress_(compress), level_(0), textdomain_(textdomain)
{
}

void config_writer::write(const config &cfg)
{
	::write(out_, cfg, level_);
}

void config_writer::write_child(const std::string &key, const config &cfg)
{
	open_child(key);
	::write(out_, cfg, level_);
	close_child(key);
}

void config_writer::write_key_val(const std::string &key, const std::string &value)
{
	::write_key_val(out_, key, value, level_, textdomain_);
}

void config_writer::open_child(const std::string &key)
{
	::write_open_child(out_, key, level_++);
}

void config_writer::close_child(const std::string &key)
{
	::write_close_child(out_, key, --level_);
}

bool config_writer::good() const
{
	return out_.good();
}
