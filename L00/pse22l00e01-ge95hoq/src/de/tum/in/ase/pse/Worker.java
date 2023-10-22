package de.tum.in.ase.pse;

public class Worker extends Employee {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void listHierarchy(int level) {
        printName(level);
    }
    // TODO 1: Implement the Worker class

    // TODO 3: Implement listHierarchy() for Worker
}
