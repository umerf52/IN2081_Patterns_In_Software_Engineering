package de.tum.in.ase.pse;

public class EMoped extends PEV {

    private static final int PRICE_PER_MINUTE = 5;
    public EMoped(int chargeLevel, String licensePlate) {
        super(chargeLevel, licensePlate);
        this.setPricePerMinute(PRICE_PER_MINUTE);
    }

    @Override
    public String toString() {
        return "E-Moped " + getLicensePlate() + " with charge level of " + getChargeLevel();
    }
}
