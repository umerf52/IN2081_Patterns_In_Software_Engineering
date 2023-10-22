package de.tum.in.ase.pse;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EasyMockExtension.class)
class NavigationServiceTest {

    // TODO make sure to specify the necessary elements for the mock object pattern and to use the required mock type (STRICT)
    @Mock(type = MockType.STRICT)
    private RealTimePositionService realTimePositionService;

    @TestSubject
    private NavigationService navigationService = new NavigationService(realTimePositionService);

    // TODO make sure to initialize the attributes required for the tests
    private PEV pev = new EBike(100, "1234");


    // TODO implement testDestinationReached()
    @Test
    void testDestinationReached() {
        Destination destination = new Destination(0, 0, "home");
        expect(realTimePositionService.getX(pev)).andReturn(0);
        expect(realTimePositionService.getY(pev)).andReturn(0);
        expect(realTimePositionService.getDirection(pev)).andReturn(Direction.NORTH);
        replay(realTimePositionService);
        assertEquals("destination reached", navigationService.getInstructions(pev, destination));
        verify(realTimePositionService);
    }

    // TODO implement testDirectionDistance()
    @Test
    void testDirectionDistance() {
        Destination destination = new Destination(0, 0, "home");
        expect(realTimePositionService.getDirection(pev)).andReturn(Direction.SOUTH);
        expect(realTimePositionService.getX(pev)).andReturn(0);
        expect(realTimePositionService.getY(pev)).andReturn(5);
        replay(realTimePositionService);
        assertEquals("drive south for 5 more kilometers", navigationService.getDirectionDistance(pev, destination));
        verify(realTimePositionService);
    }
}
