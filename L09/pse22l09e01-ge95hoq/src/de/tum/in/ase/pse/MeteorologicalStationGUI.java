package de.tum.in.ase.pse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * MeteorologicalStationGUI is a Java Swing implementation of the application's
 * GUI
 */
public class MeteorologicalStationGUI implements IMeteorologicalStationGUI {
	private static final String DEGREE_CELSIUS = " ℃";
	private static final int ROWS = 4;
	private static final int COLUMNS = 2;
	private static final int FRAME_X = 100;
	private static final int FRAME_Y = 100;
	private JFrame frame;
	private JLabel temperatureLabel;
	private JTextField temperatureTextField;
	private JLabel windspeedLabel;
	private JTextField windspeedTextField;
	private JLabel humidityLabel;
	private JTextField humidityTextField;
	private JButton measureData;
	private JButton saveData;
	private JPanel panel;
	private GridLayout layout;

	// TODO 3: Inject the controller
	@Inject
	private MeteorologicalStationController controller;

	public MeteorologicalStationGUI() {
		// TODO 2: Remove the explicit instantiation
		Injector injector = Guice.createInjector(new ProductionModule());
		controller = injector.getInstance(MeteorologicalStationController.class);
//		controller = new MeteorologicalStationController(this);
		frame = new JFrame("MeteoStation");
		temperatureLabel = new JLabel("Temperature:");
		temperatureTextField = new JTextField();
		temperatureTextField.setEditable(false);
		windspeedLabel = new JLabel("Windspeed:");
		windspeedTextField = new JTextField();
		windspeedTextField.setEditable(false);
		humidityLabel = new JLabel("Humidity");
		humidityTextField = new JTextField();
		humidityTextField.setEditable(false);
		measureData = new JButton("Measure");
		measureData.addActionListener(e -> controller.measure());
		saveData = new JButton("Save");
		saveData.addActionListener(e -> {
			try {
				controller.save();
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(frame, "Could not save to file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		layout = new GridLayout(ROWS, COLUMNS);
		panel = new JPanel(layout);
		panel.add(temperatureLabel);
		panel.add(temperatureTextField);
		panel.add(windspeedLabel);
		panel.add(windspeedTextField);
		panel.add(humidityLabel);
		panel.add(humidityTextField);
		panel.add(measureData);
		panel.add(saveData);
		frame.add(panel);
		frame.pack();
		frame.setLocation(FRAME_X, FRAME_Y);
	}

	public void show() {
		frame.setVisible(true);
	}

	public void displayHumidity(int humidity) {
		humidityTextField.setText(humidity + " %");
	}

	public void displayTemperature(int temperature) {
		temperatureTextField.setText(temperature + DEGREE_CELSIUS);
	}

	public void displayWindspeed(int windspeed) {
		windspeedTextField.setText(windspeed + " kn");
	}

}
