package de.tum.in.ase.pse;

/**
 * A second "main class" for local testing.
 * This is used as a workaround for a common JavaFX issue.
 * <p>
 * To test the code locally, run this class resp. Factory.main().
 */
public final class Factory {

	private Factory() {
	}

	public static void main(String[] args) {
		//This is a workaround for a known issue when starting JavaFX applications
		FactoryApplication.startApp(args);
	}
}
