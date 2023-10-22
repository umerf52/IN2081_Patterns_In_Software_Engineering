package de.tum.in.ase.pse;

public class UpwardCommand implements Command {

    private float upwardSpeed;
    private Drone drone;

    public UpwardCommand(float upwardSpeed, Drone drone) {
        this.upwardSpeed = upwardSpeed;
        this.drone = drone;
    }

    @Override
    public void execute() {
        if (!drone.isFlying()) {
            drone.setFlying(true);
        }
        drone.flyUpward(upwardSpeed);
    }
}

