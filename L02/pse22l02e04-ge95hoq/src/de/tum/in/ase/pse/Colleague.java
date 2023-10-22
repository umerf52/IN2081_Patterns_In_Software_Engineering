package de.tum.in.ase.pse;

public abstract class Colleague {
    private final String name;
    private Mediator mediator;

    public Colleague(Mediator m, String name) {
        this.mediator = m;
        this.name = name;
    }

    public abstract void receive(String message);
    public void send(String message) {
        this.mediator.send(message, this);
    }

    public void setMediator(Mediator m) {
        this.mediator = m;
    }

    public Mediator getMediator() {
        return this.mediator;

    }

    public void setName(String name) {
    }

    public String getName() {
        return this.name;
    }

}
