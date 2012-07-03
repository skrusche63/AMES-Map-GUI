/**
 *
 */
package de.kp.ames.map.client.openlayers.control;


import de.kp.ames.map.client.openlayers.control.DrawFeature.FeatureAddedListener;
import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeatureOptions extends ControlOptions {

	//TODO: define HandlerOptions, probably in it's own class under handlers
	public class HandlerOptions extends ControlOptions {}

	public void onFeatureAdded(FeatureAddedListener listener){
		JSObject callback = DrawFeatureImpl.createFeatureAddedCallback(listener);
		getJSObject().setProperty("featureAdded", callback);
	}

	public void setHandlerOptions(HandlerOptions handlerOptions){
		getJSObject().setProperty("handlerOptions", handlerOptions.getJSObject());
	}
}
