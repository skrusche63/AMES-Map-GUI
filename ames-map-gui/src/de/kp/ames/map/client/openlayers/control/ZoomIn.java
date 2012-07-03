/**
 *
 */
package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 * requires OpenLayers 2.7 or higher
 */
public class ZoomIn extends Control{

    protected ZoomIn(JSObject zoomIn){
        super(zoomIn);
    }

    public ZoomIn(){
        this(ZoomInImpl.create());
    }

}
