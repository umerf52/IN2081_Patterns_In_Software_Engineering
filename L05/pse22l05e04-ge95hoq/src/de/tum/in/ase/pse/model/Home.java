package de.tum.in.ase.pse.model;

/**
 * Wrapper Class to allow usage with hateoas
 */
public class Home {

    private static final String GREETING = "Welcome to the RESTful rental system! Follow the hypermedia links to explore our available cars.";

    public String getGreeting() {
        return GREETING;
    }
}
