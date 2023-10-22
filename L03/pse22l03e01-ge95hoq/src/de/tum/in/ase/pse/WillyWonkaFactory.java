package de.tum.in.ase.pse;

public class WillyWonkaFactory {
	// TODO Create the createTreat() method
    public Treat createTreat(Ingredient ingredient, Ingredient specialIngredient) {
        if (specialIngredient != Ingredient.SPECIAL_INGREDIENT) {
            throw new UnknownRecipeException("The special ingredient is missing!");
        }
        if (ingredient == Ingredient.CHOCOLATE) {
            return new ChocolateBar(ingredient);
        } else if (ingredient == Ingredient.GELATINE) {
            return new JellyBean(ingredient);
        } else {
            throw new UnknownRecipeException("Unknown recipe for ingredient " + ingredient);
        }
    }
}
