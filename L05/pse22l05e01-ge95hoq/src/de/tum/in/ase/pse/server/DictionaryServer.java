package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.common.DictionaryService;

public class DictionaryServer extends Server implements DictionaryService {

	public DictionaryServer(String name) {
		super(name);
		initialize();
	}

	/**
	 * Initializes several services of this server
	 */
	@Override
	protected void initialize() {
		getServiceNames().add(DictionaryService.SERVICE_NAME_DICTIONARY);
	}

	/**
	 * Executes a service on this server
	 *
	 * @param serviceName: Name of service to execute
	 * @param parameters:  Parameters for the service (here: a String)
	 * @return Result of service execution (here: a String)
	 */
	@Override
	public String runService(String serviceName, String parameters) {
		System.out.println("AbstractServer '" + getName() + "': Running service '" + serviceName + "' with parameters '" + parameters + "'");
		String result = null;

		if (serviceName.equals(DictionaryService.SERVICE_NAME_DICTIONARY)) {
			result = lookupWord(parameters);
		} else {
			System.out.println("Can't offer service " + serviceName);
		}

		return result;
	}

	@Override
	public String lookupWord(String word) {
		return switch (word) {
			case "Dog" ->
					"a domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, non-retractile claws, and a barking, howling, or whining voice.";
			case "Cat" ->
					"a small domesticated carnivorous mammal with soft fur, a short snout, and retractile claws. It is widely kept as a pet or for catching mice, and many breeds have been developed.";
			default -> null;
		};
	}

}
