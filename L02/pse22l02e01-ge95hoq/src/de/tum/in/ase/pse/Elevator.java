package de.tum.in.ase.pse;

public final class Elevator {

	private Elevator() {
	}

	public static void main(String[] args) {

		int currentFloor = 1;
		Controller controller = new Controller(currentFloor);
		System.out.println(controller.getState().getName());
		// should be Idle

		controller.request(3);
		System.out.println(controller.getState().getName());
		// should be Moving

		controller.signal(2);
		System.out.println(controller.getState().getName());
		// should be Moving

		controller.signal(3);
		System.out.println(controller.getState().getName());
		// should be Stop

		controller.signal(3);
		System.out.println(controller.getState().getName());
		// should be Idle

		controller.request(6);
		System.out.println(controller.getState().getName());
		// should be Moving

		controller.request(2);
		System.out.println(controller.getState().getName());
		// should be Moving

		controller.signal(6);
		System.out.println(controller.getState().getName());
		// should be Stop

		controller.signal(6);
		System.out.println(controller.getState().getName());
		// should be Moving

		controller.signal(2);
		System.out.println(controller.getState().getName());
		// should be Stop

		controller.signal(2);
		System.out.println(controller.getState().getName());
		// should be Idle


		System.out.println("\n2nd elevator:");


		Controller controller2 = new Controller(2);
		System.out.println(controller2.getState().getName());
		// should be Idle

		controller2.request(3);
		System.out.println(controller2.getState().getName());
		// should be Moving

		controller2.request(5);
		System.out.println(controller2.getState().getName());
		// should be Moving

		controller2.request(6);
		System.out.println(controller2.getState().getName());
		// should be Moving

		controller2.request(4);
		System.out.println(controller2.getState().getName());
		// should be Moving

		controller2.signal(3);
		System.out.println(controller2.getState().getName());
		// should be Stop

		controller2.signal(3);
		System.out.println(controller2.getState().getName());
		// should be Moving

		controller2.signal(5);
		System.out.println(controller2.getState().getName());
		// should be Stop

		controller2.signal(5);
		System.out.println(controller2.getState().getName());
		// should be Moving

		controller2.signal(6);
		System.out.println(controller2.getState().getName());
		// should be Stop

		controller2.signal(6);
		System.out.println(controller2.getState().getName());
		// should be Moving

		controller2.signal(4);
		System.out.println(controller2.getState().getName());
		// should be Stop

		controller2.signal(4);
		System.out.println(controller2.getState().getName());
		// should be Idle
	}
}
