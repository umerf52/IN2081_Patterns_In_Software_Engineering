package de.tum.in.ase.pse;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagues = new ArrayList<Colleague>();

    public ConcreteMediator() {
    }

    public void send(String message, Colleague sender) {
        for (Colleague colleague : this.colleagues) {
            if (colleague != sender) {
                colleague.receive(message);
            }
        }
    }

    public void addColleague(Colleague colleague) {
        this.colleagues.add(colleague);
    }
}
