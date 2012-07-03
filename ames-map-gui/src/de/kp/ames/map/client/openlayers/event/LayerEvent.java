package de.kp.ames.map.client.openlayers.event;


import de.kp.ames.map.client.openlayers.layer.Layer;
import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class LayerEvent extends EventObject {

	protected LayerEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Layer getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Layer.narrowToLayer(object):null;
	}

}
