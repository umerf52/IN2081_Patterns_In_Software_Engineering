package de.tum.in.ase.pse.burger;

import de.tum.in.ase.pse.ingredients.patty.Vegan;
import de.tum.in.ase.pse.ingredientsfactory.BurgerFactory;

public class VeggieBurger extends Burger {

    public VeggieBurger(String name, BurgerFactory ingredientFactory) {
        super(name, ingredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + this.getName());
        BurgerFactory ingredientFactory = getIngredientFactory();
        this.setBun(ingredientFactory.createBun());
        this.setSauce(ingredientFactory.createSauce());
        this.setVeggies(ingredientFactory.createVeggies());
        this.setPatty(new Vegan());
        //TODO: add cheese
        this.setCheese(ingredientFactory.createCheese());
    }

}
