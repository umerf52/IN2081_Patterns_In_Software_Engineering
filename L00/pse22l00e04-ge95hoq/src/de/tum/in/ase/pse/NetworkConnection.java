package de.tum.in.ase.pse;

import java.net.URL;

public class NetworkConnection implements ConnectionInterface {

	private URL currentUrl;
	private boolean connected;

	@Override
	public void connect(URL requestedUrl) {
		if (this.isConnected()) {
			System.out.println("Already connected!");
		} else {
			this.currentUrl = requestedUrl;
			connected = true;
			System.out.println("You connected to " + requestedUrl);
		}
	}

	@Override
	public void disconnect() {
		if (isConnected()) {
			connected = false;
			System.out.println("You disconnected from " + currentUrl);
		} else {
			System.out.println("You are not connected yet!");
		}
	}

	public boolean isConnected() {
		return connected;
	}
}
