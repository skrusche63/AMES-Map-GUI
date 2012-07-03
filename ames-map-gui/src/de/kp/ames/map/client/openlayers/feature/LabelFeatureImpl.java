package de.kp.ames.map.client.openlayers.feature;

import de.kp.ames.map.client.openlayers.util.JSObject;

public class LabelFeatureImpl {

    public native static JSObject create(JSObject layer, JSObject lonlat)/*-{
    	return new $wnd.OpenLayers.Feature(layer, lonlat, null);
	}-*/;

}
