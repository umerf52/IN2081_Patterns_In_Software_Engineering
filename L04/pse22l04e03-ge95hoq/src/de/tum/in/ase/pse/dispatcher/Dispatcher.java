package de.tum.in.ase.pse.dispatcher;

import de.tum.in.ase.pse.model.Location;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;


public class Dispatcher extends Application {

	private DispatcherGUI dispatcherGUI;
	private static final int DISPATCHER_PORT = 50001;

	public DispatcherGUI getDispatcherGUI() {
		return dispatcherGUI;
	}

	public void setDispatcherGUI(DispatcherGUI dispatcherGUI) {
		this.dispatcherGUI = dispatcherGUI;
	}

	public Map<String, Location> getLocationMap() {
		return locationMap;
	}

	public void setLocationMap(Map<String, Location> locationMap) {
		this.locationMap = locationMap;
	}

	// TODO: Task 1 - create a HashMap field `locationMap` which maps the names to locations
	private Map<String, Location> locationMap = new HashMap<>();

	public static void startApp(String[] args) {
		launch(args);
	}

	public void startListening() {
		System.out.println("start listening");
		try {
			ServerSocket dispatcherSocket = new ServerSocket(DISPATCHER_PORT);
			while (!Thread.interrupted()) {
				DispatcherMessageHandler handler = new DispatcherMessageHandler(this, dispatcherSocket.accept());
				System.out.println("DISPATCHER: Connection accepted");
				new Thread(handler).start();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	private void startGUI() {
		dispatcherGUI = new DispatcherGUI();
		dispatcherGUI.initGUI();
		dispatcherGUI.displayMessage("Starting... Ready!");
		dispatcherGUI.show();
	}

	void registerServer(String name, Location location) {
		// TODO: Task 2 - Store the name and location in the `locationMap` and call `logRegisterServer` to log the registration
		locationMap.put(name, location);
		logRegisterServer(name, location);
	}

	public Location getServerLocation(String name) {
		// TODO: Task 3 - Fetch location by name from `locationMap` and call `logGetServerLocation`
		Location location = locationMap.get(name);
		logGetServerLocation(name, location);
		return location;
	}

	void logRegisterServer(String name, Location location) {
		if (dispatcherGUI != null) {
			dispatcherGUI.displayMessage("Server '" + name + "' registered.");
			dispatcherGUI.displayMessage("IP address: " + location.getIpAddress());
			dispatcherGUI.displayMessage("Port number: " + location.getPortNumber());
		}
	}

	void logGetServerLocation(String name, Location location) {
		if (dispatcherGUI != null) {
			dispatcherGUI.displayMessage("Querying for: " + name);
			if (location == null) {
				dispatcherGUI.displayMessage("Server not found.");
			} else {
				dispatcherGUI.displayMessage("Query successful.");
			}
		}
	}

	@Override
	public void start(Stage primaryStage) {
		startGUI();
		Thread t = new Thread(this::startListening);
		t.setDaemon(true);
		t.start();


	}
}
