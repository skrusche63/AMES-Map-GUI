package de.kp.ames.map.client;
/**
 * This file is part of the AMES Map GUI.
 *
 * AMES Map GUI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AMES Map GUI is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the AMES Map GUI.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2012 Dr. Krusche & Partner PartG <team@dr-kruscheundpartner.de>
 *
 */

import java.util.ArrayList;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.WidgetCanvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.events.ResizedEvent;
import com.smartgwt.client.widgets.events.ResizedHandler;
import com.smartgwt.client.widgets.events.RightMouseDownEvent;
import com.smartgwt.client.widgets.events.RightMouseDownHandler;
import com.smartgwt.client.widgets.layout.VLayout;

import de.kp.ames.map.client.listener.MapListener;
import de.kp.ames.map.client.openlayers.Bounds;
import de.kp.ames.map.client.openlayers.Map;
import de.kp.ames.map.client.openlayers.MapOptions;
import de.kp.ames.map.client.openlayers.MapWidget;
import de.kp.ames.map.client.openlayers.Pixel;
import de.kp.ames.map.client.openlayers.Size;
import de.kp.ames.map.client.openlayers.control.DragFeature;
import de.kp.ames.map.client.openlayers.control.DragFeatureOptions;
import de.kp.ames.map.client.openlayers.control.MousePosition;
import de.kp.ames.map.client.openlayers.control.Navigation;
import de.kp.ames.map.client.openlayers.control.OverviewMap;
import de.kp.ames.map.client.openlayers.control.PanZoomBar;
import de.kp.ames.map.client.openlayers.control.ScaleLine;
import de.kp.ames.map.client.openlayers.control.SelectFeature;
import de.kp.ames.map.client.openlayers.control.SelectFeatureOptions;
import de.kp.ames.map.client.openlayers.control.DragFeature.CompleteListener;
import de.kp.ames.map.client.openlayers.control.DragFeature.DragListener;
import de.kp.ames.map.client.openlayers.control.DragFeature.StartDragListener;
import de.kp.ames.map.client.openlayers.control.SelectFeature.SelectFeatureListener;
import de.kp.ames.map.client.openlayers.control.SelectFeature.UnselectFeatureListener;
import de.kp.ames.map.client.openlayers.event.LayerLoadEndListener;
import de.kp.ames.map.client.openlayers.feature.VectorFeature;
import de.kp.ames.map.client.openlayers.geometry.Point;
import de.kp.ames.map.client.openlayers.layer.Layer;
import de.kp.ames.map.client.openlayers.layer.Vector;
import de.kp.ames.map.client.openlayers.layer.WMS;
import de.kp.ames.map.client.openlayers.layer.WMSParams;
import de.kp.ames.map.client.openlayers.popup.FramedCloud;
import de.kp.ames.map.client.openlayers.util.JObjectArray;
import de.kp.ames.map.client.openlayers.util.JSObject;
import de.kp.ames.map.client.style.MapStyle;
import de.kp.ames.map.client.util.MapLoader;
import de.kp.ames.web.shared.constants.JaxrConstants;

public class BaseMapImpl extends VLayout {

	private boolean rendered = false;
	
	private WidgetCanvas canvas;
	
	private MapWidget mapWidget;
	protected Map map;

	/*
	 * Layers
	 */
	private WMS wmsLayer;
	/*
	 * The common vector layer supports the 
	 * visualization of individual features 
	 */
	protected Vector featureLayer;
	protected ArrayList<String> featureKeys;
	
	/*
	 * Map bounds
	 */
	private Bounds bounds;
		
	private SelectFeature selectControl;
	private VectorFeature selectedFeature;

	private static int ICON_SHIFT     = 18; 
	private static int NUM_ZOOM_LEVEL = 18;
	
	/* 
	 * Drag & drop support for the map plugin
	 */
	private DragFeature dragControl;	
	private boolean afterDrag = false;
	
	private static String SELECT_COLOR   = "#e00000";
	private static String UNSELECT_COLOR = "#566d99";
		
	private static final String INITIAL_WIDTH  = "400px";
	private static final String INITIAL_HEIGHT = "400px";
		
	private static final String BG_COLOR = "0xF2EFE9";
	private MapConfig mapConfig;

	/*
	 * OpenLayers attributes that are common to vector features
	 */
	protected static String FEA_ATTR_DESC = "description";
	protected static String FEA_ATTR_KEY  = "key";
	protected static String FEA_ATTR_NAME = "name";

