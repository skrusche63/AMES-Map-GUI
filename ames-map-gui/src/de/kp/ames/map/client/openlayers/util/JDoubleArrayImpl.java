package de.kp.ames.map.client.openlayers.util;


public class JDoubleArrayImpl {

	public static native double get(JSObject array, int index)/*-{
		return array[index];
	}-*/;
}
