package de.kp.ames.map.client.openlayers.event;

import de.kp.ames.map.client.openlayers.Marker;
import de.kp.ames.map.client.openlayers.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class MarkerEvent extends EventObject {

	protected MarkerEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Marker getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Marker.narrowToMarker(object):null;
	}

}
