package de.tum.in.ase.pse.model;

import java.util.Objects;

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

	@Override
	public String toString() {
		return "Car{" +
				"id='" + id + '\'' +
				", color='" + color + '\'' +
				", brand='" + brand + '\'' +
				", rentalCostPerDay=" + rentalCostPerDay +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return getRentalCostPerDay() == car.getRentalCostPerDay() && Objects.equals(getId(), car.getId()) && Objects.equals(getColor(), car.getColor()) && Objects.equals(getBrand(), car.getBrand());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getColor(), getBrand(), getRentalCostPerDay());
	}
}
