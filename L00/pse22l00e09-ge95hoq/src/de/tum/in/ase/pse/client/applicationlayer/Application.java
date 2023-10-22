package de.tum.in.ase.pse.client.applicationlayer;

import de.tum.in.ase.pse.client.ChatClient;
import de.tum.in.ase.pse.client.networklayer.NetworkLayerInterface;
import de.tum.in.ase.pse.client.presentationlayer.CaesarEncryption;
import de.tum.in.ase.pse.client.presentationlayer.PresentationLayerInterface;

public class Application implements ApplicationLayerInterface {

	public static final int KEY = 6;
	// TODO: Part 2: Replace with a reference to the presentation layer
	private PresentationLayerInterface presentationLayer;
	private final ChatClient chatClient;

	public Application(ChatClient chatClient) {
		this.chatClient = chatClient;
		this.presentationLayer = new CaesarEncryption(KEY);
	}

	@Override
	public void start() {
		// TODO: Part 2: Replace with method invocation of the the presentation layer
		presentationLayer.start();
	}

	@Override
	public void stop() {
		// TODO: Part 2: Replace with method invocation of the the presentation layer
		presentationLayer.stop();
	}

	@Override
	public void sendMessage(String message) {
		// TODO: Part 2: Replace with method invocation of the the presentation layer
		presentationLayer.sendMessage(message);
	}

	@Override
	public void receiveMessage(String message) {
		// TODO: Part 1: Notify the ChatClient to handle that a new message was received.
		chatClient.receiveMessage(message);
	}

	// TODO: Part 2: Replace the reference to network layer with setter and getter for presentation layer.
	@Override
	public void setNetworkLayer(NetworkLayerInterface networkLayer) {
		presentationLayer.setNetworkLayer(networkLayer);
	}

	@Override
	public NetworkLayerInterface getNetworkLayer() {
		return presentationLayer.getNetworkLayer();
	}

	@Override
	public void setPresentationLayer(PresentationLayerInterface presentationLayer) {
		this.presentationLayer = presentationLayer;
	}

	@Override
	public PresentationLayerInterface getPresentationLayer() {
		return this.presentationLayer;
	}

}
