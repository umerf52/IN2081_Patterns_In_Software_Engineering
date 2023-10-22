package de.tum.in.ase.pse;

public class StopState extends ElevatorState {
    @Override
    public void request(int floor, Controller controller) {

    }

    @Override
    public void signal(int floor, Controller controller) {
        if (controller.getPool().size() > 0) {
            controller.setState(new MovingState());
        } else {
            controller.setState(new IdleState());
        }
    }

    @Override
    public String getName() {
        return "stop";
    }
}
