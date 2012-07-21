/*******************************************************************************
 * Copyright 2012 Dr. Krusche & Partner PartG
 *
 * All rights reserved.
 *   
 *******************************************************************************/

package de.kp.ames.map.client.openlayers.layer;

import de.kp.ames.map.client.openlayers.Style;
import de.kp.ames.map.client.openlayers.StyleMap;
import de.kp.ames.map.client.openlayers.feature.VectorFeature;
import de.kp.ames.map.client.openlayers.util.JSObject;

public class KMLLayer extends Layer {

	/**
	 * Constructor
	 * 
	 * @param element
	 */
	protected KMLLayer(JSObject element) {
		super(element);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param url
	 * @param projection
	 */
	public KMLLayer(String name, String url, String projection) {
		this(KMLLayerImpl.create(name, url, projection));
	}

	public int getFeatureCount(){
		return KMLLayerImpl.getFeatureCount(getJSObject());
	}

	public void drawFeature(VectorFeature feature) {
		KMLLayerImpl.drawFeature(this.getJSObject(), feature.getJSObject());
	}

	public void drawFeature(VectorFeature feature, Style style) {
		KMLLayerImpl.drawFeature(this.getJSObject(), feature.getJSObject(), style.getJSObject());
	}

	public VectorFeature[] getFeatures(){

		int cnt = getFeatureCount();
		if(cnt < 1) return null;

		VectorFeature[] features = new VectorFeature[cnt];
		for(int i = 0; i < cnt; i++){
			features[i] = VectorFeature.narrowToVectorFeature(KMLLayerImpl.getFeature(getJSObject(), i));
		}

		return features;

	};

	/**
	 * @param style
	 */
	public void setStyle(Style style){
		getJSObject().setProperty("style", style.getJSObject());
	}

	/**
	 * @param styleMap
	 */
	public void setStyleMap(StyleMap styleMap){
		getJSObject().setProperty("styleMap", styleMap.getJSObject());
	}
	
	/**
	 * Refresh layer
	 */
	public void refresh() {
		KMLLayerImpl.refresh(this.getJSObject());
	}
	
}
