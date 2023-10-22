package de.tum.in.ase.pse;

public class SportsCar extends Car {

    private static final int SPORTS_CAR_ADDED_PRICE = 100_000;

    @Override
    public int calculateCarPrice() {
        return getCarBasePrice() + SPORTS_CAR_ADDED_PRICE;
    }

    @Override
    public int calculateMaxSpeed() {
        return getCarBaseMaxSpeed() + getEngineUpgradeAddedSpeed();
    }

}
