package de.tum.in.ase.pse.client.networklayer;

import de.tum.in.ase.pse.client.applicationlayer.ApplicationLayerInterface;
import de.tum.in.ase.pse.client.presentationlayer.PresentationLayerInterface;

public interface NetworkLayerInterface {

	void sendMessage(String message);

	void receiveMessage(String message);

	void openConnection();

	void closeConnection();

	// TODO: Part 2: Replace with setter and getter for presentation layer
	void setApplicationLayer(ApplicationLayerInterface applicationLayer);

	ApplicationLayerInterface getApplicationLayer();

	void setPresentationLayer(PresentationLayerInterface presentationLayer);

	PresentationLayerInterface getPresentationLayer();
}
