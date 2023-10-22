package de.tum.in.ase.pse.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Droid {
	private final String name;
	private final long id;

	@JsonCreator
	public Droid(@JsonProperty("name") String name, @JsonProperty("id") long id) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "id: " + getId() + "\nname: " + this.name;
	}
}
