package de.kp.ames.map.client.openlayers.event;


import de.kp.ames.map.client.openlayers.layer.Vector;
import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class VectorEvent extends EventObject {

	protected VectorEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Vector getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Vector.narrowToVector(object):null;
	}

}
