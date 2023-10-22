package de.tum.in.ase.pse.broker;

import de.tum.in.ase.pse.common.DictionaryService;

public class DictionaryClientSideProxy extends ClientSideProxy implements DictionaryService {

	public DictionaryClientSideProxy(Broker broker) {
		super(broker);
	}

	public String lookupWord(String word) {
		return this.sendRequest(DictionaryService.SERVICE_NAME_DICTIONARY, word);
	}

}
