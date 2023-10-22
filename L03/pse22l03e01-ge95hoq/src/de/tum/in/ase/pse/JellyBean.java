package de.tum.in.ase.pse;

public class JellyBean implements Treat {
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    private Ingredient ingredient;
    @Override
    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public JellyBean(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
