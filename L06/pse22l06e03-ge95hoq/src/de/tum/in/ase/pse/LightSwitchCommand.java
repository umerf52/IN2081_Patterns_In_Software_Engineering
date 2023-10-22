package de.tum.in.ase.pse;

public abstract class LightSwitchCommand {
	private Light theLight;

	public Light getTheLight() {
		return theLight;
	}

	public void setTheLight(Light theLight) {
		this.theLight = theLight;
	}

	public abstract void execute();

}

