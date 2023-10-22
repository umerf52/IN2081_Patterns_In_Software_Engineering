package de.tum.in.ase.pse.model;

import kong.unirest.json.JSONObject;

import java.time.LocalDateTime;

/**
 * a class that models rental including the id of the rental, the startDate, the endDate and the user with the rental
 */
public class Rental {
    private String id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User user;
    private Car car;

    public Rental(String id, User user, Car car, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rental(JSONObject rentalJson) {
        this.id = rentalJson.getString("id");
    }

    /**
     * for deserialization
     */
    public Rental() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
