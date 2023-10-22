package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Note;
import de.tum.in.ase.pse.model.Person;
import de.tum.in.ase.pse.util.PersonSortingOptions;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PersonController {

	private final WebClient webClient;
	private final List<Person> persons;

	public PersonController() {
		webClient = WebClient.create("http://localhost:8080");
		persons = new ArrayList<>();
	}

	public void addPerson(Person person, Consumer<List<Person>> personsConsumer) {
		// TODO Part 2: Make an http post request to the server
		webClient.post()
				.uri("persons")
				.bodyValue(person)
				.retrieve()
				.bodyToMono(Person.class)
				.onErrorStop()
				.subscribe(newPerson -> {
					persons.add(newPerson);
					personsConsumer.accept(persons);
				});
	}

	public void updatePerson(Person person, Consumer<List<Person>> personsConsumer) {
		// TODO Part 2: Make an http put request to the server
		webClient.put()
				.uri("persons/" + person.getId())
				.bodyValue(person)
				.retrieve()
				.bodyToMono(Person.class)
				.onErrorStop()
				.subscribe(newPerson -> {
					persons.replaceAll(oldPerson -> oldPerson.getId().equals(newPerson.getId()) ? newPerson : oldPerson);
					personsConsumer.accept(persons);
				});
	}

	public void deletePerson(Person person, Consumer<List<Person>> personsConsumer) {
		// TODO Part 2: Make an http delete request to the server
		webClient.delete()
				.uri("persons/" + person.getId())
				.retrieve()
				.toBodilessEntity()
				.onErrorStop()
				.subscribe(v -> {
					persons.remove(person);
					personsConsumer.accept(persons);
				});
	}

	public void getAllPersons(PersonSortingOptions sortingOptions, Consumer<List<Person>> personsConsumer) {
		// TODO Part 2: Make an https get request to the server
		webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("persons")
						.queryParam("sortField", "ID")
						.queryParam("sortingOrder", "ASCENDING")
						.build())
				.retrieve()
				.bodyToFlux(Person.class)
				.collectList()
				.subscribe(personsConsumer);
	}
}
