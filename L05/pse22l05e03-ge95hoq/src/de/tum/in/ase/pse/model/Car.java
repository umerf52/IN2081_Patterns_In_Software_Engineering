package de.tum.in.ase.pse.model;

import kong.unirest.json.JSONObject;

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

    public Car(JSONObject userJson) {
        this.id = userJson.getString("id");
        this.color = userJson.getString("color");
        this.brand = userJson.getString("brand");
        this.rentalCostPerDay = userJson.getInt("rentalCostPerDay");
    }

    /**
     * for deserialization
     */
    public Car() {
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

    public JSONObject toJson() {
        JSONObject userJson = new JSONObject();
        userJson.put("id", id);
        userJson.put("color", color);
        userJson.put("brand", brand);
        userJson.put("rentalCostPerDay", rentalCostPerDay);
        return userJson;
    }
}
