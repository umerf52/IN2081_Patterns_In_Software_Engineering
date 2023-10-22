package de.tum.in.ase.pse;

import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;

public class TestConfig {
	@Bean
	public MeteorologicalStationController controller() {
		// TODO 8 Modify the constructor parameter accordingly
		return new MeteorologicalStationController();
	}

	@Bean
	public IMeteorologicalStationGUI gui() {
		return EasyMock.createMock(MeteorologicalStationGUI.class);
	}

	//TODO 7: Create Beans for IMeteorologicalSensorArray and IMeteorologicalFileStorage
	// They will then be injected automatically by Spring
	// Use EasyMock's createMock function to create mock objects of the interfaces implementation
	// instead of the actual implementation
	@Bean
	public IMeteorologicalSensorArray sensorArray() {
		return EasyMock.createMock(MeteorologicalSensorArray.class);
	}

	@Bean
	public IMeteorologicalFileStorage storage() {
		return EasyMock.createMock(MeteorologicalFileStorage.class);
	}
}
