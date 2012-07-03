/**
 *
 */
package de.kp.ames.map.client.openlayers.geometry;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class GeometryImpl {

    public static native void destroy(JSObject self)/*-{
        self.destroy();
    }-*/;

	public static native JSObject getBounds(JSObject geom)/*-{
		return geom.getBounds();
    }-*/;

}
