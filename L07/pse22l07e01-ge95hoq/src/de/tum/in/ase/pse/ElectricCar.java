package de.tum.in.ase.pse;

public class ElectricCar extends Car {
    private final SuperCharger superCharger = new SuperCharger();
    public ElectricCar(String licensePlate, int seats, int hp, int batterySize, int currentBattery) {
        super(licensePlate, seats, hp);
        setBatterySize(batterySize);
        setCurrentBattery(currentBattery);
    }
    public void recharge() {
        this.superCharger.recharge(this);
    }
}
