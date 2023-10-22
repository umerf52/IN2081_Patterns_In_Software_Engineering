package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.model.Car;
import de.tum.in.ase.pse.model.Rental;
import de.tum.in.ase.pse.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ModelStorage {
    private static Map<String, User> users;
    private static Map<String, Car> cars;
    private static List<Rental> rentals;

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

    public static List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public static User getUserById(String id) {
        return users.get(id);
    }

    public static List<Rental> getAllRentals() {
        return rentals;
    }

    public static String createRandomId() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
    }

    // Do not change this method.
    public static void createSampleModel() {
        users = new HashMap<>();
        cars = new HashMap<>();
        rentals = new ArrayList<>();
        final int rentalCostPerDayAudi = 100;
        final int rentalCostPerDayBmw = 105;
        final int dayDeltaSeven = 7;
        final int dayDeltaFourteen = 14;

        Car car1 = new Car(createRandomId(), "silver", "Audi", rentalCostPerDayAudi);
        Car car2 = new Car(createRandomId(), "white", "BMW", rentalCostPerDayBmw);

        User user1 = new User(createRandomId(), "Stephan Krusche");
        User user2 = new User(createRandomId(), "Jan Philip Bernius");

        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);

        Rental rental1 = new Rental(createRandomId(), user1, car1, LocalDateTime.now(), LocalDateTime.now().plusDays(dayDeltaSeven));
        Rental rental2 = new Rental(createRandomId(), user1, car1, LocalDateTime.now().minusDays(dayDeltaFourteen), LocalDateTime.now().minusDays(dayDeltaSeven));
        Rental rental3 = new Rental(createRandomId(), user2, car2, LocalDateTime.now().minusDays(dayDeltaFourteen), LocalDateTime.now().minusDays(dayDeltaSeven));

        rentals.add(rental1);
        rentals.add(rental2);
        rentals.add(rental3);

        cars.put(car1.getId(), car1);
        cars.put(car2.getId(), car2);
    }
}
