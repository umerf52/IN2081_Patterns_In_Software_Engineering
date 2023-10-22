package de.tum.in.ase.pse.ingredientsfactory;

import de.tum.in.ase.pse.ingredients.cheese.Cheese;
import de.tum.in.ase.pse.ingredients.sauce.Sauce;
import de.tum.in.ase.pse.ingredients.veggie.Veggie;
import de.tum.in.ase.pse.ingredients.bun.Bun;

import java.util.List;

public interface BurgerFactory {

	Bun createBun();

	Sauce createSauce();

	List<Veggie> createVeggies();
	//TODO: Extend the BurgerFactory with a method to create cheese for the burger
	Cheese createCheese();

}
