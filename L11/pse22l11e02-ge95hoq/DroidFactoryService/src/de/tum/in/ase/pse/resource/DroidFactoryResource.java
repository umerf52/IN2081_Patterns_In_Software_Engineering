package de.tum.in.ase.pse.resource;


import de.tum.in.ase.pse.model.Droid;
import de.tum.in.ase.pse.factory.DroidFactory;
import de.tum.in.ase.pse.model.DroidType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
@RequestMapping(value = "/droid/", consumes = "application/json")
public class DroidFactoryResource {
	private final Function<DroidType, Droid> func = DroidFactory::produceDroid;


	@PostMapping("r2")
	public ResponseEntity<Droid> produceR2(@RequestBody DroidType droidType) {
		return new ResponseEntity<>(DroidFactory.produceDroid(droidType), HttpStatus.OK);
	}

	@PostMapping("3po")
	public ResponseEntity<Droid> produce3PO(@RequestBody DroidType droidType) {
		return new ResponseEntity<>(DroidFactory.produceDroid(droidType), HttpStatus.OK);
	}

	@PostMapping("astromech")
	public ResponseEntity<Droid> produceAstromech(@RequestBody DroidType droidType) {
		return new ResponseEntity<>(DroidFactory.produceDroid(droidType), HttpStatus.OK);
	}


}
