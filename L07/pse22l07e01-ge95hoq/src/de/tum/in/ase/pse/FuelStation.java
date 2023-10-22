package de.tum.in.ase.pse;

import java.util.concurrent.ThreadLocalRandom;

public class FuelStation {

    private static final double PRICE_PER_LITER = 1.21;
    private static final int REFUEL_BOUND = 60;

    public void refuel(Car car) {
        int liters = car.getTankSize() - car.getCurrentTank();
        int maxAmountToPay = ThreadLocalRandom.current().nextInt(REFUEL_BOUND);
        System.out.println("Car " + car.getLicensePlate() + " wants to refuel for about max. " + maxAmountToPay + " €.");
        int amountToFill = liters;
        if (liters * PRICE_PER_LITER > maxAmountToPay) {
            amountToFill = (int) ((double) maxAmountToPay / PRICE_PER_LITER);
        }
        car.setCurrentTank(car.getCurrentTank() + amountToFill);
        System.out.println("Car " + car.getLicensePlate() + " successfully refueled.");
        System.out.println(amountToFill + " liters tanked for " + amountToFill * PRICE_PER_LITER + "€.\n");
    }
}
