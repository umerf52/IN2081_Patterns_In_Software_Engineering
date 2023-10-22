package de.tum.in.ase.pse;

public class FlipUpCommand extends LightSwitchCommand {
	public FlipUpCommand(Light light) {
		this.setTheLight(light);
	}

	public void execute() {
		getTheLight().turnOn();
	}
}
