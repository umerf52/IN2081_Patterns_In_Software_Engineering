package de.tum.in.ase.pse.client;

import org.springframework.web.client.RestTemplate;

public class Client {
    private RestTemplate restTemplate;

//    private static final String MASTER_YODA_SERVICE_URL = "http://localhost:8080";
    private static final String OBI_WAN_KENOBI_SERVICE_URL = "http://localhost:8081";
    private static final String TRAIN_APPRENTICES_URL = "/train-apprentices";
    private static final String FIND_APPRENTICES_URL = "/find-apprentices";

    public Client() {
        this.restTemplate = new RestTemplate();
    }

    // TODO 2 Forward the call to the right service
    public String trainApprentices() {
        return restTemplate.getForObject(OBI_WAN_KENOBI_SERVICE_URL + TRAIN_APPRENTICES_URL, String.class);
    }

    public String findApprentices() {
        return restTemplate.getForObject(OBI_WAN_KENOBI_SERVICE_URL + FIND_APPRENTICES_URL, String.class);
    }
}
