package de.tum.in.ase.pse;

import java.util.concurrent.ThreadLocalRandom;

public class SuperCharger {
    private static final double PRICE_PER_KWH = 0.49;
    private static final int BOUND = 100;
    private static final int CHARGING_CARD_NUM = 70;
    private static final int FAST_CHARGING_NUM = 40;

    public void recharge(Car car) {
        int kWhs = car.getBatterySize() - car.getCurrentBattery();
        int luckyNumber = ThreadLocalRandom.current().nextInt(BOUND);
        boolean chargingCardAccepted = luckyNumber < CHARGING_CARD_NUM;  // Sometimes the different charging cards do not work everywhere
        boolean fastChargingAvailable = luckyNumber < FAST_CHARGING_NUM; // If not too many others charge atm., fast charging may be available
        if (chargingCardAccepted) {
            car.setCurrentBattery(car.getBatterySize());
            if (fastChargingAvailable) {
                System.out.println("Car " + car.getLicensePlate() + " successfully recharged.");
            } else {
                System.out.println("Car " + car.getLicensePlate() + " successfully recharged using fast-charging");
            }
            System.out.println(kWhs + " kWhs charged for " + kWhs * PRICE_PER_KWH + "€.\n");
        } else {
            System.out.println("Car " + car.getLicensePlate() + " could not recharge, since the charging card was declined.");
        }
    }
}
