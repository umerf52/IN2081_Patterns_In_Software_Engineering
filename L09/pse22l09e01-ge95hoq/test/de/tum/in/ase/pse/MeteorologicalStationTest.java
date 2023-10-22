package de.tum.in.ase.pse;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;

@SuppressWarnings("unused")
class MeteorologicalStationTest {

	private static final int TEST_HUMIDITY = 42;
	private static final int TEST_WINDSPEED = 0;
	private static final int TEST_TEMPERATURE = 13;

	private Injector injector; // Guice Injector
	private MeteorologicalStationController controller; // SUT

	@BeforeEach
	void setUp() {
		// TODO 9: Initialize the injector suitable for the testing context
		injector = Guice.createInjector(new TestModule());
		// TODO 10: Get an instance of MeteorologicalStationController from the injector
		controller = injector.getInstance(MeteorologicalStationController.class);
	}


	// TODO 11: Implement the following test case

	/**
	 * Note: In this case, we are testing measure() method of the controller, which makes calls to getTemperatureData(), getWindspeedData(), getHumidityData() of IMeteorologicalSensorArray
	 * => In this test case, only the mock of IMeteorologicalSensorArray is needed
	 */
	@Test
	void testMeasure() {
		// TODO 12: Get an instance of IMeteorologicalSensorArray mock from the injector
		IMeteorologicalSensorArray sensorArray = injector.getInstance(IMeteorologicalSensorArray.class);
		// TODO 13: Specify the expected behavior of the mock collaborator (use the provided return values TEST_HUMIDITY, TEST_WINDSPEED, TEST_TEMPERATURE)
		expect(sensorArray.getTemperatureData()).andReturn(TEST_TEMPERATURE);
		expect(sensorArray.getWindspeedData()).andReturn(TEST_WINDSPEED);
		expect(sensorArray.getHumidityData()).andReturn(TEST_HUMIDITY);
		// TODO 14: Make sure the mocked instance is ready to mock the expected behavior
		replay(sensorArray);
		// TODO 15: Test the measure() method of the SUT
		controller.measure();
		// TODO 16: Verify the behavior of the mock instance
		verify(sensorArray);
	}

}
