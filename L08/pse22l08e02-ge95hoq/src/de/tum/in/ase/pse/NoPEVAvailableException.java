package de.tum.in.ase.pse;

public class NoPEVAvailableException extends RuntimeException {

	private static final long serialVersionUID = -4688966598416340808L;

	public NoPEVAvailableException() {
        super("No PEV found for the specified time frame!");
    }

}
