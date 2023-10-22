package de.tum.in.ase.pse;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class ReservationManager {

    private Rider reserver;
    private ReservationService reservationService;

    public ReservationManager() {
    }

    public ReservationManager(Rider reserver, ReservationService reservationService) {
        this.reserver = reserver;
        this.reservationService = reservationService;
    }

    /**
     * Rents any PEV that is rentable in the specified time frame (from to to).
     * The PEV is rentable if it is available and meets the requirements.
     *
     * @param from  Start of the time frame
     * @param to    End of the time frame
     * @return the PEV that was rented
     */
    public PEV reserveFittingPEV(LocalDateTime from, LocalDateTime to) {
        Set<PEV> foundPEVs = lookupAvailablePEVsForTimeFrame(from, to);
        if (foundPEVs.isEmpty()) {
            throw new NoPEVAvailableException();
        }
        PEV fittingPEV = foundPEVs.iterator().next();
        reserver.rent(fittingPEV, from, to);
        return fittingPEV;
    }

    /**
     * Returns a set of rentable PEVs for a given time frame (from to to),
     * taking the restrictions for the reserving rider into account.
     *
     * @param from  Start of the time frame
     * @param to    End of the time frame
     * @return set of PEVs that are available for rent for the rider (reserver)
     */
    public Set<PEV> lookupAvailablePEVsForTimeFrame(LocalDateTime from, LocalDateTime to) {
        PEVSearchCriteria pevSearchCriteria = new PEVSearchCriteria(this.reserver);
        Set<PEV> availablePEVs = this.reservationService.findAvailablePEVs(from, to);
        return availablePEVs.stream().filter(pevSearchCriteria::isPEVAllowed).collect(Collectors.toSet());
    }

    public void setRider(Rider pReserver) {
        this.reserver = pReserver;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
}
