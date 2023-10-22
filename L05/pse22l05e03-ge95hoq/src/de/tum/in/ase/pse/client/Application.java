package de.tum.in.ase.pse.client;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import de.tum.in.ase.pse.model.Car;
import de.tum.in.ase.pse.model.Rental;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Application implements RESTClientDelegate {

    private RESTClient client;
    private Car car;

    /**
     * starts the application and invokes a series of REST requests
     */
    public static void main(String[] args) {
        Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);

        Application app = new Application();
        app.invokeRESTRequest();
    }

    /**
     * binds the REST-requests to the concrete client
     */
    public Application() {
        client = new RESTClient();
        client.setDelegate(this);
        Unirest.shutDown();
    }

    /**
     * a series of REST requests - GET requests, POST request, PUT request, DELETE request
     */
    public void invokeRESTRequest() {
        try {
            client.getAllUserRentals();

            client.getAllCars();

            client.getCarByID("10");

            Car changedCar = new Car("10", "red", "Mercedes", 125);
            client.updateCar(changedCar);

            Car newCar = new Car("5", "yellow", "Toyota", 30);
            client.createNewCar(newCar);

            car = new Car("7", "blue", "Opel", 50);
            client.createNewCar(car);
            if (car.getId().equals("7")) {
                Thread.sleep(100);
            }
            client.deleteCar(car);

        } catch (UnirestException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * a method for returning the number of cars stored in the car rental server
     */
    @Override
    public void getAllCarsFinished(List<Car> cars, int statusCode) {
        System.out.println("Found " + cars.size() + " cars");
    }

    /**
     * a method for getting the data about a specific car
     */
    @Override
    public void getCarFinished(Car car, int statusCode) {
        System.out.println("Found " + car.getBrand() + " car");
    }

    /**
     * a method for creating a new entry for a car
     */
    @Override
    public void newCarFinished(Car car, int statusCode) {
        this.car = car;
        System.out.println("New car " + car.toJson());
    }

    /**
     * a method for updating a car
     */
    @Override
    public void updateCarFinished(Car car, int statusCode) {
        System.out.println("Updated car " + car.toJson());
    }

    /**
     * a method for deleting an entry for a car
     */
    @Override
    public void deleteCarFinished(Car car, int statusCode) {
        System.out.println("Delete car " + car.toJson());
    }

    /**
     * a method for returning the number of rentals
     */
    @Override
    public void getAllUserRentalsFinished(List<Rental> rentals, int statusCode) {
        System.out.println("Found " + rentals.size() + " rentals");
    }
}
