package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
public final class ModelStorage {

    private static Map<String, Car> cars;

    private ModelStorage() {

    }

    public static List<Car> getAllCars() {
        return new ArrayList<>(cars.values());
    }

    public static Car getCarById(String id) {
        return cars.get(id);
    }

    public static void saveCar(Car car) {
        cars.put(car.getId(), car);
    }

    public static void deleteCar(Car car) {
        cars.remove(car.getId());
    }

    public static String createRandomId() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
    }

    // Do not change this method.
    public static void createSampleModel() {
        cars = new HashMap<>();
        final int rentalCostPerDayAudi = 100;
        final int rentalCostPerDayBmw = 105;

        Car car1 = new Car(createRandomId(), "silver", "Audi", rentalCostPerDayAudi);
        Car car2 = new Car(createRandomId(), "white", "BMW", rentalCostPerDayBmw);

        cars.put(car1.getId(), car1);
        cars.put(car2.getId(), car2);
    }
}
