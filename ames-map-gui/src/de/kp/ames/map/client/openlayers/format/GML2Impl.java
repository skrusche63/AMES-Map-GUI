package de.kp.ames.map.client.openlayers.format;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class GML2Impl {

	public static native JSObject create()
	/*-{
		return new $wnd.OpenLayers.Format.GML.v2({});
	}-*/;

}
