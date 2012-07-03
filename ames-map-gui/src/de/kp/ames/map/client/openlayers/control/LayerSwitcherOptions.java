/**
 *
 */
package de.kp.ames.map.client.openlayers.control;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LayerSwitcherOptions extends ControlOptions {


	/**
	 *
	 * @param ascending - true to show layers in ascending alphabetical order
	 */
	public void setAscending(boolean ascending){
		getJSObject().setProperty("ascending", ascending);
	}

}
