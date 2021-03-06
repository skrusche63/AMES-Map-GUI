package de.kp.ames.map.client.openlayers.format;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * Brief explanation of GeoJSON vector format here.
 *
 * Reference to GeoJSON specification.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class GeoJSON extends VectorFormat {

	protected GeoJSON(JSObject geoJSONFormat){
		super(geoJSONFormat);
	}

	public GeoJSON(){
		this(GeoJSONImpl.create());
	}

}
