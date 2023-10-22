package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.model.DispatcherMessage;
import de.tum.in.ase.pse.model.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class ServerDispatcherCommunicationHandler {

	private static final int DISPATCHER_PORT = 50001;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;

	ServerDispatcherCommunicationHandler() {
		try {
			Socket dispatcherSocket = new Socket("localhost", DISPATCHER_PORT);
			System.out.println("DISPATCHER_CLIENT: Socket created");
			outputStream = new ObjectOutputStream(dispatcherSocket.getOutputStream());
			System.out.println("DISPATCHER_CLIENT: Output stream created");
			inputStream = new ObjectInputStream(dispatcherSocket.getInputStream());
			System.out.println("DISPATCHER_CLIENT: Input stream created");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	void register(String hostname, String location, int port) {
		System.out.println("DISPATCHER_CLIENT: Registering...");
		// TODO: Task 6 - Instantiate an instance of DispatcherMessage with the correct arguments.
		//  Use MessageType.REGISTER as message type
		DispatcherMessage message = new DispatcherMessage(hostname, location, port, MessageType.REGISTER);

		try {
			outputStream.writeObject(message);
			message = (DispatcherMessage) inputStream.readObject();
			System.out.println(message.getLocation());
		} catch (IOException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}
}
