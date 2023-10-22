package de.tum.in.ase.pse.broker;

public abstract class Proxy {

	/**
	 * Performs the marshalling
	 *
	 * @param inputData The data to be marshalled
	 * @return Marshalled data
	 */
	protected String serialize(String inputData) {
		return "[" + String.join(";", inputData.split(" ")) + "]";
	}

	/**
	 * Performs the unmarshalling
	 *
	 * @param inputData The data to be marshalled
	 * @return Unmarshalled data
	 */
	protected String deserialize(String inputData) {
		inputData = inputData.substring(1, inputData.length() - 1);
		return String.join(" ", inputData.split(";"));
	}

}
