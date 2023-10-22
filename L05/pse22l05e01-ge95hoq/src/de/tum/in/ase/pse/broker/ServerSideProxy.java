package de.tum.in.ase.pse.broker;

import de.tum.in.ase.pse.server.Server;

/**
 * Implements marshaling and unmarshalling of the server component
 */
public class ServerSideProxy extends Proxy {

	private final Server server;

	public ServerSideProxy(Server server) {
		this.server = server;
	}

	/**
	 * Forward service call to server
	 *
	 * @param serviceName Name of service
	 * @param parameters  Parameters of service invocation (here: a String)
	 * @return Result of service invocation (here: a String)
	 */
	public String callService(String serviceName, String parameters) {
		String unpackedParameters = deserialize(parameters);
		String result = this.server.runService(serviceName, unpackedParameters);
		return serialize(result);
	}

}
