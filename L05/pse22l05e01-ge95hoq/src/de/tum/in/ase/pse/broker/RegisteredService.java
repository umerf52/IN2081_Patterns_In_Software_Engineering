package de.tum.in.ase.pse.broker;

import de.tum.in.ase.pse.server.Server;

import java.util.Objects;

public class RegisteredService {

	private final String serviceName;
	private final Server server;

	public RegisteredService(Server server, String serviceName) {
		this.serviceName = serviceName;
		this.server = server;
	}

	public String getServiceName() {
		return serviceName;
	}

	public Server getServer() {
		return server;
	}

	@Override
	public String toString() {
		return "RegisteredService [ServerName=" + server.getName()
				+ ", ServiceName=" + serviceName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof RegisteredService other)) {
			return false;
		}

		if (!Objects.equals(server.getName(), other.server.getName())) {
			return false;
		}

		return Objects.equals(serviceName, other.serviceName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceName, server);
	}

}
