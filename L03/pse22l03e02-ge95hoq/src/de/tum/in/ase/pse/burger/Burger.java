package de.tum.in.ase.pse.burger;

import de.tum.in.ase.pse.ingredients.bun.Bun;
import de.tum.in.ase.pse.ingredients.cheese.Cheese;
import de.tum.in.ase.pse.ingredients.patty.Patty;
import de.tum.in.ase.pse.ingredients.sauce.Sauce;
import de.tum.in.ase.pse.ingredients.veggie.Veggie;
import de.tum.in.ase.pse.ingredientsfactory.BurgerFactory;

import java.util.List;

public abstract class Burger {

	private final String name;
	private Bun bun;
	private Sauce sauce;
	private List<Veggie> veggies;
	private Patty patty;
    private BurgerFactory ingredientFactory;

	//TODO: Extend the Burger class for the cheese
	private Cheese cheese;

	//TODO: getters and setters
	public Cheese getCheese() {
		return cheese;
	}

	void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}

	protected Burger(String name, BurgerFactory ingredientFactory) {
		this.name = name;
        this.ingredientFactory = ingredientFactory;
	}

	public String getName() {
		return name;
	}

	public Bun getBun() {
		return bun;
	}

	public Patty getPatty() {
		return patty;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public List<Veggie> getVeggies() {
		return veggies;
	}

    BurgerFactory getIngredientFactory() {
        return ingredientFactory;
    }

	void setBun(Bun bun) {
		this.bun = bun;
	}

	void setPatty(Patty patty) {
		this.patty = patty;
	}

	void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	void setVeggies(List<Veggie> veggies) {
		this.veggies = veggies;
	}

	public abstract void prepare();

	public void cook() {
		System.out.println("Cook patty for 3-4 minutes on both sides");
	}

	public void build() {
		System.out.println("Build a burger");
	}

	public void box() {
		System.out.println("Place burger in official BurgerStore box");
	}

	@Override
	public String toString() {
		//TODO extend the toString method with cheese
		return "Burger{"
				+ "name='" + name + '\''
				+ ", bun=" + bun
				+ ", sauce=" + sauce
				+ ", veggies=" + veggies
				+ ", patty=" + patty
				+ ", cheese=" + cheese
				+ '}';
	}
}
