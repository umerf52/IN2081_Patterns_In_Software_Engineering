package de.tum.in.ase.pse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class TemperatureApplication {

	private TemperatureApplication() {
		// Private constructor because a utility class should not be instantiable.
	}

	//TODO Part 0: Before you start coding have a look at the project to create an overview & understanding how it works.
	//TODO Part 2: Create a new class KelvinGUI as subclass of TemperatureGUI and add it as observer to the TemperatureModel.

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		TemperatureModel temperature = new TemperatureModel();

		FahrenheitGUI fahrenheitGUI = new FahrenheitGUI(temperature, new Point(100, 100));
		fahrenheitGUI.show();

		CelsiusGUI celsiusGUI = new CelsiusGUI(temperature, new Point(100, 250));
		celsiusGUI.show();

		SliderGUI sliderGUI = new SliderGUI(temperature, new Point(300, 100));
		sliderGUI.show();

		GaugeGUI gaugeGUI = new GaugeGUI(temperature, new Point(300, 200));
		gaugeGUI.show();

		//TODO Part 2: Instantiate the new KelvinGUI here and show it.
		KelvinGUI kelvinGUI = new KelvinGUI(temperature, new Point(300, 300));
		kelvinGUI.show();
	}

	public static class CloseListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent event) {
			event.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}
