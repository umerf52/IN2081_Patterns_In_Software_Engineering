package de.tum.in.ase.pse;

public class IdleState extends ElevatorState {
    @Override
    public void request(int floor, Controller controller) {
        controller.setState(new MovingState());
        controller.getPool().add(floor);
    }

    @Override
    public void signal(int floor, Controller controller) {

    }

    @Override
    public String getName() {
        return "idle";
    }
}
