package de.tum.in.ase.pse.utils;

/**
 * This exception class is used for run time exceptions caused by invalid user input.
 */
public class FactoryException extends RuntimeException {

	private static final long serialVersionUID = -7987583182222307233L;

	public FactoryException(String text) {
		super(text);
	}
}
