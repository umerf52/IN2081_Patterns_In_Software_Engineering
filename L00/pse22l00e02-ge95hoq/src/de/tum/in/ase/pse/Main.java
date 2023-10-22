package de.tum.in.ase.pse;

import de.tum.in.ase.pse.store.BookStore;
import de.tum.in.ase.pse.store.Cinema;

import java.util.concurrent.ThreadLocalRandom;

public final class Main {

	private static final int ADULT_AGE_RESTRICTION = 18;
	private static final int MAX_HOUSE_NUMBER = 200;

	private Main() {
	}

	private static int generateRandomHouseNumber() {
		return ThreadLocalRandom.current().nextInt(MAX_HOUSE_NUMBER);
	}

	public static void main(String[] args) {
		var cinema = new Cinema("Boltzmannstraße 3, Garching", "TUM-Cinema");
		var bookStore = new BookStore("Arcisstraße 21, München", "TUM-Books");

		cinema.startLiveStream(ADULT_AGE_RESTRICTION);
		cinema.stopLiveStream(ADULT_AGE_RESTRICTION);

		bookStore.acceptOrder("Leopoldstrasse " + generateRandomHouseNumber() + ", Munich", "+49 89 289 22778");
		cinema.deliverPopcorn("Hall 3 Seat 15e");
	}

}
