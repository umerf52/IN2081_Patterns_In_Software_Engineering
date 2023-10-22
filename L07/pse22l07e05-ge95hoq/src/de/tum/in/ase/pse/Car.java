package de.tum.in.ase.pse;

public abstract class Car {
    private static final int CAR_BASE_PRICE = 30_000;
    private static final int CAR_BASE_MAX_SPEED = 180; // in km/h
    private static final int ENGINE_UPGRADE_ADDED_SPEED = 120; // in km/h


    public abstract int calculateCarPrice();

    public abstract int calculateMaxSpeed();


    protected int getCarBasePrice() {
        return CAR_BASE_PRICE;
    }


    protected int getCarBaseMaxSpeed() {
        return CAR_BASE_MAX_SPEED;
    }

    protected int getEngineUpgradeAddedSpeed() {
        return ENGINE_UPGRADE_ADDED_SPEED;
    }




}
