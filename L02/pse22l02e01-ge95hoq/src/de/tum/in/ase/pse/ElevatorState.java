package de.tum.in.ase.pse;

public abstract class ElevatorState {

	// this means that a new floor was requested (a user pressed the elevator button)
	public abstract void request(int floor, Controller controller);

	// this means the elevator reached a new floor that was requested
	public abstract void signal(int floor, Controller controller);

	// this returns the name of the current state (e.g. 'idle')
	public abstract String getName();
}
