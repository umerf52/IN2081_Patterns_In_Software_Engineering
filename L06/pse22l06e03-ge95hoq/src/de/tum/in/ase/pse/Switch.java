package de.tum.in.ase.pse;

public class Switch {
	private final LightSwitchCommand flipUpCommand;
	private final LightSwitchCommand flipDownCommand;

	public Switch(LightSwitchCommand flipUpCmd, LightSwitchCommand flipDownCmd) {
		this.flipUpCommand = flipUpCmd;
		this.flipDownCommand = flipDownCmd;
	}

	public void flipUp() {
		flipUpCommand.execute();
	}

	public void flipDown() {
		flipDownCommand.execute();
	}
}
