package de.tum.in.ase.pse;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class Light {
	private final Label lightLabel;

	public Light(Label lightLabel) {
		this.lightLabel = lightLabel;
	}

	public void turnOn() {
		System.out.println("The light is on");
		lightLabel.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
	}

	public void turnOff() {
		System.out.println("The light is off");
		lightLabel.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	}
}
