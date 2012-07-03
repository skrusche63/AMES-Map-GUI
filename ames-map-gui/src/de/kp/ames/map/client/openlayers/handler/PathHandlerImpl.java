package de.kp.ames.map.client.openlayers.handler;

import de.kp.ames.map.client.openlayers.util.JSObject;

class PathHandlerImpl {

	public static native JSObject create() /*-{
		return $wnd.OpenLayers.Handler.Path;
	}-*/;

}