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
class AdvancedNavigationServiceTest {

	// TODO make sure to specify the necessary elements for the mock object pattern and to use the required mock type (NICE)
    @Mock(type = MockType.NICE)
    private RealTimePositionService realTimePositionService;

    @TestSubject
    private NavigationService navigationService = new NavigationService(realTimePositionService);

    // TODO make sure to initialize the attributes required for the tests
    private PEV pev = new EBike(100, "1234");


    // TODO implement testConnectionLoss()
    @Test
    void testConnectionLoss() {
        Destination destination = new Destination(5, 5, "home");
        expect(realTimePositionService.getX(pev)).andReturn(0);
        expect(realTimePositionService.getY(pev)).andReturn(0);
        expect(realTimePositionService.getDirection(pev)).andReturn(null);
        replay(realTimePositionService);
        assertEquals("connection lost", navigationService.getInstructions(pev, destination));
        verify(realTimePositionService);
    }

    // TODO implement testCorrectConnection()
    //      Remark: make sure to use the verify() functionality
    //              & that the test fails due to a verify error
    @Test
    void testCorrectConnection() {
        expect(realTimePositionService.getX(pev)).andReturn(0);
        expect(realTimePositionService.getY(pev)).andReturn(0);
        expect(realTimePositionService.getDirection(pev)).andReturn(Direction.NORTH);
        replay(realTimePositionService);
        assertEquals("correctly connected", navigationService.isCorrectlyConnected(pev));
        verify(realTimePositionService);
    }
}
