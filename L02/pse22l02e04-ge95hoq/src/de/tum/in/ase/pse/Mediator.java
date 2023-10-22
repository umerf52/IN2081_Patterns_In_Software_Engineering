package de.tum.in.ase.pse;

public interface Mediator {
    void send(String message, Colleague sender);
}
