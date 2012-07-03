package de.kp.ames.map.client.openlayers.layer;

import de.kp.ames.map.client.openlayers.util.JSObject;

/**
 * See {@link Image}
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class ImageImpl {

	public static native JSObject create(String name, String url, JSObject extent, JSObject size, JSObject params)/*-{
		return new $wnd.OpenLayers.Layer.Image(name, url, extent, size, params);
	}-*/;

	public static native JSObject getExtent(JSObject self)/*-{
		return self.extent;
	}-*/;

	public static native JSObject getSize(JSObject self)/*-{
		return self.size;
	}-*/;

	public static native String getUrl(JSObject self)/*-{
		return self.url;
	}-*/;

	public static native void setUrl(JSObject self, String url)/*-{
		self.url = url;
	}-*/;
}
