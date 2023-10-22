package de.tum.in.ase.pse;

import org.springframework.context.annotation.Bean;

public class AppConfig {
	@Bean
	public MeteorologicalStationController controller() {
		//TODO 4 Modify the constructor parameter accordingly
		return new MeteorologicalStationController();
	}

	@Bean
	public IMeteorologicalStationGUI gui() {
		return new MeteorologicalStationGUI();
	}

	//TODO 1: Create Beans for IMeteorologicalSensorArray and IMeteorologicalFileStorage
	// They will then be injected automatically by Spring
	@Bean
	public IMeteorologicalSensorArray sensorArray() {
		return new MeteorologicalSensorArray();
	}

	@Bean
	public IMeteorologicalFileStorage storage() {
		return new MeteorologicalFileStorage();
	}

}
