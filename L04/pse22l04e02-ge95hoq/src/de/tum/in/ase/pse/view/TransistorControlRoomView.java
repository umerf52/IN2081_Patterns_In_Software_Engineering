package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.controller.TransistorTerminal;
import de.tum.in.ase.pse.model.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is one actual view, representing a control room for
 *
 * @see TransistorMachine
 * <p>
 * It displays some general machine parameters,
 * as well as the machine-specific ones transistor size, transistor type and gate type.
 */
public class TransistorControlRoomView extends ControlRoomView {

	private static final int SCENE_WIDTH = 400;
	private static final int SCENE_HEIGHT = 360;
	private static final int CORNER_RADIUS = 2;
	private static final int BORDER_WIDTH = 3;
	private static final int DISPLAY_TITLE_FONT_SIZE = 20;

	// controller
	private final TransistorTerminal terminal;

	// GUI objects
	private TextField transSizeInput;
	private ComboBox<TransistorType> transTypeInput;
	private ComboBox<GateType> gateTypeInput;
	private Label transSizeDisplay;
	private Label transTypeDisplay;
	private Label gateTypeDisplay;
	private Button transSizeSubmit;
	private Button transTypeSubmit;
	private Button gateTypeSubmit;

	public TransistorControlRoomView(TransistorMachine machine, TransistorTerminal terminal) {
		super(machine, SCENE_WIDTH, SCENE_HEIGHT);
		this.terminal = terminal;
		machine.addObserver(this);
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
		 * 2. TODO: Use the values from the machine (current-temperature, current-voltage, transSize, transType\
		 *          and gateType) and provide them instead of the static dummy values
		 */
		TransistorMachine transistorMachine = (TransistorMachine) currMachine;
		getCurrentTemperatureDisplay().setText(transistorMachine.getCurrentTemperature() + "");
		getCurrentVoltageDisplay().setText(transistorMachine.getCurrentVoltage() + "");
		transSizeDisplay.setText(transistorMachine.getTransistorSize() + "");
		transTypeDisplay.setText(transistorMachine.getTransistorType().toString());
		gateTypeDisplay.setText(transistorMachine.getGateType().toString());
	}

	/**
	 * Add action listeners to the setTransistorSize the setTransistorType & the setGateType button
	 * in order to update the machine with the input values from the respective text fields.
	 */
	protected void setButtonActions() {
		transSizeSubmit.setOnAction(event -> terminal.setTransistorSize(Integer.parseInt(transSizeInput.getText())));
		transTypeSubmit.setOnAction(event -> terminal.setTransistorType(transTypeInput.getValue()));
		gateTypeSubmit.setOnAction(event -> terminal.setGateType(gateTypeInput.getValue()));
	}

	protected Label displayTitle() {
		Label title = new Label("CONTROL VIEW - TRANSISTOR MACHINE");
		title.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(CORNER_RADIUS), new BorderWidths(BORDER_WIDTH))));
		title.setFont(new Font(DISPLAY_TITLE_FONT_SIZE));
		title.setAlignment(Pos.CENTER);
		return title;
	}

	protected List<GridPane> createMachineControlViews() {
		List<GridPane> panes = new ArrayList<>();
		panes.add(createSpecificValueView());
		panes.add(createSpecificInputView());
		return panes;
	}

	private GridPane createSpecificValueView() {
		GridPane gridPane = createGridPane();

		Label transSizeLabel = createLabel("Current transistor size:", 0, 0);
		transSizeDisplay = createLabelWithBorder("", 1, 0);

		Label transTypeLabel = createLabel("Current transistor type:", 0, 1);
		transTypeDisplay = createLabelWithBorder("", 1, 1);

		Label gateTypeLabel = createLabel("Current gate type:", 0, 2);
		gateTypeDisplay = createLabelWithBorder("", 1, 2);

		gridPane.getChildren().addAll(transSizeLabel, transSizeDisplay, transTypeLabel, transTypeDisplay, gateTypeLabel,
				gateTypeDisplay);

		return gridPane;
	}

	private GridPane createSpecificInputView() {
		GridPane gridPane = createGridPane();

		Label transSizeLabel = createLabel("Set new transistor size:", 0, 0);
		transSizeInput = createIntegerTextField(1, 0);
		transSizeSubmit = createButton("Update", 2, 0);

		Label transTypeLabel = createLabel("Set new transistor type:", 0, 1);
		transTypeInput = createComboBox(Arrays.asList(TransistorType.values()), 1, 1);
		transTypeSubmit = createButton("Update", 2, 1);

		Label gateTypeLabel = createLabel("Set new gate type:", 0, 2);
		gateTypeInput = createComboBox(Arrays.asList(GateType.values()), 1, 2);
		gateTypeSubmit = createButton("Update", 2, 2);

		gridPane.getChildren().addAll(transSizeLabel, transSizeInput, transSizeSubmit, transTypeLabel, transTypeInput,
				transTypeSubmit, gateTypeLabel, gateTypeInput, gateTypeSubmit);

		return gridPane;
	}
}
