package de.tum.in.ase.pse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.easymock.EasyMock.*;

class MeteorologicalStationTest {

	private static final int TEST_HUMIDITY = 42;
	private static final int TEST_WINDSPEED = 0;
	private static final int TEST_TEMPERATURE = 13;

	// Our SUT
	private static MeteorologicalStationController controller;
	private static ApplicationContext context;

	@BeforeAll
	static void setUp() {
		// Initializes the context using TestConfig as the base configuration
		context = new AnnotationConfigApplicationContext(TestConfig.class);
		// Gets an instance of the MeteorologicalStationController from the injector
		controller = context.getBean(MeteorologicalStationController.class);
	}

	//	 TODO 9: Add a test testMeasure(): By uncommenting the following structure
	@Test
	void testMeasure() {
		/**
		 * Note: In this case, we are testing measure() method of the controller,
		 which makes calls to getTemperatureData(), getWindspeedData(), getHumidityData() of IMeteorologicalSensorArray
		 * => In this test case, only the mock of IMeteorologicalSensorArray is needed.
		 * Note that EasyMock is used as the framework for mocking.
		 */

		//TODO 10: Get an instance of the IMeteorologicalSensorArray from the mocked injector similar to the `controller`
		// This will then be our mocked collaborator
		IMeteorologicalSensorArray sensorArray = context.getBean(IMeteorologicalSensorArray.class);

		//TODO 11: Specify the `expected` behavior of the mock collaborator by mocking the return values of it's three
		// functions. Use the provided constants as expected return values
		expect(sensorArray.getTemperatureData()).andReturn(TEST_TEMPERATURE);
		expect(sensorArray.getWindspeedData()).andReturn(TEST_WINDSPEED);
		expect(sensorArray.getHumidityData()).andReturn(TEST_HUMIDITY);

		//TODO 12: Activate the mock by setting the mock object instance to replay mode
		replay(sensorArray);

		//TODO 13: Call measure() method of the SUT
		controller.measure();

		//TODO 14: Finally, verify the behavior of the mock
		verify(sensorArray);
	}
}
