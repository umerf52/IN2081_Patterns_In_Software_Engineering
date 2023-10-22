package de.tum.in.ase.pse.client;

import de.tum.in.ase.pse.model.Car;
import de.tum.in.ase.pse.model.Rental;

import java.util.List;

/**
 * interface for the methods that are implemented in the Application class
 */
public interface RESTClientDelegate {
    void getAllCarsFinished(List<Car> cars, int statusCode);

    void getCarFinished(Car car, int statusCode);

    void newCarFinished(Car car, int statusCode);

    void updateCarFinished(Car car, int statusCode);

    void deleteCarFinished(Car car, int statusCode);

    void getAllUserRentalsFinished(List<Rental> rentals, int statusCode);
}
