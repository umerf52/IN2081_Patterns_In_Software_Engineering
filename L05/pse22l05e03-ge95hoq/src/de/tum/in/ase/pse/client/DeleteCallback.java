package de.tum.in.ase.pse.client;

import de.tum.in.ase.pse.model.Car;
import kong.unirest.Callback;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;

public class DeleteCallback implements Callback<JsonNode> {

    private final Car car;
    private final RESTClientDelegate delegate;

    /**
     * constructor -> binds the car to be deleted and the delegate who
     * will fulfill the request to this class
     */
    public DeleteCallback(Car car, RESTClientDelegate delegate) {
        this.delegate = delegate;
        this.car = car;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        /*TODO:implement the DELETE-response.*/
        int status = getResponseStatus(response);
        JsonNode responseBody = getResponseBody(response);
        String id = getCarId(responseBody);
        car.setId(id);
        delegate.deleteCarFinished(car, status);
    }

    // You can leave this as it is
    @Override
    public void failed(UnirestException e) {
        System.out.println("DELETE request has failed: " + e.getMessage());

    }

    // You can leave this as it is
    @Override
    public void cancelled() {
        System.out.println("DELETE request was cancelled");
    }

    //AUXILIARY METHODS

    /**
     * returns the status of a response to a REST request
     */
    private int getResponseStatus(HttpResponse<JsonNode> response) {
        int status = response.getStatus();
        System.out.println("DELETE car request has completed with status " + status);
        return status;
    }

    /**
     * returns the body of a response to a REST request as a JsonNode
     */
    private JsonNode getResponseBody(HttpResponse<JsonNode> response) {
        return response.getBody();
    }

    /**
     * returns the car id in form of a String-> gets the object (car) from the body of a response and
     * gets the id property of the object
     */
    private String getCarId(JsonNode body) {
        return body.getObject().getString("id");
    }
}
