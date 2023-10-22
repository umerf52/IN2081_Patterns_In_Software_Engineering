package de.tum.in.ase.pse.model;

/**
 * a class that models a car including the id of the car, the color, the brand and the cost per day
 */
public class Car {
    private String id;
    private String color;
    private String brand;
    private int rentalCostPerDay;

    public Car(String id, String color, String brand, int rentalCostPerDay) {
        this.id = id;
        this.color = color;
        this.brand = brand;
        this.rentalCostPerDay = rentalCostPerDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public void setRentalCostPerDay(int rentalCostPerDay) {
        this.rentalCostPerDay = rentalCostPerDay;
    }
}
