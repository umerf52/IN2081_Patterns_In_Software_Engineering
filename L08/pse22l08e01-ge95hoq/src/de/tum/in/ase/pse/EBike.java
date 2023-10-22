package de.tum.in.ase.pse;

public class EBike extends PEV {

    private static final int PRICE_PER_MINUTE = 3;
    public EBike(int chargeLevel, String licensePlate) {
        super(chargeLevel, licensePlate);
        this.setPricePerMinute(PRICE_PER_MINUTE);
    }

    @Override
    public String toString() {
        return "E-Bike " + getLicensePlate() + " with charge level of " + getChargeLevel();
    }
}
