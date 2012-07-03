package de.kp.ames.map.client.openlayers.format;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class WKTImpl {

	public static native JSObject create()
	/*-{
		return new $wnd.OpenLayers.Format.WKT();
	}-*/;

}
