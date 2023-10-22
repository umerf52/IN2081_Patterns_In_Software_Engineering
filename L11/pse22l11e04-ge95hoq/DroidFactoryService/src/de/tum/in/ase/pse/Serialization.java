package de.tum.in.ase.pse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;


public final class Serialization {
	private static final JsonMapper MAPPER = new JsonMapper();
	private Serialization() {
	}

	public static String serializeDroid(Droids droid) {
		try {
			return MAPPER.writeValueAsString(droid);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
