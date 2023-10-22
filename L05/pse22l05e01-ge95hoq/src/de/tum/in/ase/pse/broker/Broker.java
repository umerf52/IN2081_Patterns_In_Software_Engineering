package de.tum.in.ase.pse.broker;

import de.tum.in.ase.pse.common.DictionaryService;
import de.tum.in.ase.pse.common.Service;
import de.tum.in.ase.pse.common.TranslationService;
import de.tum.in.ase.pse.server.Server;

import java.util.ArrayList;
import java.util.List;

/*
 * TODO Task 4: Make sure that the correct client side proxy is returned when
 *  requesting the French translation service
 */
public class Broker {

	public static final String SERVER_NAME_TRANSLATION = "Translation server";
	public static final String SERVER_NAME_DICTIONARY = "Dictionary server";

	/**
	 * List of all registered services
	 */
	private final List<RegisteredService> services;

	public Broker() {
		this.services = new ArrayList<>();
	}

	/**
	 * Allows to register a service at this broker
	 * A service is identified by the combination of server name and service name
	 *
	 * @param server      Instance of service proxy
	 * @param serviceName Name of service
	 */
	public void registerService(Server server, String serviceName) {
		RegisteredService service = new RegisteredService(server, serviceName);
		if (!services.contains(service)) {
			services.add(service);
			System.out.println("Registered service " + service);
		}
	}

	/**
	 * Unregister a service previously registered
	 *
	 * @param server      Instance of service proxy
	 * @param serviceName Name of service
	 */
	public void unregisterService(Server server, String serviceName) {
		RegisteredService service = new RegisteredService(server, serviceName);
		if (services.contains(service)) {
			services.remove(service);
			System.out.println("Unregistered service " + service);
		}
	}

	public Service getService(String serviceName) {
		return switch (serviceName) {
			case DictionaryService.SERVICE_NAME_DICTIONARY -> new DictionaryClientSideProxy(this);
			case TranslationService.SERVICE_NAME_TRANSLATION_FRENCH -> new TranslationClientSideProxy(this);
			case TranslationService.SERVICE_NAME_TRANSLATION_GERMAN -> new TranslationClientSideProxy(this);
			default -> null;
		};
	}

	/**
	 * Forwards request with given parameters to a given service
	 *
	 * @param serviceName Name of service
	 * @param parameters  Parameters for service invocation
	 * @return Result of service invocation
	 */
	public String forwardRequest(String serviceName, String parameters) {
		ServerSideProxy proxy = findServer(serviceName);
		if (proxy != null) {
			return proxy.callService(serviceName, parameters);
		} else {
			System.out.println("No service found for ServiceName='" + serviceName + "'");
			return null;
		}
	}

	private ServerSideProxy findServer(String serviceName) {
		for (RegisteredService service : services) {
			if (service.getServiceName().equals(serviceName)) {
				return new ServerSideProxy(service.getServer());
			}
		}
		return null;
	}
}
