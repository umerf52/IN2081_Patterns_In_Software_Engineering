package de.tum.in.ase.pse.client;

import de.tum.in.ase.pse.model.Droid;
import de.tum.in.ase.pse.model.DroidType;
import de.tum.in.ase.pse.util.SerialisationUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public final class DroidFactoryClient {

    private static final String R_2 = "r2";
    private static final String THREE_PO = "3po";
    private static final String ASTROMECH = "astromech";
    private static final String RESOURCE_URL = "http://localhost:8080/droid/";
    private static final DroidFactoryClient SINGLETON_INSTANCE = new DroidFactoryClient();
    private final RestTemplate restTemplate;


    private DroidFactoryClient() {
        this.restTemplate = new RestTemplate();
    }

    public static DroidFactoryClient getInstance() {
        return SINGLETON_INSTANCE;
    }

    public Droid produceR2() {
        var request = createHttpEntity(DroidType.R2);
        return restTemplate.postForObject(RESOURCE_URL + R_2, request, Droid.class);
    }

    public Droid produce3PO() {
        var request = createHttpEntity(DroidType.THREE_PO);
        return restTemplate.postForObject(RESOURCE_URL + THREE_PO, request, Droid.class);
    }

    public Droid produceAstromech() {
        var request = createHttpEntity(DroidType.ASTROMECH);
        return restTemplate.postForObject(RESOURCE_URL + ASTROMECH, request, Droid.class);
    }

    private HttpEntity<String> createHttpEntity(DroidType type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(SerialisationUtil.serialiseEnum(type), headers);
    }


}
