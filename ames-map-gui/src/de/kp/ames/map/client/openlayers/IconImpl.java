package de.kp.ames.map.client.openlayers;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class IconImpl {

	public static native JSObject create(String url, JSObject size)/*-{
		return new $wnd.OpenLayers.Icon(url, size);
	}-*/;

	public static native JSObject create(String url, JSObject size, JSObject offset)/*-{
		return new $wnd.OpenLayers.Icon(url, size, offset);
	}-*/;

}
