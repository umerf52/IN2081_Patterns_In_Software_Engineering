package de.tum.in.ase.pse.client.applicationlayer;

import de.tum.in.ase.pse.client.networklayer.NetworkLayerInterface;
import de.tum.in.ase.pse.client.presentationlayer.PresentationLayerInterface;

public interface ApplicationLayerInterface {

	void start();

	void stop();

	void sendMessage(String message);

	void receiveMessage(String message);

	// TODO: Part 2: Replace with setters and getters for presentation layer
	void setNetworkLayer(NetworkLayerInterface networkLayer);

	NetworkLayerInterface getNetworkLayer();

	void setPresentationLayer(PresentationLayerInterface presentationLayer);
	PresentationLayerInterface getPresentationLayer();
}
