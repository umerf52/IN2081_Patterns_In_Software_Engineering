package de.tum.in.ase.pse;

import de.tum.in.ase.pse.client.Client;

public class Main {
    private final Client client = new Client();

    public static void main(String[] args) {
        Main main = new Main();
        main.operate();
    }

    public void operate() {
        System.out.println(client.findApprentices());
        System.out.println(client.trainApprentices());
    }
}
