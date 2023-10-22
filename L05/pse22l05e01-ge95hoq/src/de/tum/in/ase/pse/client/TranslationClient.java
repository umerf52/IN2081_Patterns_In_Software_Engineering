package de.tum.in.ase.pse.client;

import de.tum.in.ase.pse.common.Service;
import de.tum.in.ase.pse.common.TranslationService;

/*
 * TODO Task 2: Adjust callServer() and configureTranslator(String) so that French is supported as well
 *  Hint: Look at the implemented code and think about how you could easily expand it.
 */
public class TranslationClient extends Client {

	private static final String WORD_TO_TRANSLATE = "Dog";

	private TranslationService translationService;


	@Override
	public void callServer() {
		translateWord(WORD_TO_TRANSLATE, TranslationService.LANGUAGE_GERMAN);
		translateWord(WORD_TO_TRANSLATE, TranslationService.LANGUAGE_FRENCH);
	}

	public void translateWord(String word, String language) {
		configureTranslator(language);
		System.out.println();
		System.out.println("Translating " + word + " to " + language);
		String translation = translationService.translate(word, language);
		System.out.println(word + " in " + language + " translates to: " + translation);
	}

	private void configureTranslator(String language) {
		String serviceName = switch (language) {
			case TranslationService.LANGUAGE_GERMAN -> TranslationService.SERVICE_NAME_TRANSLATION_GERMAN;
			case TranslationService.LANGUAGE_FRENCH -> TranslationService.SERVICE_NAME_TRANSLATION_FRENCH;
			default -> throw new IllegalArgumentException(language + " is an unsupported language");
		};

		Service service = getBroker().getService(serviceName);
		if (service instanceof TranslationService) {
			this.translationService = (TranslationService) service;
		} else {
			throw new IllegalStateException("Broker returned incorrect proxy for service.");
		}
	}

}
