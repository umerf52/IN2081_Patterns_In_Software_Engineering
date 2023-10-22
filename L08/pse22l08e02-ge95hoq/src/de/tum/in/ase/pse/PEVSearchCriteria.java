package de.tum.in.ase.pse;

import java.time.LocalDateTime;

public class PEVSearchCriteria {

    private static final int AGE = 16;
    private final boolean ageRestriction;
    private final boolean validDriversLicense;
    private final boolean helmetAvailable;

    public PEVSearchCriteria(Rider rider) {
        this(rider.getAge() >= AGE,
                rider.getDriversLicense() != null
                        &&
                        rider.getDriversLicense().getValidUntil().isAfter(LocalDateTime.now()), rider.hasHelmet());
    }

    private PEVSearchCriteria(boolean ageRestriction, boolean validDriversLicense, boolean helmetAvailable) {
        this.ageRestriction = ageRestriction;
        this.validDriversLicense = validDriversLicense;
        this.helmetAvailable = helmetAvailable;
    }

    public boolean isPEVAllowed(PEV pev) {
        if(pev instanceof EBike) {
            return helmetAvailable;
        } else if(pev instanceof EKickscooter) {
            return ageRestriction && helmetAvailable;
        } else if(pev instanceof EMoped) {
            return validDriversLicense;
        }
        return true;
    }
}
