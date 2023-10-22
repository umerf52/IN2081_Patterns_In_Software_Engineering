package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.model.Car;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class CarController {
    // TODO: Return all stored cars.
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return ModelStorage.getAllCars();
    }

    // TODO: Return the correct car. Also handle the case appropriately, if the car is not found.
    @GetMapping("/cars/{id}")
        public Car getCarById(@PathVariable String id) {
        Car car = ModelStorage.getCarById(id);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }

    // TODO: Make sure the new car is saved.
    @PostMapping("/cars")
    public Car createCar(@RequestBody Car newCar) {
        newCar.setId(ModelStorage.createRandomId());
        ModelStorage.saveCar(newCar);
        return newCar;
    }

    // TODO: Make sure the car is updated correctly.
    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car updatedCar) {
        ModelStorage.saveCar(updatedCar);
        return updatedCar;
    }

    // TODO: Make sure the car is deleted.
    @DeleteMapping("/cars/{id}")
    public Car deleteCar(@PathVariable String id) {
        Car car = ModelStorage.getCarById(id);
        if (car == null) {
            throw new CarNotFoundException();
        }
        ModelStorage.deleteCar(car);
        return car;
    }
}
