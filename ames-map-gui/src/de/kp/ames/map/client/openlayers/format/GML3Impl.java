package de.kp.ames.map.client.openlayers.format;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class GML3Impl {

	public static native JSObject create()
	/*-{
		return new $wnd.OpenLayers.Format.GML.v3({});
	}-*/;

}
