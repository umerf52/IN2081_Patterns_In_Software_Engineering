package de.tum.in.ase.pse;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.fail;

@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
class RentalSystemTest {

	private String basePackage = "de.tum.in.ase.pse.";

	@Test
	void testRentItem() {
		// TODO: Implement the test according to the problem statement.
		try {
			Class.forName(basePackage + "Book");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("Class Book not found");
		}

		// Check that Rentable is an interface
		try {
			Class<?> rentable = Class.forName(basePackage + "Rentable");
			if (!rentable.isInterface()) {
				fail("the interface Rentable was not implemented as expected");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("Interface Rentable not found");
		}

		// Check that Book implements Rentable
		try {
			Class<?> book = Class.forName(basePackage + "Book");
			Class<?> rentable = Class.forName(basePackage + "Rentable");
			if (!rentable.isAssignableFrom(book)) {
				fail("Book does not implement the Rentable interface");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("Class not found");
		}

		// Check that Book has a default constructor
		try {
			Class book = Class.forName(basePackage + "Book");
			book.newInstance();
			book.getDeclaredConstructor();
		} catch (ClassNotFoundException e) {
			fail("Book does not provide a default constructor");
		} catch (InstantiationException e) {
			fail("Book does not provide a default constructor");
		} catch (IllegalAccessException e) {
			fail("Book does not provide a default constructor");
		} catch (NoSuchMethodException e) {
			fail("Book does not provide a default constructor");
		}

		// Check that Book has a private attribute available
		try {
			Class book = Class.forName(basePackage + "Book");
			Field field = book.getDeclaredField("available");

			int modifier = field.getModifiers();
			if (!Modifier.isPrivate(modifier)) {
				fail("attribute available in class Book is not provided as described");
			}
		} catch (ClassNotFoundException e) {
			fail("attribute available in class Book is not provided as described");
		} catch (NoSuchFieldException e) {
			fail("attribute available in class Book is not provided as described");
		}

		try {
			Class className = Class.forName(basePackage + "Book");
			Object book = className.newInstance();
			Field field = className.getDeclaredField("available");
			field.setAccessible(true);
			Method method = className.getDeclaredMethod("rentItem");
			method.invoke(book);
			Boolean available = (Boolean) field.get(book);
			if (available) {
				fail("available was not updated correctly");
			}
		} catch (ClassNotFoundException e) {
			fail("available was not updated correctly");
		} catch (NoSuchMethodException e) {
			fail("available was not updated correctly");
		} catch (InvocationTargetException e) {
			fail("available was not updated correctly");
		} catch (IllegalAccessException e) {
			fail("available was not updated correctly");
		} catch (NoSuchFieldException e) {
			fail("available was not updated correctly");
		} catch (InstantiationException e) {
			fail("available was not updated correctly");
		}

	}
}
