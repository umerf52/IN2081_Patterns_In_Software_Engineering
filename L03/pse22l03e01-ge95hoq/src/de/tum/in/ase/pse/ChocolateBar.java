package de.tum.in.ase.pse;

public class ChocolateBar implements Treat {
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    private Ingredient ingredient;
    @Override
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public ChocolateBar(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
