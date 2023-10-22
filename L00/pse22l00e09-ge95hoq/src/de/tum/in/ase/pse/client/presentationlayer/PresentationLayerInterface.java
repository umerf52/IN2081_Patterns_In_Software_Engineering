package de.tum.in.ase.pse.client.presentationlayer;

import de.tum.in.ase.pse.client.applicationlayer.ApplicationLayerInterface;
import de.tum.in.ase.pse.client.networklayer.NetworkLayerInterface;

public interface PresentationLayerInterface {

	// TODO: Part 2: Add setters and getters for neighboring layers. Add other methods according to UML model.
    void start();
    void stop();
    void sendMessage(String message);
    void receiveMessage(String message);

    ApplicationLayerInterface getApplicationLayer();

    void setApplicationLayer(ApplicationLayerInterface applicationLayer);

    NetworkLayerInterface getNetworkLayer();

    void setNetworkLayer(NetworkLayerInterface networkLayer);

}
