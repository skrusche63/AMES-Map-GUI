package de.kp.ames.map.client.openlayers.event;


import de.kp.ames.map.client.openlayers.feature.VectorFeature;
import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class VectorFeatureEvent extends VectorEvent {

	protected VectorFeatureEvent(JSObject eventObject) {
		super(eventObject);
	}

	public VectorFeature getVectorFeature(){
		JSObject object = getJSObject().getProperty("feature");
		return (object!=null)?VectorFeature.narrowToVectorFeature(object):null;
	}

}
