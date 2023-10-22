package de.tum.in.ase.pse.server;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this class provides dummy values for local testing
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
                {
                  "greeting": "Welcome to the RESTful rental system! Follow the hypermedia links to explore our available cars.",
                  "_links": {
                    "users": {
                      "href": "http://localhost:8080/users"
                    },
                    "cars": {
                      "href": "http://localhost:8080/cars"
                    }
                  }
                }""";
    }

}
