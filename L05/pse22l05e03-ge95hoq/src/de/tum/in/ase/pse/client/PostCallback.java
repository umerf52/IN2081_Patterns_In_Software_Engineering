package de.tum.in.ase.pse.client;


import de.tum.in.ase.pse.model.Car;
import kong.unirest.Callback;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;

public class PostCallback implements Callback<JsonNode> {
    private final Car car;
    private final RESTClientDelegate delegate;

    /**
     * constructor -> binds the car to be deleted and the delegate who
     * will fulfill the request to this class
     */
    public PostCallback(Car car, RESTClientDelegate delegate) {
        this.car = car;
        this.delegate = delegate;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        /*TODO:implement the POST-response.*/
        int status = getResponseStatus(response);
        JsonNode responseBody = getResponseBody(response);
        String id = getCarId(responseBody);
        car.setId(id);
        delegate.newCarFinished(car, status);
    }

    //you can leave it as it is
    @Override
    public void failed(UnirestException e) {
        System.out.println("POST request has failed: " + e.getMessage());
    }

    //you can leave it as it is
    @Override
    public void cancelled() {
        System.out.println("POST request was cancelled");
    }

    //AUXILIARY METHODS

    /**
     * returns the status of a response to a REST request
     */
    private int getResponseStatus(HttpResponse<JsonNode> response) {
        int status = response.getStatus();
        System.out.println("POST car request has completed with status " + status);
        return status;
    }

    /**
     * returns the body of a response to a REST request as a JsonNode
     */
    private JsonNode getResponseBody(HttpResponse<JsonNode> response) {
        return response.getBody();
    }

    /**
     * returns the car id in form of a String-> gets the object(car) from the body of a response and
     * gets the id property of the object
     */
    private String getCarId(JsonNode body) {
        return body.getObject().getString("id");
    }
}
