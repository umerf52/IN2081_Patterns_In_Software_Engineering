package de.tum.in.ase.pse;

public final class Client {

	private Client() {
	}

	public static void main(String[] args) {

		//TODO remove the comments below and implement the necessary interfaces and classes
        ConcreteMediator mediator = new ConcreteMediator();
        InOfficeColleague allan = new InOfficeColleague(mediator, "Allan");
        InOfficeColleague barbara = new InOfficeColleague(mediator, "Barbara");
        MobileColleague cleo = new MobileColleague(mediator, "Cleo");
        mediator.addColleague(allan);
        mediator.addColleague(barbara);
        mediator.addColleague(cleo);
        allan.send("Hello World from Allan");
        cleo.send("Hello from Cleo on her mobile");

	}
}
