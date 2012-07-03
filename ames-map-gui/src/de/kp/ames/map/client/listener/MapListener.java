package de.kp.ames.map.client.listener;
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

public interface MapListener {

	public void onDrag(String key, double lat, double lon);

	public void onDragComplete(String key, double lat, double lon);

}