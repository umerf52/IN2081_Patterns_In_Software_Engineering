package de.tum.in.ase.pse.client;


import kong.unirest.*;

public class GetMainURLCallback implements Callback<JsonNode> {

    private final RESTClientDelegate delegate;

    /**
     * constructor -> binds the delegate who
     * will fulfill the request to this class
     */
    public GetMainURLCallback(RESTClientDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void completed(HttpResponse<JsonNode> response) {
        /*TODO:implement the GET-response.*/
        String usersUrl = getUsersURL(response, "_links");
        System.out.println(usersUrl);
        Unirest.get(usersUrl).asJsonAsync(new GetUsersCallback(delegate));
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

    //AUXILIARY METHOD

    /**
     * returns the link to the users -> in response to a request, it gets the body of the response,
     * gets the object "_links" from the body and returns the link given the key
     */
    public String getUsersURL(HttpResponse<JsonNode> response, String key) {
        return response.getBody().getObject().getJSONObject("_links").getJSONObject(key).getString("href");
    }
}
