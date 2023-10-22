package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.model.Car;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this class provides dummy values for local testing
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class CarController {

    private static final Car BMW = new Car("1", "black", "BMW", 100);
    private static final Car MERCEDES = new Car("2", "red", "Mercedes", 125);
    private static final Car AUDI = new Car("3", "white", "Audi", 90);
    private static final Car TOYOTA = new Car("4", "yellow", "Toyota", 50);
    private static final List<Car> CARS = List.of(BMW, MERCEDES, AUDI, TOYOTA);

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return CARS;
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable String id) {
        return BMW;
    }

    @GetMapping("/users/{userId}/rentals")
    public String getRentalsByUser(@PathVariable String userId) {
        return """
                [
                  {
                    "id": "212102572",
                    "startDate": "2022-11-26T23:26:48.340129",
                    "endDate": "2022-12-03T23:26:48.340984",
                    "user": {
                      "id": "%s",
                      "name": "Stephan Krusche"
                    },
                    "car": {
                      "id": "397002627",
                      "color": "silver",
                      "brand": "Audi",
                      "rentalCostPerDay": 100
                    }
                  }
                ]""".formatted(userId);
    }


    @PostMapping("/cars")
    public Car createCar(@RequestBody Car newCar) {
        newCar.setId("5");
        return newCar;
    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car updatedCar) {
        return updatedCar;
    }

    @DeleteMapping("/cars/{id}")
    public Car deleteCar(@PathVariable String id) {
        return new Car(id, "black", "Opel", 60);
    }

}
