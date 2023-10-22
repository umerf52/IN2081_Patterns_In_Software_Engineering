package de.tum.in.ase.pse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/*
 * TODO:
 *  To use Mockito in your tests, use @ExtendWith
 *  with the MockitoExtension class.
 */

@ExtendWith(MockitoExtension.class)
class ReservationManagerTest {

    /**
     * You need two instances of LocalDateTime to write your tests.
     * Use these provided instances to make your code more readable.
     */
    private final LocalDateTime from = LocalDateTime.of(2020, 10, 10, 10, 10);
    private final LocalDateTime to = LocalDateTime.of(2020, 10, 10, 10, 11);

    /*
     * TODO:
     *  1. Declare a Rider and ReservationService Mock that will be
     *     used by the SUT ReservationManager
     *  2. Inject the Mocks into the SUT using the method discussed
     *     in the lecture
     *  3. Implement the test as described in the problem statement
     */
    private DriversLicense driversLicense = new DriversLicense(LocalDateTime.now().plusYears(10), "PSE");
    private Rider rider = new Rider("PSE", 20, true, driversLicense);

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationManager reservationManager = new ReservationManager(rider, reservationService);

    @Mock
    private Rider mockRider = new Rider("PSE", 20, true, driversLicense);

    /*
     * TODO:
     *  1. Declare a ReservationManager Spy that stubs the implementation
     *     of lookupAvailablePEVsForTimeFrame()
     *  2. Declare a PEV ArgumentCaptor that is used to check if the
     *     returned PEV matches the one rented by the reserver
     *  3. Implement the test as described in the problem statement
     */
    @Mock
    private ReservationService reservationService2;
    @Spy
    @InjectMocks
    private ReservationManager reservationManagerSpy = new ReservationManager(mockRider, reservationService2);

    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    public ReservationManager getReservationManagerSpy() {
        return reservationManagerSpy;
    }

    public void setReservationManagerSpy(ReservationManager reservationManagerSpy) {
        this.reservationManagerSpy = reservationManagerSpy;
    }

    @Test
    void testLookupAvailablePEVsReturnsValidSet() {
        when(reservationService.findAvailablePEVs(from, to)).thenReturn(Set.of());
        Set<PEV> availablePEVs = reservationManager.lookupAvailablePEVsForTimeFrame(from, to);
        assertEquals(Set.of(), availablePEVs);
        verify(reservationService).findAvailablePEVs(from, to);
    }


    @Captor
    private ArgumentCaptor<PEV> pevArgumentCaptor;

    public ArgumentCaptor<PEV> getPevArgumentCaptor() {
        return pevArgumentCaptor;
    }

    public void setPevArgumentCaptor(ArgumentCaptor<PEV> pevArgumentCaptor) {
        this.pevArgumentCaptor = pevArgumentCaptor;
    }

    @Test
    void testReserveFittingPEVsReturnsRentedPEV() {
        doReturn(Set.of(new EBike(100, "abc"))).when(reservationManagerSpy).lookupAvailablePEVsForTimeFrame(any(), any());
        PEV pev = reservationManagerSpy.reserveFittingPEV(from, to);
        verify(reservationManagerSpy).lookupAvailablePEVsForTimeFrame(from, to);
        verify(mockRider).rent(pev, from, to);
    }
}
