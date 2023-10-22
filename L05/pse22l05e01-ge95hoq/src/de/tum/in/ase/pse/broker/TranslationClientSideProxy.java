package de.tum.in.ase.pse.broker;

import de.tum.in.ase.pse.common.TranslationService;

/*
 * TODO Task 4: Add a translate option in case the requested language equals French
 */
public class TranslationClientSideProxy extends ClientSideProxy implements TranslationService {

	public TranslationClientSideProxy(Broker broker) {
		super(broker);
	}

	public String translate(String word, String language) {
		if (language.equals(TranslationService.LANGUAGE_GERMAN)) {
			return this.sendRequest(TranslationService.SERVICE_NAME_TRANSLATION_GERMAN, word);
		} else if (language.equals(TranslationService.LANGUAGE_FRENCH)) {
			return this.sendRequest(TranslationService.SERVICE_NAME_TRANSLATION_FRENCH, word);
		} else {
			return "@#+*!�";
		}
	}

}
