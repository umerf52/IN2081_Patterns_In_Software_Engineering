package de.tum.in.ase.pse;

public class SUV extends Car {

    private static final int SUV_ADDED_PRICE = 25_000;

    @Override
    public int calculateCarPrice() {
        return getCarBasePrice() + SUV_ADDED_PRICE;
    }

    @Override
    public int calculateMaxSpeed() {
        return getCarBaseMaxSpeed() / 2 + getEngineUpgradeAddedSpeed();
    }

}
