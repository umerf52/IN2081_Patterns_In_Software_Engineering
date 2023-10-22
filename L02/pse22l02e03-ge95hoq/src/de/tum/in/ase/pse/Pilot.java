package de.tum.in.ase.pse;


/**
 * The pilot uses the RemoteControl to fly the drone. His/ Her role is the client in the Command Pattern
 **/
public class Pilot {

	private Drone drone = new Drone();     // Creating the drone
	private Camera camera = new Camera();  // Creating the camera
	private RemoteControl remoteControl = new RemoteControl();

	public static void main(String[] args) {
		new Pilot().droneFlight();
	}

	/**
	 * This function lets the drone fly up, fly forward, take a picture and return home
	 * To accomplish this a remote has to be created and the correct commands have to be given
	 * to the remotes controlDrone(...) function
	 */
	public void droneFlight() {

		/** TODO: 1. Add the correct commands and calls to perform the required flight maneuvers **/
		remoteControl.controlDrone(new UpwardCommand(10, drone));
		remoteControl.controlDrone(new ForwardCommand(10, drone));
		remoteControl.controlDrone(new CapturePhotoCommand(camera));
		remoteControl.controlDrone(new ReturnHomeCommand(drone));
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public RemoteControl getRemoteControl() {
		return remoteControl;
	}

	public void setRemoteControl(RemoteControl remoteControl) {
		this.remoteControl = remoteControl;
	}
}
