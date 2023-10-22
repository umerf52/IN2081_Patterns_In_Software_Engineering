package de.tum.in.ase.pse.buildables;

import de.tum.in.ase.pse.buildables.burgeringredients.*;

import java.util.Objects;

public class Burger {

	private Patty burgerPatty1;
	private Patty burgerPatty2;
	private Bun bun;
	private Lettuce lettuce;
	private Tomato tomato;
	private Onion onion;
	private Pickle pickle;
	private Cheese cheese1;
	private Cheese cheese2;
	private Sauce sauce1;
	private Sauce sauce2;
	private Sauce sauce3;

	Burger() {

	}

	public Patty getBurgerPatty1() {
		return burgerPatty1;
	}

	void setBurgerPatty1(Patty burgerPatty1) {
		this.burgerPatty1 = burgerPatty1;
	}

	public Patty getBurgerPatty2() {
		return burgerPatty2;
	}

	void setBurgerPatty2(Patty burgerPatty2) {
		this.burgerPatty2 = burgerPatty2;
	}

	public Bun getBun() {
		return bun;
	}

	void setBun(Bun bun) {
		this.bun = bun;
	}

	public Lettuce getLettuce() {
		return lettuce;
	}

	void setLettuce(Lettuce lettuce) {
		this.lettuce = lettuce;
	}

	public Tomato getTomato() {
		return tomato;
	}

	void setTomato(Tomato tomato) {
		this.tomato = tomato;
	}

	public Onion getOnion() {
		return onion;
	}

	void setOnion(Onion onion) {
		this.onion = onion;
	}

	public Pickle getPickle() {
		return pickle;
	}

	void setPickle(Pickle pickle) {
		this.pickle = pickle;
	}

	public Cheese getCheese1() {
		return cheese1;
	}

	void setCheese1(Cheese cheese1) {
		this.cheese1 = cheese1;
	}

	public Cheese getCheese2() {
		return cheese2;
	}

	void setCheese2(Cheese cheese2) {
		this.cheese2 = cheese2;
	}

	public Sauce getSauce1() {
		return sauce1;
	}

	void setSauce1(Sauce sauce1) {
		this.sauce1 = sauce1;
	}

	public Sauce getSauce2() {
		return sauce2;
	}

	void setSauce2(Sauce sauce2) {
		this.sauce2 = sauce2;
	}

	public Sauce getSauce3() {
		return sauce3;
	}

	void setSauce3(Sauce sauce3) {
		this.sauce3 = sauce3;
	}

	@Override
	public String toString() {
		return "Burger Ingredients:\n"
				+ "\t> Patty 1: " + Objects.requireNonNullElse(burgerPatty1, "None") + "\n"
				+ "\t> Patty 2: " + Objects.requireNonNullElse(burgerPatty2, "None") + "\n"
				+ "\t> Bun: " + Objects.requireNonNullElse(bun, "None") + "\n"
				+ "\t> Lettuce: " + Objects.requireNonNullElse(lettuce, "None") + "\n"
				+ "\t> Tomatoes: " + Objects.requireNonNullElse(tomato, "None") + "\n"
				+ "\t> Onions: " + Objects.requireNonNullElse(onion, "None") + "\n"
				+ "\t> Pickles: " + Objects.requireNonNullElse(pickle, "None") + "\n"
				+ "\t> Cheese 1: " + Objects.requireNonNullElse(cheese1, "None") + "\n"
				+ "\t> Cheese 2: " + Objects.requireNonNullElse(cheese2, "None") + "\n"
				+ "\t> Sauce 1: " + Objects.requireNonNullElse(sauce1, "None") + "\n"
				+ "\t> Sauce 2: " + Objects.requireNonNullElse(sauce2, "None") + "\n"
				+ "\t> Sauce 3: " + Objects.requireNonNullElse(sauce3, "None") + "\n";
	}

}
