package de.tum.in.ase.pse;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// TODO Part 1.5: implement Observer<Double>
public abstract class TemperatureGUI implements Observer<Double> {

	private static final int BORDER_SIZE = 4;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 110;

	private final String label;
	private final TemperatureModel model;
	private JFrame temperatureFrame;
	protected JPanel controlPanel;
	protected JTextField display;
	protected JButton raiseTempButton;
	protected JButton lowerTempButton;
	private final Point location;

	public TemperatureGUI(String label, TemperatureModel model, Point location) {
		this.model = model;
		this.label = label;
		this.location = location;
		createUI();
		// TODO Part 1.6: add the object as observer to the subject
		model.addObserver(this);
	}

	protected void createUI() {
		display = new JTextField();
		raiseTempButton = new JButton("Raise");
		lowerTempButton = new JButton("Lower");

		controlPanel = new JPanel(new BorderLayout());
		controlPanel.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
		controlPanel.add("North", new JLabel(label));
		controlPanel.add("Center", display);

		JPanel buttons = new JPanel();
		buttons.add(lowerTempButton);
		buttons.add(raiseTempButton);
		controlPanel.add("South", buttons);
	}

	public void show() {
		if (temperatureFrame == null) {
			temperatureFrame = new JFrame(label);
			temperatureFrame.add(controlPanel);
			temperatureFrame.addWindowListener(new TemperatureApplication.CloseListener());
			temperatureFrame.setSize(WIDTH, HEIGHT);
			temperatureFrame.setLocation(location);
		}
		temperatureFrame.setVisible(true);
	}

	public void setDisplay(String string) {
		display.setText(string);
	}

	public double getDisplay() {
		try {
			return Double.parseDouble(display.getText());
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			return 0.0;
		}
	}

	public void addDisplayListener(Runnable action) {
		display.addActionListener(e -> action.run());
	}

	public void addRaiseTempListener(Runnable action) {
		raiseTempButton.addActionListener(e -> action.run());
	}

	public void addLowerTempListener(Runnable action) {
		lowerTempButton.addActionListener(e -> action.run());
	}

	protected TemperatureModel getModel() {
		return model;
	}
}
