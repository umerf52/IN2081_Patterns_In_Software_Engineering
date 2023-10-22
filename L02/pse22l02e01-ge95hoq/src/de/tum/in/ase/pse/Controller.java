package de.tum.in.ase.pse;

import java.util.LinkedList;
import java.util.List;

public class Controller {

	// TODO: implement attributes
	private int currentFloor;
	private List<Integer> pool;
	private ElevatorState state;
	// TODO: implement methods

	public Controller(int currentFloor) {
		this.currentFloor = currentFloor;
		this.state = new IdleState();
		this.pool = new LinkedList<>();
	}

	public void request(int floor) {
		// TODO
		state.request(floor, this);

	}

	public void signal(int floor) {
		// TODO
		state.signal(floor, this);
	}

	public ElevatorState getState() {
		// TODO
		return this.state;
	}

	public void setState(ElevatorState state) {
		this.state = state;
	}

	public int getNextStop() {
		// TODO
		return this.pool.get(0);
	}

	public List<Integer> getPool() {
		return this.pool;
	}

	public int getCurrentFloor() {
		return this.currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
}
