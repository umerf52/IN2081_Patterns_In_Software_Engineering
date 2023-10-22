package de.tum.in.ase.pse;

public interface Observer<T> {

	void onUpdate(T newState);
}
