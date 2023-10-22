package de.tum.in.ase.pse;

public class EBike extends PEV {

    private static final int PRICE_PER_MIN = 3;
    public EBike(int chargeLevel, String licensePlate) {
        super(chargeLevel, licensePlate);
        setPricePerMinute(PRICE_PER_MIN);
    }

    @Override
    public String toString() {
        return "E-Bike " + getLicensePlate() + " with charge level of " + getChargeLevel();
    }
}
