package de.kp.ames.map.client.openlayers.layer;

import de.kp.ames.map.client.openlayers.util.JSObject;
import de.kp.ames.map.client.openlayers.util.JSObjectWrapper;


public class OSMOptions extends JSObjectWrapper {

	//TODO: see if it makes more sense to extend LayerOptions

	protected OSMOptions(JSObject jsObject) {
		super(jsObject);
	}

	public OSMOptions(){
		this(JSObject.createJSObject());
	}

}
