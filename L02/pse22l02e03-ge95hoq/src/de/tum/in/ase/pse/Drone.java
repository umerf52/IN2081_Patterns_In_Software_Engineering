package de.tum.in.ase.pse;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents our mock-motorcontroller. The provided functions are used to
 * control the flight and movement functions of the drone.
 * <p>
 * You do not have to change this class.
 */
public class Drone {

	public static final int FLY_FORWARD_ID = 0;
	public static final int FLY_UPWARD_ID = 1;
	public static final int FLY_HOME_ID = 2;

	private boolean flying;
	private final List<Integer> history; // Holds a history of the commands encoded in their numbers; You may not interact with this list

	public Drone() {
		flying = false;  // We start on the ground
		history = new ArrayList<>();
	}

	/**
	 * Lets the drone fly forward
	 **/
	public void flyForward(float speed) {
		history.add(FLY_FORWARD_ID);
		System.out.println("Drone flying forward with " + speed + "m/s.");
	}

	/**
	 * Lets the drone fly upward
	 **/
	public void flyUpward(float speed) {
		history.add(FLY_UPWARD_ID);
		System.out.println("Drone flying upwards with " + speed + "m/s.");
	}

	/**
	 * Tells the drone to fly to the starting point and land there
	 **/
	public void flyHome() {
		history.add(FLY_HOME_ID);
		System.out.println("Seeking home ...\nFound path home ...\nDrone arrived home.");
	}

	public boolean isFlying() {
		return flying;
	}

	public void setFlying(boolean flying) {
		this.flying = flying;
	}

	public List<Integer> getHistory() {
		return history;
	}
}
