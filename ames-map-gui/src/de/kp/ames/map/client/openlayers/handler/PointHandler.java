package de.kp.ames.map.client.openlayers.handler;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PointHandler extends Handler {

	protected PointHandler(JSObject element) {
		super(element);
	}

	public PointHandler(){
		this(PointHandlerImpl.create());
	}
}
