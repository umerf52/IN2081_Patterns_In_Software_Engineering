// Part 2
package de.tum.in.ase.pse.buildables;

import de.tum.in.ase.pse.buildables.burgeringredients.*;


public class BurgerBuilder implements Builder<Burger> {

    private Burger burger = new Burger();
    @Override
    public Builder<Burger> addPatty(Patty patty) {
        if (burger.getBurgerPatty1() == null) {
            burger.setBurgerPatty1(patty);
        } else if (burger.getBurgerPatty2() == null) {
            burger.setBurgerPatty2(patty);
        } else {
            throw new IllegalStateException("Burger already has two patties");
        }
        return this;
    }

    @Override
    public Builder<Burger> addBun(Bun bun) {
        this.burger.setBun(bun);
        return this;
    }

    @Override
    public Builder<Burger> addLettuce(Lettuce lettuce) {
        this.burger.setLettuce(lettuce);
        return this;
    }

    @Override
    public Builder<Burger> addTomato(Tomato tomato) {
        this.burger.setTomato(tomato);
        return this;
    }

    @Override
    public Builder<Burger> addOnion(Onion onion) {
        this.burger.setOnion(onion);
        return this;
    }

    @Override
    public Builder<Burger> addPickle(Pickle pickle) {
        this.burger.setPickle(pickle);
        return this;
    }

    @Override
    public Builder<Burger> addCheese(Cheese cheese) {
        if (burger.getCheese1() == null) {
            burger.setCheese1(cheese);
        } else if (burger.getCheese2() == null) {
            burger.setCheese2(cheese);
        } else {
            throw new IllegalStateException("Burger already has two cheeses");
        }
        return this;
    }

    @Override
    public Builder<Burger> addSauce(Sauce sauce) {
        if (burger.getSauce1() == null) {
            burger.setSauce1(sauce);
        } else if (burger.getSauce2() == null) {
            burger.setSauce2(sauce);
        } else if (burger.getSauce3() == null) {
            burger.setSauce3(sauce);
        } else {
            throw new IllegalStateException("Burger already has three sauces");
        }
        return this;
    }

    @Override
    public Builder<Burger> reset() {
        // Part 4:
        burger = new Burger();
        return this;
    }

    @Override
    public Burger getResult() {
        return this.burger;
    }
}
