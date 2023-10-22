package de.tum.in.ase.pse;

/**
 * The NavigationService, which is used to give instructions to the rider of a
 * PEV.
 */
public class NavigationService {
    private RealTimePositionService realTimePositionService;

    public NavigationService() {
    }

    public NavigationService(RealTimePositionService realTimePositionService) {
        this.realTimePositionService = realTimePositionService;
    }

    public RealTimePositionService getRealTimePositionService() {
        return realTimePositionService;
    }

    public void setRealTimePositionService(RealTimePositionService realTimePositionService) {
        this.realTimePositionService = realTimePositionService;
    }

    /**
     * Gives instructions to the rider of a PEV how the reach a destination.
     * <p>
     * "destination reached" if the position of the PEV matches that of the
     * destination.
     * <p>
     * "drive north" / "drive south" if the rider is currently south/north of the
     * destination and not facing that direction.
     * <p>
     * "drive east" / "drive west" if the rider is neither south nor north, but
     * west/east of the destination and not facing that direction.
     * <p>
     * "continue" if the rider is already facing the correct direction.
     *
     * @param pev         the PEV used be the rider
     * @param destination the destination the rider wants to drive to
     * @return the instruction for the rider what they should do next
     */
    public String getInstructions(PEV pev, Destination destination) {
        int pevX = realTimePositionService.getX(pev);
        int pevY = realTimePositionService.getY(pev);
        Direction direction = realTimePositionService.getDirection(pev);

        boolean sameX = pevX == destination.getX();
        boolean sameY = pevY == destination.getY();

        Direction destDirection;

        if (direction == null && pevX == 0 && pevY == 0) {
            return "connection lost";
        }
        if (!sameY) {
            destDirection = pevY < destination.getY() ? Direction.NORTH : Direction.SOUTH;
        } else if (!sameX) {
            destDirection = pevX < destination.getX() ? Direction.EAST : Direction.WEST;
        } else {
            return "destination reached";
        }
        if (destDirection == direction) {
            return "continue";
        }
        // could also make it more interesting by using "turn ..."
        return "drive " + destDirection.name().toLowerCase();
    }

    public String getDirectionDistance(PEV pev, Destination destination) {
        Direction direction = realTimePositionService.getDirection(pev);
        int pevX = realTimePositionService.getX(pev);
        int pevY = realTimePositionService.getY(pev);

        if (direction.equals(Direction.NORTH)) {
            return "drive " + direction.name().toLowerCase() + " for " + (destination.getY() - pevY) + " more kilometers";
        } else if (direction.equals(Direction.SOUTH)){
            return "drive " + direction.name().toLowerCase() + " for " + (pevY - destination.getY()) + " more kilometers";
        } else if (direction.equals(Direction.WEST)) {
            return "drive " + direction.name().toLowerCase() + " for " + (destination.getX() - pevX) + " more kilometers";
        } else {
            return "drive " + direction.name().toLowerCase() + " for " + (pevX - destination.getX()) + " more kilometers";
        }
    }

    public String isCorrectlyConnected(PEV pev) {
        if (realTimePositionService.getX(pev) >= 0 && realTimePositionService.getY(pev) >= 0) {
            return "correctly connected";
        }
        else {
            return "not correctly connected";
        }
    }
}
