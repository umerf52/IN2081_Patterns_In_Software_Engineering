package de.tum.in.ase.pse.server;

import de.tum.in.ase.pse.model.Rental;
import de.tum.in.ase.pse.model.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    // TODO: Add the correct annotation for this method and its parameter, so that this method handles GET requests to "/users/{userId}/rentals".
    @GetMapping("/users/{userId}/rentals")
    public List<Rental> getAllActiveRentalsByUser(@PathVariable String userId) {
        // TODO: Implement this method, that should return all active rentals of the user.
        List<Rental> allRentals = ModelStorage.getAllRentals();
        List<Rental> activeUserRentals = new LinkedList<>();
        for (Rental rental : allRentals) {
            if (rental.getUser().getId().equals(userId) && isActive(rental)) {
                activeUserRentals.add(rental);
            }
        }
        return activeUserRentals;
    }

    // TODO: Add the correct annotation so that this method handles GET-requests to "/users".
    @GetMapping("/users")
    public CollectionModel<EntityModel<User>> getAllUsers() {
        // TODO: Get all users first.
        List<User> result = ModelStorage.getAllUsers();

        List<EntityModel<User>> resultWithLinks = result.stream().map(user -> {
            EntityModel<User> entityModel = EntityModel.of(user);

            entityModel.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
            entityModel.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));

            // TODO: If the user has an active rental, add a link to the route "/users/{userId}/rentals" by referencing the right method.
            if (hasActiveRental(user)) {
                entityModel.add(linkTo(methodOn(UserController.class).getAllActiveRentalsByUser(user.getId())).withRel("rentals"));
            }

            return entityModel;
        }).toList();

        return CollectionModel.of(resultWithLinks, linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
    }

    // TODO: Add the correct annotations for this method and its parameter, so that this method handles GET-requests to "/users/{id}".
    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable String id) {
        // TODO: Get the right user.
        User user = ModelStorage.getUserById(id);

        if (user == null) {
            // TODO: Handle this case appropriately.
            throw new UserNotFoundException();
        }

        EntityModel<User> resultWithLinks = EntityModel.of(user);

        resultWithLinks.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());
        resultWithLinks.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));

        // TODO: If the user has an active rental, add a link to the route "/users/{userId}/rentals/" by referencing the right method.
        if (hasActiveRental(user)) {
            resultWithLinks.add(linkTo(methodOn(UserController.class).getAllActiveRentalsByUser(user.getId())).withRel("rentals"));
        }

        return resultWithLinks;
    }

    // TODO: Implement and use this auxiliary method for a better code structure
    private boolean hasActiveRental(User user) {
        List<Rental> allRentals = ModelStorage.getAllRentals();
        for (Rental rental : allRentals) {
            if (rental.getUser().getId().equals(user.getId()) && isActive(rental)) {
                return true;
            }
        }
        return false;
    }

    // TODO: Implement and use this auxiliary method for a better code structure
    private boolean isActive(Rental rental) {
        LocalDateTime now = LocalDateTime.now();
        return rental.getStartDate().isBefore(now) && rental.getEndDate().isAfter(now);
    }
}
