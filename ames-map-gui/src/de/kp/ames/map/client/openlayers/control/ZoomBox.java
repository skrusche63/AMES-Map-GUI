package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ZoomBox extends Control {

	protected ZoomBox(JSObject element) {
		super(element);
	}

	public ZoomBox(){
		this(ZoomBoxImpl.create());
	}

	public ZoomBox(ZoomBoxOptions options){
		this(ZoomBoxImpl.create(options.getJSObject()));
	}

}
