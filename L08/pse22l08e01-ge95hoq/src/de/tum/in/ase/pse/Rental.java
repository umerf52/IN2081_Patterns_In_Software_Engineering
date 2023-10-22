package de.tum.in.ase.pse;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rental {

    private final LocalDateTime from;
    private final LocalDateTime to;
    private final PEV rentedPEV;
    private final Rider rider;
    private static final int TIME_FRAME = 60;

    public Rental(LocalDateTime from, LocalDateTime to, PEV rentedPEV, Rider rider) {
        if (from.isAfter(to)) {
            throw new IllegalArgumentException();
        }

        this.from = from;
        this.to = to;
        this.rentedPEV = rentedPEV;
        this.rider = rider;
    }

    public long timeElapsed() {
        return Duration.between(from, to).toSeconds();
    }

    public void start() {
        // Only allow starting the rental within a two minute time frame around "from"
        if (Math.abs(Duration.between(LocalDateTime.now(), from).toSeconds()) > TIME_FRAME) {
            throw new IllegalStateException("Rental cannot be started.");
        }

        rentedPEV.lock();
        rider.setPEV(rentedPEV);
    }

    public void stop() {
        rentedPEV.unlock();
        rider.setPEV(null);
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public PEV getRentedPEV() {
        return rentedPEV;
    }
}