/* $Id$ */
/*
   Copyright (C) 2003 by David White <davidnwhite@optusnet.com.au>
   Part of the Battle for Wesnoth Project http://wesnoth.whitevine.net

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License.
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY.

   See the COPYING file for more details.
*/
#ifndef VIDEO_HPP_INCLUDED
#define VIDEO_HPP_INCLUDED

#include "SDL.h"

//possible flags when setting video modes
#define FULL_SCREEN SDL_FULLSCREEN
#define VIDEO_MEMORY SDL_HWSURFACE
#define SYSTEM_MEMORY SDL_SWSURFACE

void update_rect(size_t x, size_t y, size_t w, size_t h);
void update_rect(const SDL_Rect& rect);
void update_whole_screen();

class CVideo {
     public:
	CVideo();
	CVideo(int x, int y, int bits_per_pixel, int flags);
	~CVideo();

	int modePossible( int x, int y, int bits_per_pixel, int flags );
	int setMode( int x, int y, int bits_per_pixel, int flags );

	//functions to get the dimensions of the current video-mode
	int getx() const;
	int gety() const;
	int getBitsPerPixel();
	int getBytesPerPixel();
	int getRedMask();
	int getGreenMask();
	int getBlueMask();

	//functions to access the screen
	void lock();
	void unlock();
	int mustLock();

	void flip();

	SDL_Surface* getSurface( void );

	bool isFullScreen() const;

	struct error {};

	struct quit {};

	//functions to allow changing video modes when 16BPP is emulated
	void setBitsPerPixel( int bpp );
	void setBpp( int bpp );
	int getBpp();
     private:

	SDL_Surface* frameBuffer;
	int bpp;	// Store real bits per pixel
};

#endif
