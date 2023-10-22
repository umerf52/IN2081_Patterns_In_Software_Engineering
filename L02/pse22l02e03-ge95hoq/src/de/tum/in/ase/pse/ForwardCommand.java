package de.tum.in.ase.pse;


/**
 * This class represents the command used to tell the drone to fly forwards at a given speed
 * Upon creation we have to pass the drone object  we want to control with this command
 */

/**
 * TODO: 1. Add the correct interface
 **/
public class ForwardCommand implements Command {

	private float forwardSpeed;                     // The speed we want the drone to go
	private Drone drone;        // The reference to the drones motorController

	public ForwardCommand(float forwardSpeed, Drone drone) {
		this.forwardSpeed = forwardSpeed;
		this.drone = drone;
	}

	@Override
	public void execute() {
		if (drone.isFlying()) {
			drone.flyForward(forwardSpeed);
		} else {
			System.out.println("Drone has not yet started.");
		}
	}

	/** TODO: 2. Implement the function defined from the interface
	 * The function should tell the drone to fly forward if the drone has started or print an error message, if
	 * the drone is still on the ground
	 * Hint: You can use the drone.flying flag to check whether the drone is in the air or not
	 */

}
