package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMapImpl {

    public static native JSObject create()/*-{
        return new $wnd.OpenLayers.Control.OverviewMap();
    }-*/;

    public static native JSObject create(JSObject params)/*-{
        return new $wnd.OpenLayers.Control.OverviewMap(params);
    }-*/;
}
