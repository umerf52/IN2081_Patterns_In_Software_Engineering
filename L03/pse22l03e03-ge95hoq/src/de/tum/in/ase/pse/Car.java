package de.tum.in.ase.pse;

public class Car extends Vehicle {

	public static final int SPEED = 100;
	private static int instances;

	public Car() {
		super("Morty", SPEED);
		instances++;
	}

	public static int getInstances() {
		return instances;
	}

	@Override
	public void moveCar(int currentX, int currentY, int newX, int newY) {
		System.out.printf("The Car %s moved with the speed of %d to the position with coordinates of X: %d and Y: %d%n", this.getName(), this.getSpeed(), newX, newY);
	}
}
