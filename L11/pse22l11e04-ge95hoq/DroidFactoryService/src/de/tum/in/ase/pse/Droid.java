package de.tum.in.ase.pse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Droid {
	private final String name;

	@JsonCreator
	public Droid(@JsonProperty("name") String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
