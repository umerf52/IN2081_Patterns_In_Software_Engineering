package de.tum.in.ase.pse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;



@RestController
@RequestMapping(value = "/droid/", consumes = "application/json")
public class DroidFactoryResource {

    private final DroidFactory factory = new DroidFactory();

//    @PostMapping("r2")
//    public ResponseEntity<Droid> produceR2(@RequestBody Droids droid) {
//        return new ResponseEntity<>(factory.produce(droid), HttpStatus.OK);
//    }
//
//    @PostMapping("3po")
//    public ResponseEntity<Droid> produce3PO(@RequestBody Droids droid) {
//        return new ResponseEntity<>(factory.produce(droid), HttpStatus.OK);
//    }
    // TODO 2.1: implement both methods using the async features of the CompletableFuture class and remove the old methods


    @PostMapping("r2")
    public CompletableFuture<String> produceR2Async(@RequestBody Droids droid) {
        return CompletableFuture.supplyAsync(() -> {
            return factory.produce(droid).toString();
        });

    }

    @PostMapping("3po")
    public CompletableFuture<String> produce3POAsync(@RequestBody Droids droid) {
        return CompletableFuture.supplyAsync(() -> {
            return factory.produce(droid).toString();
        });
    }

}
