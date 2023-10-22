package de.tum.in.ase.pse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(using = DroidsSerializer.class)
public enum Droids {
	R2("R2"),
	THREE_PO("3PO");
	private final String name;

	Droids(String name) {
		this.name = name;
	}

	@JsonCreator
	static Droids fromName(@JsonProperty("Droids") String droid1) {
		for (Droids droid : Droids.values()) {
			if (droid1.equalsIgnoreCase(droid.name)) {
				return droid;
			}
		}
		throw new IllegalArgumentException("supplied string is not a valid display name");
	}
	@Override
	public String toString() {
		return name;
	}
}
