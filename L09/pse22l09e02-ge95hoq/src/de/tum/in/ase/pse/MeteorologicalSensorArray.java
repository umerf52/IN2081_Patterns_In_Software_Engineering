package de.tum.in.ase.pse;

import java.util.concurrent.ThreadLocalRandom;

/**
 * MeteorologicalSensorArray provides us with meteorological data
 */
//Note: the interface should include the same method signatures as the ones below

public class MeteorologicalSensorArray implements IMeteorologicalSensorArray {

	private static final int BOUNDARY_TEMPERATURE = 41;
	private static final int BOUNDARY_WIND_HUMIDITY = 100;

	public int getTemperatureData() {
		return ThreadLocalRandom.current().nextInt(BOUNDARY_TEMPERATURE);
	}

	public int getWindspeedData() {
		return ThreadLocalRandom.current().nextInt(BOUNDARY_WIND_HUMIDITY);
	}

	public int getHumidityData() {
		return ThreadLocalRandom.current().nextInt(BOUNDARY_WIND_HUMIDITY);
	}
}
