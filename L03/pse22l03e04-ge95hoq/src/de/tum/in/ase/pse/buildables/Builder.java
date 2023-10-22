package de.tum.in.ase.pse.buildables;

import de.tum.in.ase.pse.buildables.burgeringredients.*;

public interface Builder<T> {

	// TODO Part 1:
    Builder<T> addPatty(Patty patty);
    Builder<T> addBun(Bun bun);
    Builder<T> addLettuce(Lettuce lettuce);
    Builder<T> addTomato(Tomato tomato);
    Builder<T> addOnion(Onion onion);
    Builder<T> addPickle(Pickle pickle);
    Builder<T> addCheese(Cheese cheese);
    Builder<T> addSauce(Sauce sauce);
    Builder<T> reset();
    T getResult();


}
