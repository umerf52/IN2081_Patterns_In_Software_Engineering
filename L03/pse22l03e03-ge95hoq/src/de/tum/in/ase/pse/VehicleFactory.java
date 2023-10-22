package de.tum.in.ase.pse;

import java.util.HashMap;
import java.util.Map;

public final class VehicleFactory {

	private static final Map<String, Vehicle> cache = new HashMap<>();

	private VehicleFactory() {
	}

	public static Vehicle getVehicle(String name) {
		//TODO If the key exists, return the vehicle from the map
		if (cache.containsKey(name)) {
			return cache.get(name);
		}
		//If key does not exist in Map, create flyweight, put it in Map, and return the object
		Vehicle vehicle = switch (name) {
			case "Morty" -> new Car();
			case "Rick" -> new RaceCar(); // TODO Instantiate a corresponsing car type for "Rick"
			default -> throw new IllegalArgumentException("Unsupported car type.");
		};

		cache.put(name, vehicle);
		return vehicle;
	}
}
