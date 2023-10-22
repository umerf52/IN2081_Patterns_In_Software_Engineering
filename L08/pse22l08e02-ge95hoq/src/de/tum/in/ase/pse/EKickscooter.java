package de.tum.in.ase.pse;

public class EKickscooter extends PEV {

    private static final int PRICE_PER_MIN = 2;
    public EKickscooter(int chargeLevel, String licensePlate) {
        super(chargeLevel, licensePlate);
        setPricePerMinute(PRICE_PER_MIN);
    }

    @Override
    public String toString() {
        return "E-Kickscooter " + getLicensePlate() + " with charge level of " + getChargeLevel();
    }
}
