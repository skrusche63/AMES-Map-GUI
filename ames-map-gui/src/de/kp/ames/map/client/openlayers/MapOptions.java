package de.kp.ames.map.client.openlayers;

import de.kp.ames.map.client.openlayers.util.JObjectArray;
import de.kp.ames.map.client.openlayers.util.JSObject;
import de.kp.ames.map.client.openlayers.util.JSObjectWrapper;


/**
 * <p>
 * Map properties can be configurated by passing a MapOptions object
 * to the {@link MapWidget} constructor. See also the {@link Map} javadoc.
 * </p>
 *
 * @author Erdem Gunay, Edwin Commandeur
 *
 */
public class MapOptions extends JSObjectWrapper {

	protected MapOptions(JSObject jsObject) {
		super(jsObject);
	}

	public MapOptions(){
		this(JSObject.createJSObject());
	}

	public void setNumZoomLevels(int numZoomLevels) {
		getJSObject().setProperty("numZoomLevels", numZoomLevels);
	}

	public void setControls(JObjectArray controls) {
		getJSObject().setProperty("controls", controls.getJSObject());
	}

	/**
	 * Use this method to change the default projection (EPSG:4326)
	 * to another projection.
	 *
	 * See http://spatialreference.org/ for EPSG codes for projections.
	 *
	 * Properties for default projection:
	 *   map.setProjection("EPSG:4326");
	 *   map.setMaxExtent(new Bounds(-180, -90, 180, 90));
	 *
	 * Some resources explaining map projections:
	 *   John P. Snyder (). Map Projections - A Working Manual
	 *   ISBN-13
	 *
	 * From the OpenLayers docs:
	 * Set in the map options to override the default projection on the map.
	 *  - also set maxExtent, maxResolution, and units if appropriate.
	 * @param projection
	 */
	public void setProjection(String projection) {
		getJSObject().setProperty("projection", projection);
	}

	/**
	 * Use this method to change the display projection
	 * to another projection.
	 *
	 * @param projection
	 */
	public void setDisplayProjection(Projection projection) {
		getJSObject().setProperty("displayProjection", projection.getJSObject());
	}

	/**
	 * The upper bounds of the spatial coordinate reference system, provided
	 * in the units that CRS.
	 * OR
	 * The upper bounds of the spatial data, provided in the units of the CRS
	 * in which the spatial data is served.
	 *
	 * @param maxExtent - a bounding rectangle
	 */
	public void setMaxExtent(Bounds maxExtent) {
		getJSObject().setProperty("maxExtent", maxExtent.getJSObject());
	}


	/**
	 * The lower bounds of the spatial coordinate reference system, provided
	 * in the units that CRS.
	 * OR
	 * The lower bounds of the spatial data, provided in the units of the CRS
	 * in which the spatial data is served.
	 *
	 * @param minExtent - a bounding rectangle
	 */
	public void setMinExtent(Bounds minExtent) {
		getJSObject().setProperty("minExtent", minExtent.getJSObject());
	}

	public void setRestrictedExtent(Bounds restrictedExtent) {
		getJSObject().setProperty("restrictedExtent", restrictedExtent.getJSObject());
	}

	/**
	 *
	 * See also setMaxResolutionToAuto.
	 *
	 * From the OpenLayers docs:
	 * Default max is 360 deg / 256 px (or 1,40625), which corresponds to
	 * zoom level 0 on gmaps.
	 */
	public void setMaxResolution(float maxResolution){
		getJSObject().setProperty("maxResolution", maxResolution);
	}

	public void setMinResolution(float minResolution){
		getJSObject().setProperty("minResolution", minResolution);
	}

	/**
	 * The units used by the map to express geospatial coordinates. These units
	 * should be consistent with the projection used.
	 *
	 * Use constants from the class MapUnits as input parameter.
	 * For example:
	 *  setUnits(MapUnits.DEGREES);
	 *
	 * These units are also used by map controls.
	 *
	 * From the OpenLayers docs:
	 * Defaults to degrees. Possible values are:
	 * degrees (or dd), mi, ft, km, mi, inches
	 */
	public void setUnits(String units){
		getJSObject().setProperty("units", units);
	}


	/**
	 * Convenience method for setting max resolution to auto.
	 *
	 * ???Best option when the map can be resized?
	 *
	 */
	public void setMaxResolutionToAuto(){
		getJSObject().setProperty("maxResolution", "auto");
	}

	public void setMaxScale(float maxScale){
		getJSObject().setProperty("maxScale", maxScale);
	}

	public void setMinScale(float minScale){
		getJSObject().setProperty("minScale", minScale);
	}

	public void setTileSize(Size size){
		getJSObject().setProperty("tileSize", size.getJSObject());
	}

	public void setZIndexBase(ZIndexBase zIndexBase){
		getJSObject().setProperty("Z_INDEX_BASE", zIndexBase.getJSObject());
	}

	/**
	 * By default, OpenLayers 2.7 adds Attribution, ArgParser, Navigation and PanZoom Controls.
	 */
	public void removeDefaultControls(){
		this.setControls(new JObjectArray(new JSObject[] {}));
	}
}
