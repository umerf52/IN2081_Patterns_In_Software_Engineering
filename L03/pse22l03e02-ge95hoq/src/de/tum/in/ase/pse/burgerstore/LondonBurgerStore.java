package de.tum.in.ase.pse.burgerstore;

import de.tum.in.ase.pse.burger.*;
import de.tum.in.ase.pse.ingredientsfactory.BurgerFactory;
import de.tum.in.ase.pse.ingredientsfactory.LondonBurgerFactory;

public class LondonBurgerStore extends BurgerStore {
    private final BurgerFactory ingredientFactory = new LondonBurgerFactory();

    public Burger createBurger(String item) {
        return switch (item) {
            case "beef" -> new BeefBurger("London Style Beef Burger", ingredientFactory);
            case "chicken" -> new ChickenBurger("London Style Chicken Burger", ingredientFactory);
            //TODO: handle "veggie" case
            case "veggie" -> new VeggieBurger("London Style Veggie Burger", ingredientFactory);
            default -> throw new IllegalArgumentException("Invalid burger item: " + item);
        };
    }

}