	/*
	 * Reference to core attributes that are used to
	 * support this map plugin
	 */
	private static String RIM_ID = JaxrConstants.RIM_ID;
	
	private static String SLOT_LATITUDE  = JaxrConstants.SLOT_LATITUDE;
	private static String SLOT_LONGITUDE = JaxrConstants.SLOT_LONGITUDE;

	/*
	 * Reference to POINT geometry
	 */
	private static String POINT_GEOM = "OpenLayers.Geometry.Point";
	
	/*
	 * Layer Management: Counter
	 */
	int layerCounter = 0;

	/* 
	 * Reference to the MapListener
	 */
	private MapListener mapListener;
	
	/**
	 * Constructor requires JSON formatted map data and map listener
	 * 
	 * @param jGeoInfo
	 * @param listener
	 */
	public BaseMapImpl(MapConfig jGeoInfo, MapListener listener) {
			
		/* 
		 * Register JSON formatted basic map data
		 * (refers to WMS base layer)
		 */
		this.mapConfig = jGeoInfo;
		
		/* 
		 * Register MapListener
		 */
		this.mapListener = listener;

		/*
		 * Rendering Hint:
	     *
		 * It is important not to assign an 'overflow:hidden' 
		 * (see below) at this level; the background color 
		 * assiged is adapted to google maps color
		 */
		
		this.setShowEdges(false);
		this.setBackgroundColor(MapStyle.GOOLGE_MAP_COLOR);
		
		this.setWidth100();
		this.setHeight100();

		/*
		 * Create map
		 */
        this.createMap();
			
        /*
         *  Initialize Event Handling
         */
		final BaseMapImpl self = this;		
		
		/*
		 * Initiate Click Handler to enable a popup window
		 * on a certain (selected) vector feature
		 */
		this.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				if (afterDrag) {
					afterDrag = false;
				
				} else {
				
					if (selectedFeature == null) return;

					/*
					 * Create popup window
					 */
					String content = createPopupContent();
					FramedCloud popup = new FramedCloud("chicken", selectedFeature.getCenterLonLat(), new Size(100,100), content, null, true);
	
					selectedFeature.setPopup(popup);
					map.addPopup(popup);
					
				}
			}			
		});
		
		/*
		 * Initiate ResizeHandler; this is essential to
		 * smoothly integrate an OpenLayers map into a
		 * SmartGWT environment
		 */
		this.addResizedHandler(new ResizedHandler() {
			public void onResized(ResizedEvent event) {
				self.resizeMap();
			}
			
		});
		
		/*
		 * This Event Handler is used to enable a context
		 * menu for the selected vector feature
		 */
		this.addRightMouseDownHandler(new RightMouseDownHandler() {
			public void onRightMouseDown(RightMouseDownEvent event) {
				if (selectedFeature == null) return;
				self.createFeatureMenu();
			}
		});
			
		this.addDrawHandler(new DrawHandler() {
			public void onDraw(DrawEvent event) {				

				SC.logWarn("====> BaseMap.onDraw");
				
				self.rendered = true;

				/*
				 *  onDraw is only called one time on startup
				 *  all other resizes will be caught by onResized
				 *  
				 *  Different size updates will be triggered 
				 */
				
				// triggers resize of openlayers to 100%
				self.resizeMap();
				
				// triggers resize of loaded map layer to 100% based on its boundingbox
				map.zoomToExtent(bounds);
				
				// triggers resize of canvas to 100% 
				// this is necessary when Map is embedded within a tab or other complex layout
				canvas.setWidth100();
				canvas.setHeight100();
			}			
		});
		
	}
	 
	/**
	 * A helper method to create the popup content
	 * from the attributes of the selected feature
	 * 
	 * @return
	 */
	private String createPopupContent() {

		/*
		 * Show name & description in a popup window
		 */
		String name = selectedFeature.getAttributeAsString(FEA_ATTR_NAME);
		
		String desc = selectedFeature.getAttributeAsString(FEA_ATTR_DESC);
		desc = (desc == null) ? "No description available." : desc;

		String content = "<h2>" + name + "</h2>" + desc;
		return content;
				
	}
	
	/**
	 * A place holder method to assign a context menu to the
	 * vector features assigned to the map
	 */
	protected void createFeatureMenu() {
		
	}

	
	/**
	 * This method retrieves key and coordinates of the
	 * vector feature assigned to the feature layer to
	 * enable respective modification within the registry
	 * 
	 * @return
	 */
	public JSONArray getCoordinates() {
		
		JSONArray jCoordinates = new JSONArray();
		
		VectorFeature[] features = featureLayer.getFeatures();
		for (int i=0; i < features.length; i++) {
			
			VectorFeature feature = features[i];
			if (feature.getGeometry() == null) continue;
			
			/*
			 * Get LatLon
			 */
			Double[] latlon = getFeatureLatLon(feature);
			if (latlon == null) continue;

			/* 
			 * Additional information (from extended data)
			 */
			JSObject attributes = feature.getAttributes();
			if (attributes == null) continue;	

			String latitude  = String.valueOf(latlon[0]);
			String longitude = String.valueOf(latlon[1]);
			
			String key = feature.getAttributeAsString(FEA_ATTR_KEY);

			/*
			 * Create JSON transfer data
			 */
			JSONObject jCoordinate = new JSONObject();
			
			jCoordinate.put(RIM_ID,        new JSONString(key));
			jCoordinate.put(SLOT_LATITUDE,  new JSONString(latitude));
			jCoordinate.put(SLOT_LONGITUDE, new JSONString(longitude));
			
			jCoordinates.set(jCoordinates.size(), jCoordinate);
			
		}
		
		return jCoordinates;
		
	}
					
	/************************************************************************
	 * 
	 * MAP SUPPORT     MAP SUPPORT     MAP SUPPORT     MAP SUPPORT     MAP
	 * 
	 ***********************************************************************/

	// this method 
	private void createMap() {
		
		SC.logWarn("====> BaseMapInpl.createMap()");
		
		/* 
		 * Create wms base layer
		 */
		createWMSBaseLayer();
			
		/*
		 *  Create common feature layer
		 */
		featureLayer = new Vector("Feature Layer");
		featureLayer.setIsVisible(false);
			
		/*
		 * Create additional layer here
		 */
		
		Layer[] mapLayers = new Layer[] {wmsLayer,featureLayer};
		
		/* 
		 * Initialize map widget & map
		 */
		MapOptions mapOptions = new MapOptions();

		mapOptions.setControls(new JObjectArray(new JSObject[] {}));
		mapOptions.setNumZoomLevels(NUM_ZOOM_LEVEL);
		/*
		 * Set projection
		 */
		mapOptions.setProjection(mapConfig.getSrs());
			
		mapWidget = new MapWidget(INITIAL_WIDTH, INITIAL_HEIGHT, mapOptions);		
		map = mapWidget.getMap();

		canvas = new WidgetCanvas(mapWidget);
		
		/*
		 * Rendering Hint:
		 * 
		 * Overflow hidden is essential; otherwise, we have
		 * rendering problems concerning the height of the map 
		 */
		
		canvas.setOverflow(Overflow.HIDDEN);
		
		canvas.setWidth100();
		canvas.setHeight100();
		
		this.addMember(canvas);			
		map.addLayers(mapLayers);
					
		/* 
		 * Event handling for select control
		 */
		SelectFeatureListener selectListener = new SelectFeatureListener() {
			public void onFeatureSelected(VectorFeature feature) {

				feature.setFontColor(SELECT_COLOR);
				feature.getVector().drawFeature(feature);

				selectedFeature = feature;

			}
		};

		UnselectFeatureListener unSelectListener = new UnselectFeatureListener() {
			public void onFeatureUnselected(VectorFeature feature) {

				feature.setFontColor(UNSELECT_COLOR);
				feature.getVector().drawFeature(feature);

				selectedFeature = null;
				
			}
		};
			
		/* 
		 * This is the only way to set selection options properly
		 */
		SelectFeatureOptions selectOptions = new SelectFeatureOptions();
		
		selectOptions.onSelect(selectListener);
		selectOptions.onUnSelect(unSelectListener);
		
		selectOptions.setHover();
		selectOptions.setToggle();
			
		selectControl = new SelectFeature(featureLayer, selectOptions);
		map.addControl(selectControl);

		selectControl.activate();

		/* 
		 * Event handling for drag control
		 */
		StartDragListener startDragListener = new StartDragListener() {
			public void onStart(VectorFeature feature, Pixel pixel) {
				/*
				 * Nothing to do
				 */
			}
		};
	
		DragListener dragListener = new DragListener() {
			public void onDrag(VectorFeature feature, Pixel pixel) {

				/*
				 * Get LatLon
				 */
				Double[] latlon = getFeatureLatLon(feature);
				if (latlon == null) return;

				/* 
				 * Additional information (from extended data)
				 */
				JSObject attributes = feature.getAttributes();
				if (attributes == null) return;	

				double lat = latlon[0];
				double lon = latlon[1];

				String key = feature.getAttributeAsString(FEA_ATTR_KEY);
				if (mapListener != null) mapListener.onDrag(key, lat, lon);

			}
		};

		CompleteListener completeListener = new CompleteListener() {
			public void onComplete(VectorFeature feature, Pixel pixel) {

				/* 
				 * Synchronize flag with click event
				 */
				afterDrag = true;

				/*
				 * Get LatLon
				 */
				Double[] latlon = getFeatureLatLon(feature);
				if (latlon == null) return;

				/* 
				 * Additional information (from extended data)
				 */
				JSObject attributes = feature.getAttributes();
				if (attributes == null) return;	

				double lat = latlon[0];
				double lon = latlon[1];

				String key = feature.getAttributeAsString(FEA_ATTR_KEY);
				if (mapListener != null) mapListener.onDragComplete(key, lat, lon);

			}
		};

		/*
		 * Drag support
		 */
		DragFeatureOptions dragFeatureOptions = new DragFeatureOptions();
		
		dragFeatureOptions.onStart(startDragListener);
		dragFeatureOptions.onDrag(dragListener);
		dragFeatureOptions.onComplete(completeListener);
		
		dragControl = new DragFeature(featureLayer, dragFeatureOptions);
		map.addControl(dragControl);
		
		dragControl.activate();
		
		/* 
		 * Add controls to map
		 */
		map.addControl(new PanZoomBar());
	
		map.addControl(new MousePosition());
		map.addControl(new ScaleLine());
		map.addControl(new Navigation());
		//map.addControl(new LayerSwitcher());
		map.addControl(new OverviewMap());

		map.zoomToExtent(bounds);
		
	}

	/**
	 * A helper method to retrieve (lat,lon) coordinates
	 * from a feature with point geometry
	 * 
	 * @param feature
	 * @return
	 */
	private Double[] getFeatureLatLon(VectorFeature feature) {
		
		/* 
		 * This method is actually restricted to point geometry
		 */
		String geometryClass = feature.getGeometryClassName();
		if (!geometryClass.equals(POINT_GEOM)) return null;

		Point point = Point.narrowToPoint(feature.getGeometry());
		
		/* 
		 * The position sent to the drawing canvas must be corrected
		 * due the icon induced shift of the feature representation
		 */
		
		double lon = point.getX() - ICON_SHIFT*map.getResolution();
		double lat = point.getY();

		return new Double[] {lat, lon};
		
	}
	
	/**
	 * A helper method to create a base WMS layer
	 */
	private void createWMSBaseLayer() {
		
		/* 
		 * Set WMS parameters
		 */
		
		SC.logWarn("====> BaseMapInpl.createWMSBaselayer() 1");

		WMSParams wmsParams = new WMSParams();
		wmsParams.setFormat("image/png");
		wmsParams.setStyles("");

		bounds = mapConfig.getBounds();

		SC.logWarn("====> BaseMapInpl.createWMSBaselayer() 2");
		
		wmsParams.setMaxExtent(bounds);
		//wmsParams.setIsTransparent(true);
		
		wmsParams.setLayers(mapConfig.getWmsLayers());
		wmsParams.setBGColor(BG_COLOR);

		SC.logWarn("====> BaseMapInpl.createWMSBaselayer() 3");

		String name   = mapConfig.getWmsName();
		String server = mapConfig.getWmsServer();

		SC.logWarn("====> BaseMapInpl.createWMSBaselayer() 4");

		wmsLayer = new WMS(name, server, wmsParams);
		wmsLayer.addLayerLoadEndListener(new LayerLoadEndListener() {
			public void onLoadEnd(LoadEndEvent eventObject) {
				MapLoader.getInstance().reset();
				/* 
				 * Set feature layer to visible
				 */
				featureLayer.setIsVisible(true);
			}
		});
		
	}
				
	/**
	 * A helper method that is essential for proper
	 * integration of OpenLayers into SmartGWT
	 */
	private void resizeMap() {

		SC.logWarn("=====>resizeMap() rendered: " + this.rendered);
		
		if (this.rendered == false) return;
		
		if ((mapWidget == null) || (map == null)) return;
		
		int w = this.getInnerContentWidth();
		int h = this.getInnerContentHeight();
		
		String widthStr  = String.valueOf(w) + "px";
		String heightStr = String.valueOf(h) + "px";
		
		mapWidget.setWidth(widthStr);
		mapWidget.setHeight(heightStr);

		/*
		 * Finally update size
		 */
		map.updateSize();

	}
	
}
