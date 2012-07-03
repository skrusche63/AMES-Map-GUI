package de.kp.ames.map.client.openlayers.control;

import de.kp.ames.map.client.openlayers.control.DrawFeature.FeatureAddedListener;
import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class DrawFeatureImpl {

	public static native JSObject create(JSObject layer, JSObject handler)/*-{
		return new $wnd.OpenLayers.Control.DrawFeature(layer, handler);
	}-*/;

	public static native JSObject create(JSObject layer, JSObject handler, JSObject options)/*-{
		return new $wnd.OpenLayers.Control.DrawFeature(layer, handler, options);
	}-*/;

	public static native JSObject createFeatureAddedCallback(FeatureAddedListener listener)/*-{
		var callback = function(obj){
			var vectorFeatureObj = @de.kp.ames.map.client.openlayers.feature.VectorFeature::narrowToVectorFeature(Lde/kp/ames/map/client/openlayers/util/JSObject;)(obj);
			listener.@de.kp.ames.map.client.openlayers.control.DrawFeature.FeatureAddedListener::onFeatureAdded(Lde/kp/ames/map/client/openlayers/feature/VectorFeature;)(vectorFeatureObj);
		}
		return callback;
	}-*/;

}
