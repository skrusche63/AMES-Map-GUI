package de.kp.ames.map.client.openlayers.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapBaseLayerChangedListener extends EventListener {

	class MapBaseLayerChangedEvent extends MapLayerEvent {

		public MapBaseLayerChangedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

	}

	public void onBaseLayerChanged(MapBaseLayerChangedEvent eventObject);
}
