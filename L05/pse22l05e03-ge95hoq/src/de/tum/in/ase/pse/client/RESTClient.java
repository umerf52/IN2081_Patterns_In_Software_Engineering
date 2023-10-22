package de.tum.in.ase.pse.client;

import de.tum.in.ase.pse.model.Car;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;


public class RESTClient {

    private RESTClientDelegate delegate;

    public RESTClientDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(RESTClientDelegate delegate) {
        this.delegate = delegate;
    }

    private static final String BASE_URL = "http://localhost:8080/";

    /*Unirest is the framework that we use in this exercise and with the help of this method
     * we send an asynchronous request to the server, thus not blocking our application,
     * which is what we want most of the time*/

    // sends an asynchronous request to the server as described above
    public void getCarByID(String id) throws UnirestException {
        /*TODO: Create an asynchronous GET-request*/
        Unirest.get(BASE_URL + "cars/" + id).asJsonAsync(new GetCallback(delegate));
    }

    // sends an asynchronous request to the server as described above
    public void getAllCars() throws UnirestException {
        /*TODO: Create an asynchronous GET-request*/
        Unirest.get(BASE_URL + "cars/").asJsonAsync(new GetAllCarsCallback(delegate));
    }


    // sends an asynchronous request to the server as described above
    public void updateCar(Car car) throws UnirestException {
        /*TODO: Create an asynchronous PUT-request*/
        Unirest.put(BASE_URL + "cars").header("content-type", "application/json").body(car.toJson()).asJsonAsync(new PutCallback(car, delegate));
    }

    // sends an asynchronous request to the server as described above
    public void createNewCar(Car car) throws UnirestException {
        /*TODO: Create an asynchronous POST-request*/
        Unirest.post(BASE_URL + "cars").header("content-type", "application/json").body(car.toJson()).asJsonAsync(new PostCallback(car, delegate));
    }

    // sends an asynchronous request to the server as described above
    public void deleteCar(Car car) throws UnirestException {
        /*TODO: Create an asynchronous DELETE-request*/
        Unirest.delete(BASE_URL + "cars/" + car.getId()).asJsonAsync(new DeleteCallback(car, delegate));
    }

    /* HATEAOS method
     This function will get all rentals from all users, store it in a list and print it on success (last part done in Application).
     Therefore, 3 GET requests have to be sent to the server sequentially, each request using link/s from the previous response.
    */
    public void getAllUserRentals() throws UnirestException {
        // Get the link for all users
        /*TODO: Create an asynchronous GET-request*/
        Unirest.get(BASE_URL + "users").asJsonAsync(new GetMainURLCallback(delegate));
    }
}
