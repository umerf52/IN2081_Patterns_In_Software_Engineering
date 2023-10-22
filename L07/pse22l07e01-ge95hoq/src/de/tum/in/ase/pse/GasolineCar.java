package de.tum.in.ase.pse;

public class GasolineCar extends Car {
    private final FuelStation fuelStation = new FuelStation();
    public GasolineCar(String licensePlate, int seats, int hp, int tankSize, int currentTank) {
        super(licensePlate, seats, hp);
        setCurrentTank(currentTank);
        setTankSize(tankSize);
    }
    public void refuel() {
        fuelStation.refuel(this);
    }
    private void startMotor() {
        System.out.println("Motor start operations:");
        activateStarter();
        mixWithCarburetor();
        igniteSparkPlug();
        motorRunning();
    }
    public void startMotorWithKey() {
        System.out.println("Start motor with key:");
        startMotor();
        System.out.println("Car " + getLicensePlate() + " => Motor start via key was successful.\n");
    }
    public void startMotorWithButton() {
        System.out.println("Start motor with button:");
        startMotor();
        System.out.println("Car " + getLicensePlate() + " => Motor start via button was successful.\n");
    }
    public void startMotorWithStartStop() {
        System.out.println("Start motor with start/stop:");
        startMotor();
        System.out.println("Car " + getLicensePlate() + " => Motor start via start/stop was successful.\n");
    }
    private void activateStarter() {
        System.out.println("Car starter successfully activated.");
    }
    private void mixWithCarburetor() {
        System.out.println("Fuel and air successfully mixed by carburetor.");
    }
    private void igniteSparkPlug() {
        System.out.println("Spark plugs successfully ignited.");
    }
    private void motorRunning() {
        System.out.println("Motor is running.");
    }
}
