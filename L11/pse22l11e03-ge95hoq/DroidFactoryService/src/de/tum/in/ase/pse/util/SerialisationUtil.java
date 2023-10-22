package de.tum.in.ase.pse.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

public final class SerialisationUtil {
	private static final JsonMapper JSON_MAPPER = new JsonMapper();

	private SerialisationUtil() {
	}

	public static String serialiseEnum(Enum e) {
		try {
			return JSON_MAPPER.writeValueAsString(e);
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}
}
