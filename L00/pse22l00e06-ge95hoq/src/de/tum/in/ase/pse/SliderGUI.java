package de.tum.in.ase.pse;

import java.awt.Adjustable;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

// TODO Part 1.4: implement Observer<Double>
public class SliderGUI implements Observer<Double> {

	private static final int MIN_VALUE = -20;
	private static final int MAX_VALUE = 160;
	private static final int SCROLLBAR_EXTENT = 10;

	private static final int WIDTH = 250;
	private static final int HEIGHT = 60;

	private final TemperatureModel model;
	private final Point location;
	protected JFrame sliderFrame;
	protected JScrollBar tempControl;

	/**
	 * Set this temporarily to true when setting the tempControl value during the update to avoid this adjustment to cause another update
	 */
	private boolean updatedBySubject;

	public SliderGUI(TemperatureModel model, Point location) {
		this.model = model;
		this.location = location;
		createUI();
		// TODO Part 1.6: add the object as observer to the subject
		tempControl.addAdjustmentListener(new SlideListener());
		model.addObserver(this);
	}

	protected void createUI() {
		tempControl = new JScrollBar(Adjustable.HORIZONTAL, 0, SCROLLBAR_EXTENT, MIN_VALUE, MAX_VALUE);
	}

	public void show() {
		if (sliderFrame == null) {
			sliderFrame = new JFrame("Celsius");
			sliderFrame.add(tempControl);
			sliderFrame.setSize(WIDTH, HEIGHT);
			sliderFrame.setLocation(location);
			sliderFrame.addWindowListener(new TemperatureApplication.CloseListener());
		}
		sliderFrame.setVisible(true);
	}

	//TODO Part 1.4: Implement onUpdate:
	// invoke setValue on tempControl with the new Celsius value (converted to int) to move the slider thumb
	// set updatedBySubject temporarily to true before updating to avoid creating looping updates

	@Override
	public void onUpdate(Double newState) {
		updatedBySubject = true;
		tempControl.setValue(newState.intValue());
		updatedBySubject = false;
	}

	class SlideListener implements AdjustmentListener {
		@Override
		public void adjustmentValueChanged(AdjustmentEvent event) {
			// don't update the model if the position was changed by an update
			if (!updatedBySubject) {
				model.setC(tempControl.getValue());
			}
		}
	}
}
