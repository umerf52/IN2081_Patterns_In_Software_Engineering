package de.tum.in.ase.pse.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonSerialize(using = DroidTypeSerializer.class)
public enum DroidType {
	ASTROMECH("Astromech"),

	R2("R2"),

	THREE_PO("3PO");
	private final String displayName;

	DroidType(String displayName) {
		this.displayName = displayName;
	}

	@JsonCreator
	static DroidType fromDisplayName(@JsonProperty("DroidType") String droidType) {
		for (DroidType type : DroidType.values()) {
			if (droidType.equalsIgnoreCase(type.displayName)) {
				return type;
			}
		}
		throw new IllegalArgumentException("supplied string is not a valid display name");
	}

	@Override
	public String toString() {
		return displayName;
	}
}
