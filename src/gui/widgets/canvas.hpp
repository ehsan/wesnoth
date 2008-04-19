/* $Id$ */
/*
   Copyright (C) 2007 - 2008 by Mark de Wever <koraq@xs4all.nl>
   Part of the Battle for Wesnoth Project http://www.wesnoth.org/

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License version 2
   or at your option any later version.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY.

   See the COPYING file for more details.
*/

//! @file canvas.hpp
//! This file contains the canvas object which is the part where the widgets
//! draw (tempory) images on.

// FIXME look at SDL_gfx it might have some nice functions that same me work.

#ifndef __GUI_WIDGETS_CANVAS_HPP_INCLUDED__
#define __GUI_WIDGETS_CANVAS_HPP_INCLUDED__

#include "formula_callable.hpp"
#include "reference_counted_object.hpp"
#include "sdl_utils.hpp"
#include "tstring.hpp"
#include "variant.hpp"

#include <vector>

class config;
class surface;

namespace gui2 {

//! Base class for the canvas which allows drawing, a later version may implement
//! a cache which allows the same scripts with the same input to store their
//! output surface. But that will be looked into later.


//! The copy constructor does a shallow copy of the shapes to draw.
//! a clone() will be implemented if really needed.

// maybe inherit from surface...
class tcanvas 
{
public:

	//! Base class for all other shapes.
	//! The other shapes are declared and defined in canvas.cpp.
	class tshape : public reference_counted_object
	{
	public:
		virtual void draw(surface& canvas, 
			const game_logic::map_formula_callable& variables) = 0;

		virtual ~tshape() {}
	protected:

		// draw basic primitives

		void put_pixel(ptrdiff_t start, Uint32 colour, unsigned w, unsigned x, unsigned y);
		void draw_line(surface& canvas, Uint32 colour, 
			const unsigned x1, unsigned y1, const unsigned x2, unsigned y2);

	};

	typedef boost::intrusive_ptr<tshape> tshape_ptr;
	typedef boost::intrusive_ptr<const tshape> const_tshape_ptr;

	tcanvas();
	tcanvas(const config& cfg);

	void draw(const config& cfg);
	void draw(const bool force = false);

	void set_width(const unsigned width) { w_ = width; set_dirty(); }
	unsigned get_width() const { return w_; }

	void set_height(const unsigned height) { h_ = height; set_dirty(); }
	unsigned get_height() const { return h_; }

	surface& surf() { return canvas_; }

	void set_cfg(const config& cfg) { parse_cfg(cfg); }

	void set_variable(const std::string& key, const variant& value)
		{ variables_.add(key, value); }

private:
	void set_dirty(const bool dirty = true) { dirty_ = dirty; }

	void parse_cfg(const config& cfg);

	std::vector<tshape_ptr> shapes_;

	unsigned w_;
	unsigned h_;

	//! The canvas we draw all items on.
	surface canvas_;

	game_logic::map_formula_callable variables_;

	bool dirty_;
};

//! Template class can hold a value or a formula calculating the value.
//!
//! Note since it's also instanciated in canvas.cpp declared the class here.
template <class T>
class tformula
{
public:	
	tformula<T>(const std::string& str);

	//! Returns the value, can only be used it the data is no formula.
	//! 
	//! Another option would be to cache the output of the formula in value_
	//! and always allow this function. But for now decided that the caller
	//! needs to do the caching. It might be changed later.
	T operator()() const
	{
		assert(!has_formula());
		return value_;
	}
	
	//! Returns the value, can always be used.
	T operator() (const game_logic::map_formula_callable& variables) const;

	//! Determine whether the class contains a formula.
	bool has_formula() const { return !formula_.empty(); }

private:
	
	//! Converts the string ot the template value.
	void convert(const std::string& str);

	T execute(const game_logic::map_formula_callable& variables) const;

	//! If there is a formula it's stored in this string, empty if no formula.
	std::string formula_;

	//! If no formula it contains the value.
	T value_;

};

} // namespace gui2


#endif
