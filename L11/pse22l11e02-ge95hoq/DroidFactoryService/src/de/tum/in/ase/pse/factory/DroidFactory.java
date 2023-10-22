package de.tum.in.ase.pse.factory;

import de.tum.in.ase.pse.model.Droid;
import de.tum.in.ase.pse.model.DroidType;

import java.util.UUID;

public final class DroidFactory {
	private static final IdGenerationService idGenerationService = new IdGenerationService();
	private static final int FACTORY_ID = 123456;

	private DroidFactory() {
	}

	public static Droid produceDroid(DroidType droidType) {
		long id = idGenerationService.generateId(FACTORY_ID);
		switch (droidType) {
			case R2 -> {
				return new Droid("R2D2", id);
			}
			case THREE_PO -> {
				return new Droid("C-3PO", id);
			}
			case ASTROMECH -> {
				return new Droid("BB8", id);
			}
			default -> throw new UnsupportedOperationException("Droid type is currently not produced by this factory");

		}
	}

}
