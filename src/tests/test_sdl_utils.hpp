/* $Id$ */
/*
   Copyright (C) 2012 by Mark de Wever <koraq@xs4all.nl>
   Part of the Battle for Wesnoth Project http://www.wesnoth.org/

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2 of the License, or
   (at your option) any later version.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY.

   See the COPYING file for more details.
*/

#ifndef TESTS_TEST_SDL_UTILS_HPP_INCLUDED
#define TESTS_TEST_SDL_UTILS_HPP_INCLUDED

#include "sdl_utils.hpp"

#include <boost/function.hpp>

typedef boost::function<
		void(const surface&, const double, const Uint32)>
		tblend_functor;


inline void
blend_image(const surface& src, tblend_functor functor)
{
	for(Uint32 colour = 0x00FF0000; colour != 0x00000000; colour >>= 8) {
		for(int i = 0xf; i < 0x100; i += 0x10) {
			const surface dst = blend_surface(src, i / 255., colour);
			if(functor) {
				functor(dst, i, colour);
			}
		}
	}
}

inline std::string
blend_get_filename(std::string root, const Uint8 amount, const Uint32 colour)
{
	// The name of the file is
	// A the amount of blended [0..256) as hex.
	// C the colour to blend with as hex.
	char filename[] = "AA_CCCCCCCC.png";
	snprintf(filename, sizeof(filename), "%02X_%08X.png", amount, colour);

	return root + filename;
}

#endif
