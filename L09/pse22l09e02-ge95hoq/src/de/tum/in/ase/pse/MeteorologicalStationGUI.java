package de.tum.in.ase.pse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * MeteorologicalStationGUI is a Java Swing implementation of the application's
 * GUI
 */
@Component
public class MeteorologicalStationGUI implements IMeteorologicalStationGUI {
	private static final String DEGREE_CELSIUS = " ℃";
	private static final int ROWS = 4;
	private static final int COLUMNS = 2;
	private static final int FRAME_X = 100;
	private static final int FRAME_Y = 100;
	private JFrame frame;
	private JTextField temperatureTextField;
	private JTextField windspeedTextField;
	private JTextField humidityTextField;

	// The controller should be injected.
	// TODO 5 Add the appropriate Spring annotation to make the following attribute injectable
	@Autowired
	private MeteorologicalStationController controller;

	// TODO 6 After annotating the attribute properly the instance `controller` will be created automatically
	//  by the Spring framework through injection. Remove the constructor as it is not needed anymore!

	public void setUpGUI() {
		frame = new JFrame("MeteoStation");
		JLabel temperatureLabel = new JLabel("Temperature:");
		temperatureTextField = new JTextField();
		temperatureTextField.setEditable(false);
		JLabel windspeedLabel = new JLabel("Windspeed:");
		windspeedTextField = new JTextField();
		windspeedTextField.setEditable(false);
		JLabel humidityLabel = new JLabel("Humidity");
		humidityTextField = new JTextField();
		humidityTextField.setEditable(false);
		JButton measureData = new JButton("Measure");
		measureData.addActionListener(e -> controller.measure());
		JButton saveData = new JButton("Save");
		saveData.addActionListener(e -> {
			try {
				controller.save();
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(frame, "Could not save to file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		GridLayout layout = new GridLayout(ROWS, COLUMNS);
		JPanel panel = new JPanel(layout);
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
