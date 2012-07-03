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

import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.map.client.style.MapStyle;

public class Message extends Window {
		
	/**
	 * Constructor requires message text
	 * 
	 * @param text
	 */
	public Message(String text) {

		VLayout vLayout = new VLayout();
		vLayout.setShowEdges(false);
		
		vLayout.setWidth100();
		vLayout.setHeight100();
		
		vLayout.setMembersMargin(0);
		vLayout.setLayoutMargin(0);

		StringBuffer sb = new StringBuffer();
		
		sb.append("<img style=\"margin:16px;margin-top:24px;margin-left:auto;margin-right:auto;display:block;\" ");
		sb.append("src=\"" + MapStyle.LOADING_IMAGE + "\" width=\"64\" height=\"64\" />");
		
		sb.append("<p style=\"font:normal 11px tahoma, arial, helvetica, sans-serif;color:" + MapStyle.FONT_COLOR + ";text-align:center;\">" + text + "</p>");

		HTMLFlow flow = new HTMLFlow();
		flow.setContents(sb.toString());
		
		vLayout.addMember(flow);
		this.addItem(vLayout);
		
		this.setTitle(MapStyle.APP_TITLE);
		
		this.setShowCloseButton(false);
		this.setShowMinimizeButton(false);

		this.setBodyColor(MapStyle.BG_COLOR);

		this.setWidth(240);
		this.setHeight(160);
		
		this.centerInPage();
		this.draw();
		
	}

}
