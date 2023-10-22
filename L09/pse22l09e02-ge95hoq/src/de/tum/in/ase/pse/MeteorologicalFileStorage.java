package de.tum.in.ase.pse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MeteorologicalFileStorage can save the meteorological data to a text file
 */
//Note: the interface should include the same method signatures as the ones below

public class MeteorologicalFileStorage implements IMeteorologicalFileStorage {
	private int temperature;
	private int windspeed;
	private int humidity;

	public MeteorologicalFileStorage() {
		System.out.println("MeteorologicalFileStorage Constructor.");
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void setWindspeed(int windspeed) {
		this.windspeed = windspeed;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void save() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		String datestring = formatter.format(new Date());
		Path file = Path.of(datestring + ".txt");
		String output = temperature + "\n" + windspeed + "\n" + humidity + "\n";
		Files.writeString(file, output, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
	}
}
