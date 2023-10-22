package de.tum.in.ase.pse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TrackRickMania {

	private static final long serialVersionUID = -1350200437285282550L;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 500;
	private static final int RANDOM_KEY_UPPER_BOUND = 2;
	private static final int NUMBER_OF_SIMULATIONS = 1000;

	private final Vehicle vehicle;
	private int currentX = 0;
	private int currentY = 0;

	public TrackRickMania(String name) {
		vehicle = VehicleFactory.getVehicle(name);
	}

	public static void main(String[] args) {
		// TODO Let the game begin...
		List<String> carNameList = Arrays.asList("Morty", "Rick");
		List<TrackRickMania> trackRickManias = new ArrayList<>();

		for (int i = 0; i < NUMBER_OF_SIMULATIONS; ++i) {
			int key = randomKey();
			trackRickManias.add(new TrackRickMania(carNameList.get(key)));
			trackRickManias.get(i).moveCar(randomCoordinateX(), randomCoordinateY());
		}

		System.out.println("Morty Instances: " + Car.getInstances());
		System.out.println("Rick Instances: " + RaceCar.getInstances());

	}

	public static int randomKey() {
		return ThreadLocalRandom.current().nextInt(0, RANDOM_KEY_UPPER_BOUND);
	}

	public static int randomCoordinateX() {
		return ThreadLocalRandom.current().nextInt(0, WIDTH);
	}

	public static int randomCoordinateY() {
		return ThreadLocalRandom.current().nextInt(0, HEIGHT);
	}

	public void moveCar(int newX, int newY) {
		vehicle.moveCar(currentX, currentY, newX, newY);
		currentX = newX;
		currentY = newY;
	}
}
