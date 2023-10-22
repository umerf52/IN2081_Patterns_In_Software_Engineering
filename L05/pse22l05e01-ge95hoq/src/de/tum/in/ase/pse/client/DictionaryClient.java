package de.tum.in.ase.pse.client;

import de.tum.in.ase.pse.common.DictionaryService;
import de.tum.in.ase.pse.common.Service;

public class DictionaryClient extends Client {

	private static final String WORD_TO_LOOK_UP = "Dog";

	private DictionaryService dictionaryService;

	@Override
	public void callServer() {
		lookupWord(WORD_TO_LOOK_UP);
	}

	public void lookupWord(String word) {
		if (this.dictionaryService == null) {
			configureService();
		}

		System.out.println("Looking up " + word);
		String definition = this.dictionaryService.lookupWord(word);
		System.out.println(word + " is defined as follows:\n" + definition);
	}

	private void configureService() {
		Service service = getBroker().getService(DictionaryService.SERVICE_NAME_DICTIONARY);
		if (service instanceof DictionaryService) {
			this.dictionaryService = (DictionaryService) service;
		} else {
			throw new IllegalStateException("Broker returned incorrect proxy for service.");
		}
	}

}
