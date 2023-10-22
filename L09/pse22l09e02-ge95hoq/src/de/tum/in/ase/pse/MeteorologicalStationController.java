package de.tum.in.ase.pse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * MeteorologicalStationController contains the application logic and mediates
 * between the model and the view
 */
@Component
public class MeteorologicalStationController {

	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;

	//TODO 2: Add the appropriate Spring annotation to make the following three attributes injectable
	@Autowired
	private IMeteorologicalFileStorage storage;
	@Autowired
	private IMeteorologicalSensorArray sensorArray;
	@Autowired
	private IMeteorologicalStationGUI gui;

	// This constructor should be injected.
	//TODO 3: After annotating the attributes properly the instances will be created automatically
	// by the Spring framework through dependency injection
	// Remove the constructor altogether as it is redundant.

	public void measure() {
		currentTemperature = sensorArray.getTemperatureData();
		currentWindspeed = sensorArray.getWindspeedData();
		currentHumidity = sensorArray.getHumidityData();
		gui.displayTemperature(currentTemperature);
		gui.displayWindspeed(currentWindspeed);
		gui.displayHumidity(currentHumidity);
	}

	public void save() throws IOException {
		storage.setTemperature(currentTemperature);
		storage.setWindspeed(currentWindspeed);
		storage.setHumidity(currentHumidity);
		storage.save();
	}
}
