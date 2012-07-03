package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;
import de.kp.ames.map.client.openlayers.util.JSObjectWrapper;

/**
 * Options specific to Control widgets.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ControlOptions extends JSObjectWrapper {

	protected ControlOptions(JSObject jsObject) {
		super(jsObject);
	}

	public ControlOptions(){
		this(JSObject.createJSObject());
	}

}
