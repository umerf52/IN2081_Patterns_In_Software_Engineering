package de.tum.in.ase.pse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class InboxResource {

    private final DroidFactory factory = new DroidFactory();

    @PostMapping("r2")
    public ResponseEntity<Droid> produceR2(@RequestBody Droids droid) {
        return new ResponseEntity<>(factory.produce(droid), HttpStatus.OK);
    }

    @PostMapping("3po")
    public ResponseEntity<Droid> produce3PO(@RequestBody Droids droid) {
        return new ResponseEntity<>(factory.produce(droid), HttpStatus.OK);
    }
}
