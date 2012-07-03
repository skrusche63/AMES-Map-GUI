package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * DragPan control wrapper.
 *
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class DragPan extends Control {
	protected DragPan(JSObject element) {
		super(element);
	}

	public DragPan() {
		this(DragPanImpl.create());
	}

}
