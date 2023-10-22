package de.tum.in.ase.pse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MeteorologicalStation contains the main method and starts up the application
 */
public final class MeteorologicalStation {

	private MeteorologicalStation() {
		// prevents calls from MeteorologicalStation, Main class can't be instantiated
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IMeteorologicalStationGUI gui = context.getBean(IMeteorologicalStationGUI.class);
		gui.setUpGUI();
		gui.show();
	}
}
