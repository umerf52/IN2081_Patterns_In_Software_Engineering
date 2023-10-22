package de.tum.in.ase.pse;

public class ReturnHomeCommand implements Command {

    private Drone drone;

    public ReturnHomeCommand(Drone drone) {
        this.drone = drone;
    }

    @Override
    public void execute() {
        if (drone.isFlying()) {
            drone.flyHome();
            drone.setFlying(false);
        } else {
            System.out.println("Drone is on the floor and cannot return home/ is already home");
        }
    }
}
