package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class PanZoomBarImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.PanZoomBar();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.PanZoomBar(options);
	}-*/;

}
