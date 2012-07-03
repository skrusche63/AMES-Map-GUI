package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ZoomInImpl {

    public static native JSObject create()/*-{
        return new $wnd.OpenLayers.Control.ZoomIn();
    }-*/;

}
