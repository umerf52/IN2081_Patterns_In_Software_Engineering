package de.tum.in.ase.pse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class PEV {

    private int chargeLevel;
    private final String licensePlate;
    private boolean available;

    private int pricePerMinute;

    private final List<Rental> rentals;

    public PEV(int chargeLevel, String licensePlate) {
        this.chargeLevel = chargeLevel;
        this.licensePlate = licensePlate;
        this.available = true;
        rentals = new ArrayList<>();
    }

    @Override
    public abstract String toString();

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public void setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    public boolean isAvailable() {
        return available;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
    public void setPricePerMinute(int pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public int getPricePerMinute() {
        return pricePerMinute;
    }

    public void lock() {
        if (!available) {
            throw new IllegalStateException("Already locked");
        }
        available = false;
    }

    public void unlock() {
        if (available) {
            throw new IllegalStateException("Already unlocked");
        }
        available = true;
    }

    public Rental rent(LocalDateTime from, LocalDateTime to, Rider rider) {
        if (isBooked(from, to)) {
            throw new IllegalArgumentException("Already booked!");
        }
        Rental rental = new Rental(from, to, this, rider);
        rentals.add(rental);
        return rental;
    }

    private boolean isBooked(LocalDateTime from, LocalDateTime to) {
        return rentals.stream().anyMatch(rental -> from.isBefore(rental.getTo()) && rental.getFrom().isBefore(to));
    }

    public void ride() {
        System.out.println("Riding " + toString());
    }
    
    @Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PEV pev)) {
			return false;
		}
		return getChargeLevel() == pev.getChargeLevel() && isAvailable() == pev.isAvailable()
		       && getPricePerMinute() == pev.getPricePerMinute() && Objects.equals(getLicensePlate(), pev.getLicensePlate())
		       && getRentals().equals(pev.getRentals());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getChargeLevel(), getLicensePlate(), isAvailable(), getPricePerMinute(), getRentals());
	}
}
