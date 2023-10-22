package de.tum.in.ase.pse;

import de.tum.in.ase.pse.buildables.Builder;
import de.tum.in.ase.pse.buildables.burgeringredients.*;

public class BurgerRestaurant {

	public void buildStandardBeefBurger(Builder<?> builder) {
		// TODO Part 5:
		builder.reset();
		builder.addPatty(Patty.BEEF_PATTY);
		builder.addSauce(Sauce.KETCHUP);
		builder.addCheese(Cheese.AMERICAN_CHEESE);
		builder.addLettuce(Lettuce.ICEBERG_LETTUCE);
		builder.addPickle(Pickle.CORNICHON);
		builder.addBun(Bun.BRIOCHE_BUN).addOnion(Onion.CARAMELIZED_ONION).addTomato(Tomato.BEEFSTEAK_TOMATO);
	}

	public void buildSpecialBeefBurger(Builder<?> builder) {
		// TODO Part 5:
		builder.reset().addPatty(Patty.BEEF_PATTY).addPatty(Patty.BEEF_PATTY)
				.addSauce(Sauce.MAYO).addSauce(Sauce.KETCHUP).addSauce(Sauce.BBQ_SAUCE)
				.addCheese(Cheese.BRIE_CHEESE).addCheese(Cheese.CHEDDAR_CHEESE)
				.addBun(Bun.SESAME_BUN).addPickle(Pickle.SPICY_SOUR_PICKLE)
				.addLettuce(Lettuce.ROMAINE_LETTUCE).addOnion(Onion.CARAMELIZED_ONION)
				.addTomato(Tomato.BEEFSTEAK_TOMATO);

	}

	public void buildStandardChickenBurger(Builder<?> builder) {
		// TODO Part 5:
		builder.reset().addPatty(Patty.CHICKEN_PATTY).addOnion(Onion.DEEP_FRIED_ONION)
				.addTomato(Tomato.CHERRY_TOMATO).addBun(Bun.CIABATTA_BUN).addLettuce(Lettuce.GREEN_LEAF_LETTUCE)
				.addPickle(Pickle.FULL_SOUR_PICKLE).addCheese(Cheese.GOUDA_CHEESE).addSauce(Sauce.YELLOW_MUSTARD)
				.addSauce(Sauce.CHIMICHURRI_SAUCE);
	}

}
