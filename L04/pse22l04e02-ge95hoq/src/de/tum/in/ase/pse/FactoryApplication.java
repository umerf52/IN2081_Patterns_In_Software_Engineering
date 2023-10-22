package de.tum.in.ase.pse;

import de.tum.in.ase.pse.controller.*;
import de.tum.in.ase.pse.model.*;
import de.tum.in.ase.pse.utils.FactoryException;
import de.tum.in.ase.pse.view.AssemblyControlRoomView;
import de.tum.in.ase.pse.view.MachineRoomView;
import de.tum.in.ase.pse.view.TransistorControlRoomView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This is a "main class" for local testing.
 * To work around a common JavaFX issue, please use second "main class"
 *
 * @see Factory
 * <p>
 * To test the code locally, run this Factory.main().
 */
public final class FactoryApplication extends Application {

	private static final int ASSEMBLY_MIN_VOLTAGE = 200;
	private static final int ASSEMBLY_MAX_VOLTAGE = 1500;
	private static final int ASSEMBLY_TARGET_VOLTAGE = 490;
	private static final int ASSEMBLY_MIN_TEMPERATURE = 20;
	private static final int ASSEMBLY_MAX_TEMPERATURE = 75;
	private static final int ASSEMBLY_TARGET_TEMPERATURE = 60;
	private static final int SPACE_BETWEEN_TRANS = 37;
	private static final int TRANSISTOR_MIN_VOLTAGE = 230;
	private static final int TRANSISTOR_MAX_VOLTAGE = 2500;
	private static final int TRANSISTOR_TARGET_VOLTAGE = 800;
	private static final int TRANSISTOR_MIN_TEMPERATURE = 40;
	private static final int TRANSISTOR_MAX_TEMPERATURE = 190;
	private static final int TRANSISTOR_TARGET_TEMPERATURE = 95;
	private static final int TRANSISTOR_SIZE = 14;

	/**
	 * Second "main method" in order to be called from Factory.
	 */
	public static void startApp(String[] args) {
		launch(args);
	}

	/**
	 * This method is setting up everything for local testing.
	 */
	@Override
	public void start(Stage primaryStage) {
		//No primary Stage needed

		try {
			//generating an assembly machine, an assembly terminal + a temperature and a voltage sensor for it
			AssemblyMachine assemblyMachine = new AssemblyMachine("Assembly Machine #0028", ASSEMBLY_MIN_VOLTAGE, ASSEMBLY_MAX_VOLTAGE, ASSEMBLY_TARGET_VOLTAGE,
					ASSEMBLY_MIN_TEMPERATURE, ASSEMBLY_MAX_TEMPERATURE, ASSEMBLY_TARGET_TEMPERATURE, SPACE_BETWEEN_TRANS, ChipType.CPU);
			AssemblyTerminal assemblyTerminal = new AssemblyTerminal(assemblyMachine);
			MachineTerminal assemblyMachineTerminal = new MachineTerminal(assemblyMachine);
			new TemperatureSensor(assemblyMachine);
			new VoltSensor(assemblyMachine);

			//generating one ControlRoomView & one MachineRoomView for assembly machine
			new AssemblyControlRoomView(assemblyMachine, assemblyTerminal);
			new MachineRoomView(assemblyMachine, assemblyMachineTerminal);

			//generating a transistor machine, a transistor terminal + a temperature and a voltage sensor for it
			TransistorMachine transistorMachine = new TransistorMachine("Transistor Machine #1009", TRANSISTOR_MIN_VOLTAGE, TRANSISTOR_MAX_VOLTAGE, TRANSISTOR_TARGET_VOLTAGE,
					TRANSISTOR_MIN_TEMPERATURE, TRANSISTOR_MAX_TEMPERATURE, TRANSISTOR_TARGET_TEMPERATURE, TRANSISTOR_SIZE, TransistorType.BJT, GateType.XOR);
			TransistorTerminal transistorTerminal = new TransistorTerminal(transistorMachine);
			MachineTerminal transistorMachineTerminal = new MachineTerminal(transistorMachine);
			new TemperatureSensor(transistorMachine);
			new VoltSensor(transistorMachine);

			//generating one ControlRoomView & one MachineRoomView for transistor machine
			new TransistorControlRoomView(transistorMachine, transistorTerminal);
			new MachineRoomView(transistorMachine, transistorMachineTerminal);

		} catch (FactoryException e) {
			e.printStackTrace();
		}
	}
}
