package de.tum.in.ase.pse.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DroidTypeSerializer extends StdSerializer<DroidType> {


	protected DroidTypeSerializer(Class<DroidType> t) {
		super(t);
	}

	public DroidTypeSerializer() {
		super(DroidType.class);

	}

	@Override
	public void serialize(DroidType value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeFieldName("DroidType");
		gen.writeString(value.toString());
		gen.writeEndObject();
	}
}
