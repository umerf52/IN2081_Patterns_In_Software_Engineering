package de.tum.in.ase.pse.client;


import de.tum.in.ase.pse.model.Car;
import kong.unirest.Callback;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class GetAllCarsCallback implements Callback<JsonNode> {

    private final RESTClientDelegate delegate;

    /**
     * constructor -> binds the delegate who
     * will fulfill the request to this class
     */
    public GetAllCarsCallback(RESTClientDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        /*TODO:implement the GET-response.*/
        int status = getResponseStatus(response);
        JsonNode responseBody = getResponseBody(response);
        System.out.println(responseBody);
        JSONArray jsonArray = responseBody.getArray();
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject body = getCarJson(responseBody, i);
            Car car = new Car(body);
            cars.add(car);
        }
        delegate.getAllCarsFinished(cars, status);
    }

    //you can leave it as it is
    @Override
    public void failed(UnirestException e) {
        System.out.println("GET request has failed: " + e.getMessage());
    }

    //you can leave it as it is
    @Override
    public void cancelled() {
        System.out.println("GET request was cancelled");
    }

    //AUXILIARY METHODS

    /**
     * returns the status of a response to a REST request
     */
    private int getResponseStatus(HttpResponse<JsonNode> response) {
        int status = response.getStatus();
        System.out.println("GET cars request has completed with status " + status);
        return status;
    }

    /**
     * returns the body of a response to a REST request as a JsonNode
     */
    private JsonNode getResponseBody(HttpResponse<JsonNode> response) {
        return response.getBody();
    }

    /**
     * get the car as a JSONObject -> return a single car from an Array of cars contained
     * in the body of a response
     */
    private JSONObject getCarJson(JsonNode body, int i) {
        return body.getArray().getJSONObject(i);
    }
}
