package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.common.TranslationService;

/*
 * TODO: Task 3 Adjust initialize(), translate(String,String) and runService(String,String) so that the
 *  Translation Server supports French
 *  Hint: Look at the implemented code and think about how you could easily expand it.
 */
public class TranslationServer extends Server implements TranslationService {

	public TranslationServer(String name) {
		super(name);
		initialize();
	}

	/**
	 * Initializes several services of this server
	 */
	@Override
	protected void initialize() {
		getServiceNames().add(TranslationService.SERVICE_NAME_TRANSLATION_GERMAN);
		getServiceNames().add(TranslationService.SERVICE_NAME_TRANSLATION_FRENCH);
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
		if (serviceName.equals(TranslationService.SERVICE_NAME_TRANSLATION_GERMAN)) {
			result = translate(parameters, TranslationService.LANGUAGE_GERMAN);
		} else if (serviceName.equals(TranslationService.SERVICE_NAME_TRANSLATION_FRENCH)) {
			result = translate(parameters, TranslationService.LANGUAGE_FRENCH);
		} else {
			System.out.println("Can't offer service " + serviceName);
		}

		return result;
	}

	@Override
	public String translate(String word, String language) {
		return switch (language) {
			case TranslationService.LANGUAGE_GERMAN -> translateToGerman(word);
			case TranslationService.LANGUAGE_FRENCH -> translateToFrench(word);
			default -> throw new IllegalStateException("Illegal language requested: " + language);
		};
	}

	String translateToGerman(String word) {
		return switch (word) {
			case "Dog" -> "Hund";
			case "Cat" -> "Katze";
			default -> null;
		};
	}

	String translateToFrench(String word) {
		return switch (word) {
			case "Dog" -> "Chien";
			case "Cat" -> "Chatte";
			default -> null;
		};
	}

}
