package de.tum.in.ase.pse.client.networklayer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import de.tum.in.ase.pse.client.applicationlayer.ApplicationLayerInterface;
import de.tum.in.ase.pse.client.presentationlayer.PresentationLayerInterface;

public class TcpNetworkLayer implements NetworkLayerInterface {

	private Socket socket;
	private Scanner incomingScanner;
	private PrintWriter outgoingWriter;
	private Thread waitForIncommingMessageThread;
	private static AtomicBoolean running = new AtomicBoolean(false);

	private final String host;
	private final int port;
	// TODO: Part 2: Replace with a reference to presentation layer
	private PresentationLayerInterface presentationLayer;

	public TcpNetworkLayer(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void sendMessage(String message) {
		// TODO: Part 1: Set a breakpoint here to debug the chat system
		outgoingWriter.println(message);
	}

	@Override
	public void receiveMessage(String message) {
		presentationLayer.receiveMessage(message);
	}

	// TODO: Part 2: Replace with setter and getter for presentation layer
	@Override
	public void setPresentationLayer(PresentationLayerInterface presentationLayer) {
		this.presentationLayer = presentationLayer;
	}

	@Override
	public PresentationLayerInterface getPresentationLayer() {
		return this.presentationLayer;
	}

	private void waitForIncommingMessages() {
		if (waitForIncommingMessageThread == null) {
			waitForIncommingMessageThread = new Thread(() -> {
				running.set(true);
				while (running.get()) {
					String incomingMessage = incomingScanner.nextLine();
					receiveMessage(incomingMessage);
				}
			});
			waitForIncommingMessageThread.start();
		}
	}

	@Override
	public void openConnection() {
		// TODO: Part 1: Set a breakpoint here to debug the chat system
		System.out.println("Connecting to server ...");
		try {
			socket = new Socket(host, port);
			incomingScanner = new Scanner(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			outgoingWriter = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);
			waitForIncommingMessages();
			System.out.println("Connection Stablished.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		try {
			running.set(false);
			waitForIncommingMessageThread.interrupt();
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			System.err.print(e.getMessage());
		}
	}

	@Override
	public void setApplicationLayer(ApplicationLayerInterface applicationLayer) {

	}

	@Override
	public ApplicationLayerInterface getApplicationLayer() {
		return null;
	}
}
