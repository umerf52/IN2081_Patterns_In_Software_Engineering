package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.model.Machine;

/**
 * This is an interface in order to implement the observer pattern.
 */
public interface Observer {

	void update(Machine machine);
}
