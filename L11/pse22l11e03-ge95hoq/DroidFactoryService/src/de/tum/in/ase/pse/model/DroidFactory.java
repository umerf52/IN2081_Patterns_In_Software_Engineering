package de.tum.in.ase.pse.model;

public final class DroidFactory {
	private DroidFactory() {
	}

	public static Droid produceDroid(DroidType droidType) {
		switch (droidType) {
			case R2 -> {
				return new Droid("R2D2");
			}
			case THREE_PO -> {
				return new Droid("C-3PO");
			}
			case ASTROMECH -> {
				return new Droid("BB8");
			}
			default -> throw new UnsupportedOperationException("Droid type is currently not produced by this factory");

		}
	}

}
