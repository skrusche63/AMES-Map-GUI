package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class ControlImpl {

	public static native boolean activate(JSObject self)/*-{
		return self.activate();
	}-*/;

	public static native boolean deactivate(JSObject self)/*-{
		return self.deactivate();
	}-*/;


}
