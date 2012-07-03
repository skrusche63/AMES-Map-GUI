package de.kp.ames.map.client.openlayers;

import de.kp.ames.map.client.openlayers.util.JSObject;

public class StyleMapImpl {

    public static native JSObject create(JSObject defaultStyle) /*-{
    	
    	var styles = {'default': defaultStyle};
    	return new $wnd.OpenLayers.StyleMap(styles);
    	
	}-*/;

}
