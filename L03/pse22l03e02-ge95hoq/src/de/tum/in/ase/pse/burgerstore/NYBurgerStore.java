package de.tum.in.ase.pse.burgerstore;

import de.tum.in.ase.pse.burger.*;
import de.tum.in.ase.pse.ingredientsfactory.NYBurgerFactory;
import de.tum.in.ase.pse.ingredientsfactory.BurgerFactory;

public class NYBurgerStore extends BurgerStore {
    private final BurgerFactory ingredientFactory = new NYBurgerFactory();

    public Burger createBurger(String item) {
        return switch (item) {
            case "beef" -> new BeefBurger("New York Style Beef Burger", ingredientFactory);
            case "chicken" -> new ChickenBurger("New York Style Chicken Burger", ingredientFactory);
            //TODO: handle "veggie" case
            case "veggie" -> new VeggieBurger("New York Style Veggie Burger", ingredientFactory);
            default -> throw new IllegalArgumentException("Invalid burger item: " + item);
        };
    }

}
