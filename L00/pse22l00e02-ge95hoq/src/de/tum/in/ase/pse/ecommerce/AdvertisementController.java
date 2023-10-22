package de.tum.in.ase.pse.ecommerce;

import java.util.concurrent.ThreadLocalRandom;

public class AdvertisementController {

	private static final int MAX_NUMBER_OF_ADVERTISEMENTS = 42;

	public void playAdvertisement(int ageRestriction) {
		Advertisement advertisement = createAdvertisement(ageRestriction);
		System.out.println(advertisement);
	}

	private Advertisement createAdvertisement(int ageRestriction) {
		return new Advertisement("Advertisement for product " + generateRandomNumber(MAX_NUMBER_OF_ADVERTISEMENTS),
				generateRandomNumber(ageRestriction + 1));
	}

	private int generateRandomNumber(int bound) {
		return ThreadLocalRandom.current().nextInt(bound);
	}

}
