package de.kp.ames.map.client.openlayers.control;


import com.google.gwt.user.client.Element;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class ScaleImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.Scale();
	}-*/;

	public static native JSObject create(Element div)/*-{
		return new $wnd.OpenLayers.Control.Scale(div);
	}-*/;
}
