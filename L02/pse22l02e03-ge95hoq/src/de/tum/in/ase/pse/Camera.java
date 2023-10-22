package de.tum.in.ase.pse;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents our mock-camera-controller. The provided functions are used to
 * control the integrated camera module of the drone.
 * <p>
 * You do not have to change this class.
 */
public class Camera {

	public static final int TAKE_PICTURE_ID = 3;

	private final List<Integer> history; // Holds a history of the commands encoded in their numbers; You may not interact with this list

	public Camera() {
		history = new ArrayList<>();
	}

	/**
	 * Lets the drone fly forward
	 **/
	public void takePicture() {
		history.add(TAKE_PICTURE_ID);
		System.out.println("Drone took a beautiful picture and saved it to internal memory.");
	}

	public List<Integer> getHistory() {
		return history;
	}
}
