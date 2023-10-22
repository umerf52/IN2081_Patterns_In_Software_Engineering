// Part 3:

package de.tum.in.ase.pse.buildables;

import de.tum.in.ase.pse.buildables.burgeringredients.*;

public class IngredientsListBuilder implements Builder<IngredientsList> {
    private IngredientsList ingredientsList = new IngredientsList();

    @Override
    public Builder<IngredientsList> addPatty(Patty patty) {
        ingredientsList.addBurgerPatty(patty);
        return this;
    }

    @Override
    public Builder<IngredientsList> addBun(Bun bun) {
        ingredientsList.addBun(bun);
        return this;
    }

    @Override
    public Builder<IngredientsList> addLettuce(Lettuce lettuce) {
        ingredientsList.addLettuce(lettuce);
        return this;
    }

    @Override
    public Builder<IngredientsList> addTomato(Tomato tomato) {
        ingredientsList.addTomato(tomato);
        return this;
    }

    @Override
    public Builder<IngredientsList> addOnion(Onion onion) {
        ingredientsList.addOnion(onion);
        return this;
    }

    @Override
    public Builder<IngredientsList> addPickle(Pickle pickle) {
        ingredientsList.addPickle(pickle);
        return this;
    }

    @Override
    public Builder<IngredientsList> addCheese(Cheese cheese) {
        ingredientsList.addCheese(cheese);
        return this;
    }

    @Override
    public Builder<IngredientsList> addSauce(Sauce sauce) {
        ingredientsList.addSauce(sauce);
        return this;
    }

    @Override
    public Builder<IngredientsList> reset() {
        // Part 4:
        ingredientsList = new IngredientsList();
        return this;
    }

    @Override
    public IngredientsList getResult() {
        return this.ingredientsList;
    }
}
