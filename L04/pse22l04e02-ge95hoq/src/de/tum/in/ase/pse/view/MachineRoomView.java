package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.controller.MachineTerminal;
import de.tum.in.ase.pse.model.Machine;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Arrays;
import java.util.List;

/**
 * This is one actual view, representing a machine room.
 * It displays the general machine values temperature and voltage.
 */
public class MachineRoomView extends GridRoomView implements Observer {

	private static final int SCENE_WIDTH = 420;
	private static final int SCENE_HEIGHT = 350;
	private static final int CORNER_RADIUS = 2;
	private static final int BORDER_WIDTH = 3;
	private static final int DISPLAY_TITLE_FONT_SIZE = 20;
	private static final int INPUT_VIEW_FONT_SIZE = 12;
	private static final int LABEL_COL_INDEX = 4;
	private static final int HIGHLIGHT_LABEL_COL_INDEX = 3;

	//model
	private final Machine machine;

	//controller
	private final MachineTerminal terminal;

	//Gui objects
	private Label currentTemperatureDisplay;
	private Label currentVoltageDisplay;
	private Label targetTemperatureDisplay;
	private Label targetVoltageDisplay;
	private TextField voltageInput;
	private TextField temperatureInput;
	private Button voltageSubmit;
	private Button temperatureSubmit;

	public MachineRoomView(Machine machine, MachineTerminal terminal) {
		this.machine = machine;
		this.terminal = terminal;

		/**
		 * We want to be notified upon change in the model, therefore we should add this as an observer to our machine
		 * 1. TODO: Add this class as an observer to the machine passed as a parameter
		 */
		machine.addObserver(this);


		display();
		setButtonActions();
		update(machine);
	}

	/**
	 * This method overwrites update() from
	 *
	 * @see Observer
	 * <p>
	 * It updates displayed parameters with the current parameters of the given machine
	 */
	@Override
	public void update(Machine currMachine) {
		/**
		 * Upon change we want to update the text in our GUI, therefore we have to update this method:
		 * 2. TODO: Use the values from the machine (current-/ target-temperature, current-/ target-voltage) and \
		 *          provide them instead of the static dummy values
		 */
		currentTemperatureDisplay.setText(currMachine.getCurrentTemperature() + "");
		currentVoltageDisplay.setText(currMachine.getCurrentVoltage() + "");
		targetTemperatureDisplay.setText(currMachine.getTargetTemperature() + "");
		targetVoltageDisplay.setText(currMachine.getTargetVoltage() + "");
	}

	/**
	 * Add action listeners to the setTargetVoltage & the setTargetTemperature button
	 * in order to update the machine with the input values from the respective text fields.
	 */
	private void setButtonActions() {
		voltageSubmit.setOnAction(event -> terminal.setTargetVoltage(Integer.parseInt(voltageInput.getText())));
		temperatureSubmit.setOnAction(event -> terminal.setTargetTemperature(Integer.parseInt(temperatureInput.getText())));
	}

	private void display() {
		setTitle("Machine Room | " + this.machine.getName());

		VBox vbox = new VBox();

		vbox.getChildren().add(displayTitle());
		vbox.getChildren().addAll(createBasicValuesView(), createTargetValueView(), createWarningView());
		vbox.getChildren().add(new Separator());

		vbox.getChildren().addAll(createInputView());

		Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);
		setScene(scene);

		update(machine);
		show();
	}

	private Label displayTitle() {
		Label title = new Label("GENERAL MACHINE VIEW");
		title.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(CORNER_RADIUS), new BorderWidths(BORDER_WIDTH))));
		title.setFont(new Font(DISPLAY_TITLE_FONT_SIZE));
		return title;
	}

	private List<GridPane> createInputView() {
		GridPane separatorGrid = new GridPane();
		Label label = new Label("Update target attributes:");
		label.setFont(Font.font("Segoe UI", FontWeight.BOLD, INPUT_VIEW_FONT_SIZE));
		separatorGrid.getChildren().add(label);
		return Arrays.asList(separatorGrid, createBasicInputView());
	}

	private GridPane createBasicValuesView() {
		GridPane grid = createGridPane();

		Label currentVoltageLabel = createLabel("Current voltage:", 0, 0);
		currentVoltageDisplay = createLabelWithConstraintsAndBorder("", 1, 0);

		Label currentTemperatureLabel = createLabel("Current temperature:", 0, 1);
		currentTemperatureDisplay = createLabelWithConstraintsAndBorder("", 1, 1);

		grid.getChildren().addAll(currentTemperatureLabel, currentVoltageLabel, currentTemperatureDisplay, currentVoltageDisplay);
		return grid;
	}

	private GridPane createTargetValueView() {
		GridPane grid = createGridPane();

		Label targetVoltageLabel = createLabel("Target voltage is", 0, 0);
		targetVoltageDisplay = createLabelWithHighlight("", 1, 0);

		Label targetTemperatureLabel = createLabel("Target temperature is", 0, 1);
		targetTemperatureDisplay = createLabelWithHighlight("", 1, 1);

		grid.getChildren().addAll(targetTemperatureLabel, targetTemperatureDisplay, targetVoltageLabel, targetVoltageDisplay);
		return grid;
	}

	private GridPane createWarningView() {
		GridPane grid = createGridPane();

		Label voltageMinMaxStart = createLabel("Caution! Voltage must be between", 0, 0);
		Label voltageMinMaxMin = createLabelWithHighlight(machine.getMinVoltage() + "", 1, 0);
		Label voltageMinMaxConnect = createLabel("and", 2, 0);
		Label voltageMinMaxMax = createLabelWithHighlight(machine.getMaxVoltage() + "", HIGHLIGHT_LABEL_COL_INDEX, 0);
		Label voltageMinMaxEnd = createLabel("!", LABEL_COL_INDEX, 0);

		Label temperatureMinMaxStart = createLabel("Caution! Temperature must be between", 0, 1);
		Label temperatureMinMaxMin = createLabelWithHighlight(machine.getMinTemperature() + "", 1, 1);
		Label temperatureMinMaxConnect = createLabel("and", 2, 1);
		Label temperatureMinMaxMax = createLabelWithHighlight(machine.getMaxTemperature() + "", HIGHLIGHT_LABEL_COL_INDEX, 1);
		Label temperatureMinMaxEnd = createLabel("!", LABEL_COL_INDEX, 1);

		grid.getChildren().addAll(voltageMinMaxStart, voltageMinMaxMin, voltageMinMaxConnect, voltageMinMaxMax,
				voltageMinMaxEnd, temperatureMinMaxStart, temperatureMinMaxMin, temperatureMinMaxConnect,
				temperatureMinMaxMax, temperatureMinMaxEnd);
		return grid;
	}

	private GridPane createBasicInputView() {
		GridPane gridPane = createGridPane();

		Label voltageLabel = createLabel("Set new target voltage:", 0, 0);
		voltageInput = createIntegerTextField(1, 0);
		voltageSubmit = createButton("Update", 2, 0);

		Label temperatureLabel = createLabel("Sent new target temperature:", 0, 1);
		temperatureInput = createIntegerTextField(1, 1);
		temperatureSubmit = createButton("Update", 2, 1);

		gridPane.getChildren().addAll(voltageLabel, voltageInput, voltageSubmit, temperatureLabel, temperatureInput, temperatureSubmit);
		return gridPane;
	}
}

