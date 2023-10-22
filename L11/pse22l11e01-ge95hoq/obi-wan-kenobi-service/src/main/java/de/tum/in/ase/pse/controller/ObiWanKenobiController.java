package de.tum.in.ase.pse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObiWanKenobiController {

    // TODO 1.2 Implement an enpoint responsible for training new apprentices.
    //  It should operate under the same path as in MasterYodaController

    @GetMapping("/train-apprentices")
    public String trainApprentices() {
        return "Apprentices are being trained...";
    }

    @GetMapping("/find-apprentices")
    public String findNewApprentices() {
        return "Looking for new apprentices...";
    }
}
