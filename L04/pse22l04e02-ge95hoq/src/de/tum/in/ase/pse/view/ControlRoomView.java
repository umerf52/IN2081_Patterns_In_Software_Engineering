package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.model.Machine;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ControlRoomView extends GridRoomView implements Observer {
	private static final int MACHINE_INFO_VIEWS_FONT_SIZE = 12;

	// model
	private final Machine machine;

	private Label currentTemperatureDisplay;
	private Label currentVoltageDisplay;

	protected ControlRoomView(Machine machine, int width, int height) {
		this.machine = machine;
		/**
		 * We want to be notified upon change in the model, therefore we should add this as an observer to our machine
		 * 1. TODO: Add this class as an observer to the machine passed as a parameter
		 */

		display(width, height);
		setButtonActions();
		update(machine);
	}

	protected void display(int width, int height) {
		setTitle("Control Room | " + this.machine.getName());

		VBox vbox = new VBox();

		vbox.getChildren().add(displayTitle());
		vbox.getChildren().addAll(createMachineControlViews());
		vbox.getChildren().add(new Separator());
		vbox.getChildren().addAll(createMachineInformationViews());

		Scene scene = new Scene(vbox, width, height);
		setScene(scene);

		update(machine);

		show();
	}

	private List<GridPane> createMachineInformationViews() {
		GridPane separatorGrid = new GridPane();
		Label label = new Label("Machine information:");
		label.setFont(Font.font("Segoe UI", FontWeight.BOLD, MACHINE_INFO_VIEWS_FONT_SIZE));
		separatorGrid.getChildren().add(label);
		return new ArrayList<>(Arrays.asList(separatorGrid, createBasicValueView()));
	}

	private GridPane createBasicValueView() {
		GridPane grid = createGridPane();

		Label currentVoltageLabel = createLabel("Current voltage:", 0, 0);
		currentVoltageDisplay = createLabelWithBorder("", 1, 0);

		Label currentTemperatureLabel = createLabel("Current temperature:", 0, 1);
		currentTemperatureDisplay = createLabelWithBorder("", 1, 1);

		grid.getChildren().addAll(currentTemperatureLabel, currentVoltageLabel, currentTemperatureDisplay,
				currentVoltageDisplay);

		return grid;
	}

	protected abstract void setButtonActions();

	protected abstract Label displayTitle();

	protected abstract List<GridPane> createMachineControlViews();

	public Machine getMachine() {
		return machine;
	}

	public Label getCurrentTemperatureDisplay() {
		return currentTemperatureDisplay;
	}

	public Label getCurrentVoltageDisplay() {
		return currentVoltageDisplay;
	}
}
