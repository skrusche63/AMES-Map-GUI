package de.kp.ames.map.client.openlayers.popup;

import de.kp.ames.map.client.openlayers.LonLat;
import de.kp.ames.map.client.openlayers.OpenLayersObjectWrapper;
import de.kp.ames.map.client.openlayers.Size;
import de.kp.ames.map.client.openlayers.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
public class Anchored extends Popup {

	protected Anchored(JSObject element) {
		super(element);
	}

	public Anchored(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor, boolean closeBox) {
		this(AnchoredImpl.create(id,
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				anchor.getJSObject(),
				closeBox));
	}

}
