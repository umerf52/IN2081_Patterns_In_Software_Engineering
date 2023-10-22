package de.tum.in.ase.pse.client;


import de.tum.in.ase.pse.model.Rental;
import kong.unirest.Callback;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class GetRentalCallback implements Callback<JsonNode> {

    private final RESTClientDelegate delegate;

    /**
     * constructor -> binds the delegate who
     * will fulfill the request to this class
     */
    public GetRentalCallback(RESTClientDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        /*TODO:implement the GET-response.*/
        int status = getResponseStatus(response);
        List<Rental> rentals = new LinkedList<>();
        JsonNode responseBody = getResponseBody(response);
        rentals.add(new Rental(responseBody.getObject()));
        delegate.getAllUserRentalsFinished(rentals, status);
    }

    //you can leave it as it is
    @Override
    public void failed(UnirestException e) {
        System.out.println("Get request has failed: " + e.getMessage());
    }

    //you can leave it as it is
    @Override
    public void cancelled() {
        System.out.println("Get request was cancelled");
    }

    //AUXILIARY METHODS

    /**
     * returns the status of a response to a REST request
     */
    private int getResponseStatus(HttpResponse<JsonNode> response) {
        int status = response.getStatus();
        System.out.println("GET request to rentals has completed with status " + status);
        return status;
    }

    /**
     * returns the body of a response to a REST request as a JsonNode
     */
    private JsonNode getResponseBody(HttpResponse<JsonNode> response) {
        return response.getBody();
    }

    /**
     * get the rental as a JSONObject -> return a single rental from an Array of rentals contained
     * in the body of a response
     */
    private JSONObject getRentalJson(JsonNode body, int i) {
        return body.getArray().getJSONObject(i);
    }
}
