package de.tum.in.ase.pse;

public class FamilyCar extends Car {

    @Override
    public int calculateCarPrice() {
        return getCarBasePrice();
    }

    @Override
    public int calculateMaxSpeed() {
        return getCarBaseMaxSpeed();
    }

}
