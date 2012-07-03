package de.kp.ames.map.client.openlayers.event;


import de.kp.ames.map.client.openlayers.layer.Layer;
import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class MapLayerEvent extends MapEvent {

	protected MapLayerEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Layer getLayer(){
		JSObject object = getJSObject().getProperty("layer");
		return (object!=null)? Layer.narrowToLayer(object): null;
	}

}
