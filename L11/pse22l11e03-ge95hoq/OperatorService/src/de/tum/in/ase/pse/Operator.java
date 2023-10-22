package de.tum.in.ase.pse;

import de.tum.in.ase.pse.client.DroidFactoryClient;

public class Operator {
	private final DroidFactoryClient client = DroidFactoryClient.getInstance();

	public static void main(String[] args) {
		Operator operator = new Operator();
		operator.operate();
	}

	public void operate() {
		System.out.println(client.produce3PO());
		System.out.println(client.produceAstromech());
		System.out.println(client.produceR2());
		System.out.println(client.produceR2());
	}
}
