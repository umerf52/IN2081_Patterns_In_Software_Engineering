package de.tum.in.ase.pse;

public final class Main {

    private Main() {
    }

    private static final int SEATS = 5;
    private static final int ELECTRIC_CAR_SEATS = 4;
    private static final int GASOLINE_HP = 172;
    private static final int HYBRID_HP = 201;
    private static final int ELECTRIC_CAR_HP = 136;
    private static final int GASOLINE_TANK_SIZE = 60;
    private static final int HYBRID_TANK_SIZE = 40;
    private static final int GASOLINE_CUR_TANK = 18;
    private static final int HYBRID_CUR_TANK = 22;
    private static final int HYBRID_BATTERY_SIZE = 20;
    private static final int ELECTRIC_BATTERY_SIZE = 90;
    private static final int HYBRID_CUR_BATTERY = 14;
    private static final int ELECTRIC_CUR_BATTERY = 27;

    /**
     * This function simulates the different cars and their refueling
     * You can use it for testing if your refactored code still contains the same functionality.
     */
    public static void main(String[] args) {
        GasolineCar gasolineCar = new GasolineCar("M-LS 6051", SEATS, GASOLINE_HP, GASOLINE_TANK_SIZE, GASOLINE_CUR_TANK);
        HybridCar hybridCar = new HybridCar("M-DX 7311", SEATS, HYBRID_HP, HYBRID_TANK_SIZE, HYBRID_BATTERY_SIZE, HYBRID_CUR_TANK, HYBRID_CUR_BATTERY);
        ElectricCar electricCar = new ElectricCar("M-PJ 0301", ELECTRIC_CAR_SEATS, ELECTRIC_CAR_HP, ELECTRIC_BATTERY_SIZE, ELECTRIC_CUR_BATTERY);

        //gasoline car test
        System.out.println("------------------\n\nGasoline car test:\n");
        gasolineCar.startMotorWithKey();
        gasolineCar.refuel();
        gasolineCar.startMotorWithStartStop();
        System.out.println("Motor crashed - restart necessary!\n");
        gasolineCar.startMotorWithButton();

        //hybrid car test
        System.out.println("----------------\n\nHybrid car test:\n");
        hybridCar.refuel();
        hybridCar.recharge();

        //electric car test
        System.out.println("------------------\n\nElectric car test:\n");
        electricCar.recharge();
    }
}
