package de.tum.in.ase.pse.broker;

/**
 * ClientProxy that encapsulate communication with broker and marshalling/unmarshalling
 */
public class ClientSideProxy extends Proxy {

	private Broker broker;

	public ClientSideProxy(Broker broker) {
		this.broker = broker;
	}

	/**
	 * Forwards the service request from client to broker and does the marshalling/unmarshalling
	 *
	 * @param serviceName Service to be initiated
	 * @param parameters  Parameters for service
	 * @return Result of service execution
	 */
	public String sendRequest(String serviceName, String parameters) {
		String packedData = serialize(parameters);
		String result = broker.forwardRequest(serviceName, packedData);
		return deserialize(result);
	}

}
