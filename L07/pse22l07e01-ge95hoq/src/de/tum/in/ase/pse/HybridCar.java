package de.tum.in.ase.pse;

public class HybridCar extends Car {
    private final SuperCharger superCharger = new SuperCharger();
    private final FuelStation fuelStation = new FuelStation();
    public HybridCar(String licensePlate, int seats, int hp, int tankSize, int batterySize, int currentTank, int currentBattery) {
        super(licensePlate, seats, hp);
        setTankSize(tankSize);
        setBatterySize(batterySize);
        setCurrentTank(currentTank);
        setCurrentBattery(currentBattery);
    }
    public void refuel() {
        fuelStation.refuel(this);
    }
    public void recharge() {
        superCharger.recharge(this);
    }
}
