package de.kp.ames.map.client.util;
/**
 * This file is part of the AMES Map GUI.
 *
 * AMES Map GUI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AMES Map GUI is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the AMES Map GUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2012 Dr. Krusche & Partner PartG <team@dr-kruscheundpartner.de>
 *
 */

public class MapLoader {

	/*
	 * Reference to Message Window
	 */
	private Message loading;
	private static MapLoader instance = new MapLoader();
	
	/**
	 * Constuctor
	 */
	private MapLoader() {}
	
	/**
	 * @return
	 */
	public static MapLoader getInstance() {
		if (instance == null) instance = new MapLoader();
		return instance;
	}
	
	/**
	 * Open message window
	 * 
	 * @param text
	 */
	public void open(String text) {
		if (loading != null) loading.destroy();
		loading = new Message(text);
	}
	
	/**
	 * Reset message window
	 */
	public void reset() {
		if (loading != null) loading.destroy();
		loading = null;
	}
	
}
