package de.kp.ames.map.client.openlayers.event;

import de.kp.ames.map.client.openlayers.control.Control;
import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class ControlEvent extends EventObject {

	protected ControlEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Control getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Control.narrowToControl(object):null;
	}

}
