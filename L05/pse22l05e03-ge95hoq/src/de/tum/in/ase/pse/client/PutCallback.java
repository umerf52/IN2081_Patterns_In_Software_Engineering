package de.tum.in.ase.pse.client;


import de.tum.in.ase.pse.model.Car;
import kong.unirest.Callback;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;

public class PutCallback implements Callback<JsonNode> {
    private final Car car;
    private final RESTClientDelegate delegate;

    /**
     * constructor -> binds the car to be deleted and the delegate who
     * will fulfill the request to this class
     */
    public PutCallback(Car car, RESTClientDelegate delegate) {
        this.delegate = delegate;
        this.car = car;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        /*TODO:implement the PUT-response.*/
        int status = getResponseStatus(response);
        JsonNode body = getResponseBody(response);
        System.out.println(body);
        delegate.updateCarFinished(car, status);
    }

    //you can leave it as it is
    @Override
    public void failed(UnirestException e) {
        System.out.println("PUT request has failed: " + e.getMessage());

    }

    //you can leave it as it is
    @Override
    public void cancelled() {
        System.out.println("PUT request was cancelled");
    }

    //AUXILIARY METHODS

    /**
     * returns the status of a response to a REST request
     */
    private int getResponseStatus(HttpResponse<JsonNode> response) {
        int status = response.getStatus();
        System.out.println("PUT car request with id " + car.getId() + " has completed with status " + status);
        return status;
    }

    /**
     * returns the body of a response to a REST request as a JsonNode
     */
    private JsonNode getResponseBody(HttpResponse<JsonNode> response) {
        return response.getBody();
    }
}
