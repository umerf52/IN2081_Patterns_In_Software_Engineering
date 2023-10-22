package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Machine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The (sensor) controller class, miming a voltage sensor
 * This class forms an alternative controller type for the system.
 * Actually this only updates the machine's voltage, by simulating sensor inputs.
 */
public class VoltSensor {

	/**
	 * 1.1 TODO: Add a "machine" attribute for a machine the sensor should control AND update the constructor accordingly
	 */
	private Machine machine;

	private static int timestamp = 0;

	public VoltSensor(Machine machine) {
		this.machine = machine;

		//for simulating regular sensor input/update
		Timeline beat = new Timeline(
				new KeyFrame(Duration.ZERO, event -> sendValue()),
				new KeyFrame(Duration.seconds(1), event -> {
				})
		);
		beat.setAutoReverse(true);
		beat.setCycleCount(Animation.INDEFINITE);
		beat.play();
	}

	/**
	 * This method updates the current voltage of the machine (by using machine's setter).
	 * It simulates the new value by generating fluctuations around the target voltage.
	 * It uses the timestamp to create alternating values.
	 */
	protected void sendValue() {
		timestamp++;

		/**
		 * For some reason we currently only have a static target voltage. Let us fix this problem:
		 * 2.1 TODO: Update the value calculation by using the machine's target voltage instead of the static one here
		 */
		int targetVoltage = this.machine.getTargetVoltage();
		int value = (int) Math.max(Math.sin(timestamp) * 2 + targetVoltage, 0);

		/**
		 * 2.2 TODO: Update the machine's current voltage (the new value) using the machine's setter
		 */
		this.machine.setCurrentVoltage(value);
	}
}
