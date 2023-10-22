package de.tum.in.ase.pse;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tum.in.ase.pse.model.Car;
import de.tum.in.ase.pse.server.CarController;
import de.tum.in.ase.pse.server.ModelStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = CarController.class)
class CarControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@BeforeEach
	void setUp() {
		ModelStorage.createSampleModel();
	}

	// 1. TODO: Write a test that checks if all cars are returned correctly.
	@Test
	void testGetAllCars() throws Exception {
		List<Car> cars = ModelStorage.getAllCars();
		ResultActions request = mockMvc.perform(get("/cars")).andDo(print()).andExpect(status().isOk());

		String jsonString = request.andReturn().getResponse().getContentAsString();
		List<Car> myObjects = objectMapper.readValue(jsonString, new TypeReference<List<Car>>() {
		});

		assertEquals("The cars are not equal", cars, myObjects);
	}

	// 2. TODO: Write a test that checks if the system responds correctly when given an existing ID.
	@Test
	void testGetCarByIdExisting() throws Exception {
		ModelStorage.createSampleModel();
		List<Car> cars = ModelStorage.getAllCars();
		Car car = cars.get(0);
		String id = car.getId();
		ResultActions request = mockMvc.perform(get("/cars/" + id)).andDo(print()).andExpect(status().isOk());

		String jsonString = request.andReturn().getResponse().getContentAsString();
		Car myObject = objectMapper.readValue(jsonString, Car.class);

		assertEquals("The cars are not equal", car, myObject);
		assertEquals("The cars are not equal", car.getId(), myObject.getId());
		assertEquals("The cars are not equal", car.getColor(), myObject.getColor());
		assertEquals("The cars are not equal", car.getBrand(), myObject.getBrand());


	}

	// 3. TODO: Write a test that checks if the system responds correctly when given a non-existent ID.
	@Test
	void testGetCarByIdNotExisting() throws Exception {
		mockMvc.perform(get("/cars/1")).andDo(print()).andExpect(status().isNotFound());
	}

	// 4. TODO: Write a test to check if the system created cars correctly.
	@Test
	void testCreateCar() throws Exception {
		Car car = new Car(null, "BMW", "red", 100);
		ResultActions request = mockMvc.perform(MockMvcRequestBuilders.post("/cars")
				.content(asJsonString(car))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		int status = request.andReturn().getResponse().getStatus();
		assertEquals("The status is not equal", 200, status);
		List<Car> cars = ModelStorage.getAllCars();
		assertEquals("The cars are not equal", 3, cars.size());
	}

	// 5. TODO: Write a test to check if the systems updates the car  correctly.
	@Test
	void testUpdateCar() throws Exception {
		Car car = ModelStorage.getAllCars().get(0);
		Car tempCar = new Car(car.getId(), "golden", car.getBrand(), car.getRentalCostPerDay());
		ResultActions request = mockMvc.perform(MockMvcRequestBuilders.put("/cars")
				.content(asJsonString(tempCar))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.color").value("golden"));
		String jsonString = request.andReturn().getResponse().getContentAsString();
		Car responseCar = objectMapper.readValue(jsonString, Car.class);
		Car newCar = ModelStorage.getCarById(car.getId());
		assertEquals("The cars are not equal", responseCar, newCar);
	}

	// 6. TODO: Write a test to check if the system deletes cars from the system correctly.

	@Test
	void testDeleteCar() throws Exception {
		Car car = ModelStorage.getAllCars().get(0);
		mockMvc.perform(MockMvcRequestBuilders.delete("/cars/" + car.getId())
				.content(asJsonString(car))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

		List<Car> cars = ModelStorage.getAllCars();
		assertEquals("The cars are not equal", 1, cars.size());
	}


}
