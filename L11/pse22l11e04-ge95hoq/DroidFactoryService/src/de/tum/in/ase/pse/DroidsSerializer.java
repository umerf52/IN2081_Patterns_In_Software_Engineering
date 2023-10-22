package de.tum.in.ase.pse;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DroidsSerializer extends StdSerializer<Droids> {

	protected DroidsSerializer(Class<Droids> t) {
		super(t);
	}

	public DroidsSerializer() {
		super(Droids.class);

	}

	@Override
	public void serialize(Droids value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeFieldName("Droids");
		gen.writeString(value.toString());
		gen.writeEndObject();
	}
}
