package de.tum.in.ase.pse.client;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import de.tum.in.ase.pse.client.applicationlayer.Application;
import de.tum.in.ase.pse.client.applicationlayer.ApplicationLayerInterface;
import de.tum.in.ase.pse.client.networklayer.NetworkLayerInterface;
import de.tum.in.ase.pse.client.networklayer.TcpNetworkLayer;
import de.tum.in.ase.pse.client.presentationlayer.AesEncryption;

public class ChatClient {

	private static final String SERVER_HOST = "localhost";
	private static final int SERVER_PORT = 1337;
	private static final String LOGOUT_MESSAGE = ".logout";
	private Thread waitForUserInputThread;
	private String lastMessageReceived;

	private final ApplicationLayerInterface applicationLayer;

	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient(SERVER_HOST, SERVER_PORT);
		chatClient.start();
	}

	public ChatClient(String host, int port) {
		// TODO: Part 2: Instantiate and configure the layers
		// TODO: Part 2: Add and use a CaesarEncryption implementation for the presentation layer.
		AesEncryption encryption = new AesEncryption("0123456701234567");
		// TODO: Part 3: Replace the CaesarEncryption with an AesEncryption implementation in the presentation layer.
		applicationLayer = new Application(this);

		NetworkLayerInterface networkLayer = new TcpNetworkLayer(host, port);

		applicationLayer.setNetworkLayer(networkLayer);
		applicationLayer.setPresentationLayer(encryption);
		networkLayer.setApplicationLayer(applicationLayer);
		networkLayer.setPresentationLayer(encryption);
		encryption.setApplicationLayer(applicationLayer);
		encryption.setNetworkLayer(networkLayer);
	}

	public void start() {
		applicationLayer.start();
		waitForUserInputThread = new Thread(this::waitForUserInput);
		waitForUserInputThread.start();
		System.out.println("ChatClient started.");
	}

	private void waitForUserInput() {
		try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
			while (!Thread.interrupted()) {
				String outgoingMessage = scanner.nextLine();
				if (LOGOUT_MESSAGE.equals(outgoingMessage)) {
					shutDown();
					return;
				}
				sendMessage(outgoingMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void receiveMessage(String message) {
		lastMessageReceived = message;
		// TODO: Part 1: Print the received message by invoking the printMessage() method
		printMessage(message);
	}

	public void sendMessage(String outgoingMessage) {
		// TODO: Part 1: Use the application layer to send the message.
		applicationLayer.sendMessage(outgoingMessage);
	}

	private void shutDown() {
		applicationLayer.stop();
		waitForUserInputThread.interrupt();
	}

	private static void printMessage(String message) {
		System.out.println(message);
	}


	public ApplicationLayerInterface getApplicationLayer() {
		return applicationLayer;
	}

	public String getLastMessageReceived() {
		return lastMessageReceived;
	}
}
