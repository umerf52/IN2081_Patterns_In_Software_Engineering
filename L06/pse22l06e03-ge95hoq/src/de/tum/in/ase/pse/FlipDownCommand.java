package de.tum.in.ase.pse;

public class FlipDownCommand extends LightSwitchCommand {

	public FlipDownCommand(Light light) {
		this.setTheLight(light);
	}

	public void execute() {
		getTheLight().turnOff();
	}
}
