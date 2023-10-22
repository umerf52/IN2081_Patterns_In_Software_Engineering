package de.tum.in.ase.pse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rider {

    private final String name;
    private int age;
    private boolean hasHelmet;
    private DriversLicense driversLicense;

    private PEV pev;
    private final List<Rental> rentals;
    private static final int TEN_YEARS = 10;

    public Rider(String name, int age, boolean hasHelmet, DriversLicense driversLicense) {
        this.name = name;
        this.age = age;
        this.hasHelmet = hasHelmet;
        this.driversLicense = driversLicense;
        this.rentals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean hasHelmet() {
        return hasHelmet;
    }

    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    public PEV getPEV() {
        return pev;
    }

    public boolean isHasHelmet() {
        return hasHelmet;
    }

    public void setPEV(PEV pev1) {
        this.pev = pev1;
    }

    public DriversLicense getDriversLicense() {
        return driversLicense;
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(rentals);
    }

    public void receiveDriversLicense() {
        this.driversLicense = new DriversLicense(LocalDateTime.now().plusYears(TEN_YEARS), name);
    }

    public void rent(PEV pev1, LocalDateTime from, LocalDateTime to) {
        try {
            Rental rental = pev1.rent(from, to, this);
            this.rentals.add(rental);
        } catch (IllegalArgumentException ignored) {
            System.out.println("Couldn't book the pev since it is already booked");
        }
    }
}
