package de.tum.in.ase.pse.client;


import kong.unirest.*;
import kong.unirest.json.JSONArray;


public class GetUsersCallback implements Callback<JsonNode> {

    private final RESTClientDelegate delegate;

    /**
     * constructor -> binds the delegate who
     * will fulfill the request to this class
     */
    public GetUsersCallback(RESTClientDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        /*TODO:implement the GET-response.*/
        JSONArray users = getUsers(response);
        for (int i = 0; i < users.length(); i++) {
            if (checkRentalsByUser(users, i)) {
                String rentalLink = getRentalLink(users, i);
                Unirest.get(rentalLink).asJsonAsync(new GetRentalCallback(delegate));
            }
        }
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
     * returns an array of JSONObjects, which are the users, from a response to a REST request
     */
    private JSONArray getUsers(HttpResponse<JsonNode> response) {
        return response.getBody().getObject().getJSONObject("_embedded").getJSONArray("userList");
    }

    /**
     * returns true or false, depending on whether the user has rentals or not
     */
    private boolean checkRentalsByUser(JSONArray users, int i) {
        return !users.getJSONObject(i).getJSONObject("_links").isNull("rentals");
    }

    /**
     * return the link to the rentals of the user
     */
    private String getRentalLink(JSONArray users, int i) {
        return users.getJSONObject(i).getJSONObject("_links").getJSONObject("rentals").getString("href");
    }
}
