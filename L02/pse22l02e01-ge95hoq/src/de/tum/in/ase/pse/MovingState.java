package de.tum.in.ase.pse;

public class MovingState extends ElevatorState {
    @Override
    public void request(int floor, Controller controller) {
        controller.getPool().add(floor);
    }

    @Override
    public void signal(int floor, Controller controller) {
        if (floor == controller.getNextStop()) {
            controller.getPool().remove(0);
            controller.setState(new StopState());
        }
    }

    @Override
    public String getName() {
        return "moving";
    }
}
