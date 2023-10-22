package de.tum.in.ase.pse;

public abstract class Car {
    private String licensePlate;
    private int seats;
    private int hp;

    private int tankSize;
    private int batterySize;
    private int currentTank;
    private int currentBattery;

    public int getCurrentBattery() {
        return currentBattery;
    }

    public void setCurrentBattery(int currentBattery) {
        this.currentBattery = currentBattery;
    }

    public int getCurrentTank() {
        return currentTank;
    }

    public void setCurrentTank(int currentTank) {
        this.currentTank = currentTank;
    }

    public int getTankSize() {
        return tankSize;
    }

    public void setTankSize(int tankSize) {
        this.tankSize = tankSize;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public Car(String licensePlate, int seats, int hp, int tankSize, int currentTank, int batterySize, int currentBattery) {
        this.licensePlate = licensePlate;
        this.seats = seats;
        this.hp = hp;
        this.tankSize = tankSize;
        this.batterySize = batterySize;
        this.currentTank = currentTank;
        this.currentBattery = currentBattery;
    }

    public Car(String licensePlate, int seats, int hp) {
        this.licensePlate = licensePlate;
        this.seats = seats;
        this.hp = hp;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
