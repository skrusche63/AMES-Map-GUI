/**
 *
 */
package de.kp.ames.map.client.openlayers.geometry;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineStringImpl {

    public static native JSObject create(JSObject points)
    /*-{
        return new $wnd.gwt_openlayers_util.relay.createLineString(points);
    }-*/;
}
