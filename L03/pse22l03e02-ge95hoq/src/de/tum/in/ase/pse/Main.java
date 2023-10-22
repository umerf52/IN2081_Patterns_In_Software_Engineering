package de.tum.in.ase.pse;

import de.tum.in.ase.pse.burger.Burger;
import de.tum.in.ase.pse.burgerstore.BurgerStore;
import de.tum.in.ase.pse.burgerstore.LondonBurgerStore;
import de.tum.in.ase.pse.burgerstore.NYBurgerStore;

final class Main {

	private Main() {
	}

	public static void main(String[] args) {
		// TODO: You can uncommment the following for debugging:

		BurgerStore nyStore = new NYBurgerStore();
		BurgerStore londonStore = new LondonBurgerStore();

		Burger burger = nyStore.orderBurger("veggie");
		System.out.println("Ethan ordered a " + burger);

		burger = londonStore.orderBurger("veggie");
		System.out.println("Ethan ordered a " + burger);
		System.out.println("Joel ordered a " + burger);

		burger = nyStore.orderBurger("beef");
		System.out.println("Ethan ordered a " + burger);

		burger = londonStore.orderBurger("beef");
		System.out.println("Joel ordered a " + burger);

		burger = nyStore.orderBurger("chicken");
		System.out.println("Ethan ordered a " + burger);

		burger = londonStore.orderBurger("chicken");
		System.out.println("Joel ordered a " + burger);

	}

}
