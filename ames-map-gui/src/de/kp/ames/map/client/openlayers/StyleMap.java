package de.kp.ames.map.client.openlayers;

import de.kp.ames.map.client.openlayers.util.JSObject;

public class StyleMap extends OpenLayersObjectWrapper{

	protected StyleMap(JSObject element) {
		super(element);
	}

	public StyleMap(Style defaultStyle) {
		this(StyleMapImpl.create(defaultStyle.getJSObject()));
	}

}
