package de.tum.in.ase.pse.client;

import de.tum.in.ase.pse.broker.Broker;

public abstract class Client {

	private Broker broker;

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	public abstract void callServer();

	protected Broker getBroker() {
		return broker;
	}
}
