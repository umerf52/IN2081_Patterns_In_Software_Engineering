package de.tum.in.ase.pse;

public abstract class Hashing {
    public HashFunction getImplementation() {
        return implementation;
    }

    protected void setImplementation(HashFunction implementation) {
        this.implementation = implementation;
    }

    private HashFunction implementation;

    public abstract String hashDocument(String document);
}
