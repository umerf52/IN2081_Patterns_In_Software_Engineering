package de.tum.in.ase.pse;

public final class DroidFactory {

    public Droid produce(Droids droid) {
        switch (droid) {
            case R2 -> {
                return new Droid("R2-D2");
            }
            case THREE_PO -> {
                return new Droid("C-3PO");
            }
            default -> throw new UnsupportedOperationException("Droid type is currently not produced by this factory");

        }
    }

}
