package de.tum.in.ase.pse.service;

import de.tum.in.ase.pse.model.Person;
import de.tum.in.ase.pse.util.PersonSortingOptions;
import org.springframework.stereotype.Service;

import java.util.*;

import static de.tum.in.ase.pse.util.PersonSortingOptions.SortField.*;

@Service
public class PersonService {
	// do not change this
	private final List<Person> persons;

	public PersonService() {
		this.persons = new ArrayList<>();
	}

	public Person savePerson(Person person) {
		var optionalPerson = persons.stream().filter(existingPerson -> existingPerson.getId().equals(person.getId())).findFirst();
		if (optionalPerson.isEmpty()) {
			person.setId(UUID.randomUUID());
			persons.add(person);
			return person;
		} else {
			var existingPerson = optionalPerson.get();
			existingPerson.setFirstName(person.getFirstName());
			existingPerson.setLastName(person.getLastName());
			existingPerson.setBirthday(person.getBirthday());
			return existingPerson;
		}
	}

	public void deletePerson(UUID personId) {
		this.persons.removeIf(person -> person.getId().equals(personId));
	}

	public List<Person> getAllPersons(PersonSortingOptions sortingOptions) {
		// TODO Part 3: Add sorting here
		List<Person> tempPersons = new ArrayList<>(this.persons);
		if (sortingOptions.getSortingOrder() == PersonSortingOptions.SortingOrder.DESCENDING) {
			switch (sortingOptions.getSortField()) {
				case FIRST_NAME -> tempPersons.sort(Comparator.comparing(Person::getFirstName).reversed());
				case LAST_NAME -> tempPersons.sort(Comparator.comparing(Person::getLastName).reversed());
				case BIRTHDAY -> tempPersons.sort(Comparator.comparing(Person::getBirthday).reversed());
				default -> tempPersons.sort(Comparator.comparing(Person::getId).reversed());
			}
		} else {
			switch (sortingOptions.getSortField()) {
				case FIRST_NAME -> tempPersons.sort(Comparator.comparing(Person::getFirstName));
				case LAST_NAME -> tempPersons.sort(Comparator.comparing(Person::getLastName));
				case BIRTHDAY -> tempPersons.sort(Comparator.comparing(Person::getBirthday));
				default -> tempPersons.sort(Comparator.comparing(Person::getId));
			}
		}
		return tempPersons;
	}
}
