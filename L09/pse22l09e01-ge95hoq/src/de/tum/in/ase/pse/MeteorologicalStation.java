package de.tum.in.ase.pse;

/**
 * MeteorologicalStation contains the main method and starts up the application
 */
public final class MeteorologicalStation {
	private MeteorologicalStation() {

	}

	public static void main(String[] args) {
		/**
		 *TODO: Instantiate an Injector with the ProductionModule
		 *TODO: Instantiate the class that needs the injection.
		 */
		IMeteorologicalStationGUI msgui = new MeteorologicalStationGUI();
		msgui.show();
	}
}
