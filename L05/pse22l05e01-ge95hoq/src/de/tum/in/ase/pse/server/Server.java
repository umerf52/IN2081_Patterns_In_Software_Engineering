package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.broker.Broker;

import java.util.ArrayList;
import java.util.List;

public abstract class Server {

	public abstract String runService(String serviceName, String parameter);

	protected abstract void initialize();

	private Broker broker;
	private String name;
	private List<String> serviceNames;

	public Server(String name) {
		this.name = name;
		this.serviceNames = new ArrayList<>();
	}

	/**
	 * Set a broker for this server and register all services of this server
	 */
	public void setBroker(Broker newBroker) {
		// Unregister services on old broker
		if (this.broker != null) {
			for (String service : serviceNames) {
				this.broker.unregisterService(this, service);
			}
		}

		this.broker = newBroker;

		// Register all services on new broker
		for (String service : serviceNames) {
			this.broker.registerService(this, service);
		}
	}

	public String getName() {
		return this.name;
	}

	public Broker getBroker() {
		return this.broker;
	}

	protected List<String> getServiceNames() {
		return serviceNames;
	}

}
