package de.tum.in.ase.pse.ecommerce;

public class Advertisement {

	private final String advertisedText;
	private final int ageRestriction;

	public Advertisement(String advertisedText, int ageRestriction) {
		this.advertisedText = advertisedText;
		this.ageRestriction = ageRestriction;
	}

	@Override
	public String toString() {
		return "The following advertisement is only for audience older than " + ageRestriction + ": " + advertisedText;
	}

}
