package de.tum.in.ase.pse.store;

import de.tum.in.ase.pse.ecommerce.*;

// TODO 4 remove all associations to the different controllers in all classes of the package store and use the facade
// instead.
public class Cinema {

	private static int count = 1;
	private final String address;
	private final String name;
	private final int id;

	private ECommerceFacade eCommerceFacade;

	public Cinema(String address, String name) {
		this.address = address;
		this.name = name;
		this.id = generateCinemaId();
		this.eCommerceFacade = new ECommerceFacade();
	}

	public void startLiveStream(int ageRestriction) {
		System.out.println("Let's watch some ads at the beginning.");
		advertise(ageRestriction);
		System.out.println("The film starts. Your cinema " + name + " hopes you enjoy the movie.");
	}

	public void stopLiveStream(int ageRestriction) {
		System.out.println("Let's watch some more ads. ");
		advertise(ageRestriction);
		System.out.println("Have a nice evening!");
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	public void advertise(int ageRestriction) {
		eCommerceFacade.playAdvertisement(ageRestriction);
	}

	public void deliverPopcorn(String shippingAddress) {
		Order order = eCommerceFacade.retrieveLatestOrder(id);
		eCommerceFacade.processOrder(order);
		eCommerceFacade.shipOrder(order, shippingAddress);
	}

	@Override
	public String toString() {
		return "Cinema " + name + ", located at " + address;
	}

	private static int generateCinemaId() {
		count *= 2;
		return count;
	}

}
