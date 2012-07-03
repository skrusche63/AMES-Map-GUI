package de.kp.ames.map.client.openlayers.event;

import de.kp.ames.map.client.openlayers.Map;
import de.kp.ames.map.client.openlayers.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class MapEvent extends EventObject {

	protected MapEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Map getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Map.narrowToMap(object):null;
	}

}
