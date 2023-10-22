package de.tum.in.ase.pse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.io.IOException;

// TODO 4: Make the class a Guice module
public class MeteorologicalStationController {

	private IMeteorologicalStationGUI gui;
	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;
	//TODO 5: Tell Guice to inject this attribute. Make sure to use the newly created interfaces.
	@Inject
	private IMeteorologicalFileStorage storage;
	//TODO 6: Tell Guice to inject this attribute. Make sure to use the newly created interfaces.
	@Inject
	private IMeteorologicalSensorArray sensorArray;

	//TODO 7: Tell Guice to inject the Gui through the constructor
	@Inject
	public MeteorologicalStationController(IMeteorologicalStationGUI gui) {
		this.gui = gui;
		//TODO 8: Remove explicit instantiation of the attributes. Guice inject the instances for us.
		Injector injector = Guice.createInjector(new ProductionModule());
		storage = injector.getInstance(MeteorologicalFileStorage.class);
		sensorArray = injector.getInstance(MeteorologicalSensorArray.class);
//		this.storage = new MeteorologicalFileStorage();
//		this.sensorArray = new MeteorologicalSensorArray();
	}

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
