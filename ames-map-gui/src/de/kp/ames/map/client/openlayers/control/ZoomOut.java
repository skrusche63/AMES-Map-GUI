package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 * requires OpenLayers 2.7 or higher
 */
public class ZoomOut extends Control{

    protected ZoomOut(JSObject zoomOut){
        super(zoomOut);
    }

    public ZoomOut(){
        this(ZoomOutImpl.create());
    }
}
