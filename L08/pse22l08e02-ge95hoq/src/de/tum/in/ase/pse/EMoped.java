package de.tum.in.ase.pse;

public class EMoped extends PEV {

    private static final int PRICE_PER_MIN = 5;
    public EMoped(int chargeLevel, String licensePlate) {
        super(chargeLevel, licensePlate);
        setPricePerMinute(PRICE_PER_MIN);
    }

    @Override
    public String toString() {
        return "E-Moped " + getLicensePlate() + " with charge level of " + getChargeLevel();
    }
}
