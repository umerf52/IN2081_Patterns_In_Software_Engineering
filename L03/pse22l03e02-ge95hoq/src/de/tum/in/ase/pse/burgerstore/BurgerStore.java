package de.tum.in.ase.pse.burgerstore;

import de.tum.in.ase.pse.burger.Burger;

public abstract class BurgerStore {

	protected abstract Burger createBurger(String item);

	public final Burger orderBurger(String type) {
		Burger burger = createBurger(type);

		System.out.println("--- Making a " + burger.getName() + " ---");

		burger.prepare();
		burger.cook();
		burger.build();
		burger.box();

		return burger;
	}

}
