package de.tum.in.ase.pse.ecommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Order {

	private Shipping shipping;
	private final double price;
	private final int id;
	private final String deliveryDate;
	private final List<Item> items;
	private static int count = 0;
	private static final int MINIMUM_NUMBER_OF_DAYS = 3;
	private static final int MAXIMUM_NUMBER_OF_DAYS = 14;

	public Order(List<Item> items) {
		this.items = new ArrayList<>(items);
		this.price = calculateTotalSum();
		this.id = generateId();
		this.deliveryDate = calculateDeliveryDate();
	}

	private double calculateTotalSum() {
		return items.stream().mapToDouble(Item::getPrice).sum();
	}

	private String calculateDeliveryDate() {
		int randomNumberOfDays = MINIMUM_NUMBER_OF_DAYS
				+ (int) (ThreadLocalRandom.current().nextFloat() * (MAXIMUM_NUMBER_OF_DAYS - MINIMUM_NUMBER_OF_DAYS));
		var date = LocalDateTime.now().plusDays(randomNumberOfDays);
		var formatter = DateTimeFormatter.ofPattern("h B");
		return "Delivery date: " + date.toLocalDate() + " at " + date.format(formatter);
	}

	public String getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public double getPrice() {
		return price;
	}

	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	private static int generateId() {
		return ++count;
	}

}
