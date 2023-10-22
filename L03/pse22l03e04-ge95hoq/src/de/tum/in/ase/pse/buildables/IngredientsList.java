package de.tum.in.ase.pse.buildables;

import de.tum.in.ase.pse.buildables.burgeringredients.*;

import java.util.ArrayList;
import java.util.List;

public class IngredientsList {

	private final List<Patty> burgerPatties = new ArrayList<>();
	private final List<Bun> buns = new ArrayList<>();
	private final List<Lettuce> lettuceList = new ArrayList<>();
	private final List<Tomato> tomatoes = new ArrayList<>();
	private final List<Onion> onions = new ArrayList<>();
	private final List<Pickle> pickles = new ArrayList<>();
	private final List<Cheese> cheeseList = new ArrayList<>();
	private final List<Sauce> sauces = new ArrayList<>();

	IngredientsList() {

	}

	void addBurgerPatty(Patty burgerPatty) {
		this.burgerPatties.add(burgerPatty);
	}

	public List<Patty> getBurgerPatties() {
		return burgerPatties;
	}

	void addBun(Bun bun) {
		this.buns.add(bun);
	}

	public List<Bun> getBuns() {
		return buns;
	}

	void addLettuce(Lettuce lettuce) {
		this.lettuceList.add(lettuce);
	}

	public List<Lettuce> getLettuceList() {
		return lettuceList;
	}

	void addTomato(Tomato tomato) {
		this.tomatoes.add(tomato);
	}

	public List<Tomato> getTomatoes() {
		return tomatoes;
	}

	void addOnion(Onion onion) {
		this.onions.add(onion);
	}

	public List<Onion> getOnions() {
		return onions;
	}

	void addPickle(Pickle pickle) {
		this.pickles.add(pickle);
	}

	public List<Pickle> getPickles() {
		return pickles;
	}

	void addCheese(Cheese cheese) {
		this.cheeseList.add(cheese);
	}

	public List<Cheese> getCheeseList() {
		return cheeseList;
	}

	void addSauce(Sauce sauce) {
		this.sauces.add(sauce);
	}

	public List<Sauce> getSauces() {
		return sauces;
	}

	@Override
	public String toString() {
		return ("Ingredients List:\n"
				+ "\t> Patties: " + burgerPatties + "\n"
				+ "\t> Buns: " + buns + "\n"
				+ "\t> Lettuces: " + lettuceList + "\n"
				+ "\t> Tomatoes: " + tomatoes + "\n"
				+ "\t> Onions: " + onions + "\n"
				+ "\t> Pickles: " + pickles + "\n"
				+ "\t> Cheese List: " + cheeseList + "\n"
				+ "\t> Sauces: " + sauces + "\n")
				.replace("[]", "None").replace("[", "").replace("]", "");
	}
}
