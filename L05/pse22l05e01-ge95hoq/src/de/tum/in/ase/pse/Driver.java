package de.tum.in.ase.pse;

import de.tum.in.ase.pse.broker.Broker;
import de.tum.in.ase.pse.client.DictionaryClient;
import de.tum.in.ase.pse.client.TranslationClient;
import de.tum.in.ase.pse.server.DictionaryServer;
import de.tum.in.ase.pse.server.TranslationServer;

public final class Driver {

	private Driver() {
	}

	public static void main(String[] args) {

		 Broker broker = new Broker();

		/*
		 * TODO: Task 5
		 *  0. Uncomment the Broker instance above.
		 *  1. Instantiate a dictionary client and a translation client
		 * 	2. Set the broker for both clients
		 * 	3. Instantiate a dictionary server and a translation server with their
		 * 	   appropriate name provided as constants in the Broker class.
		 *  4. Set the broker for both servers
		 *  5. Call the servers from their respective clients
		 */
		DictionaryClient dictionaryClient = new DictionaryClient();
		TranslationClient translationClient = new TranslationClient();
		dictionaryClient.setBroker(broker);
		translationClient.setBroker(broker);
		DictionaryServer dictionaryServer = new DictionaryServer(Broker.SERVER_NAME_DICTIONARY);
		TranslationServer translationServer = new TranslationServer(Broker.SERVER_NAME_TRANSLATION);
		dictionaryServer.setBroker(broker);
		translationServer.setBroker(broker);
		dictionaryClient.callServer();
		translationClient.callServer();
	}
}
