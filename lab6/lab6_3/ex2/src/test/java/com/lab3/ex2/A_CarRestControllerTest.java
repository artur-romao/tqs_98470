package com.lab3.ex2;

import com.lab3.ex2.controller.CarController;
import com.lab3.ex2.data.Car;
import com.lab3.ex2.service.CarManagerService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class A_RestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CarManagerService service;

	@Test
    void whenPostCar_thenCreateCar( ) throws Exception {
        Car car = new Car("Volkswagen", "Beetle");

        when(service.save(Mockito.any())).thenReturn(car);

        mvc.perform(
                post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(car)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.model", is("Beetle")));

        verify(service, times(1)).save(Mockito.any());
    }


	@Test
    void givenManyCars_whenGetCars_thenReturnJsonArray() throws Exception {
        Car car1 = new Car("Volkswagen", "Golf");
        Car car2 = new Car("Citroen", "Cactus");
        Car car3 = new Car("Nissan", "GTR");

        List<Car> allCars = Arrays.asList(car1, car2, car3);

        when(service.getAllCars()).thenReturn(allCars);

        mvc.perform(
                get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].model", is(car1.getModel())))
                .andExpect(jsonPath("$[1].model", is(car2.getModel())))
                .andExpect(jsonPath("$[2].model", is(car3.getModel())));

        verify(service, times(1)).getAllCars();
    }

	@Test
	void givenOneCar_ifCarExists_thenReturnCarDetails() throws Exception {
		Car car = new Car("Volkswagen", "Beetle");

		when(service.getCarDetails(Mockito.any())).thenReturn(Optional.of(car));

		mvc.perform(
			get("/api/cars/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.model", is(car.getModel())))
			.andExpect(jsonPath("$.maker", is(car.getMaker())));

		verify(service, times(1)).getCarDetails(anyLong());
	}

	@Test
	void givenOneCar_ifCarDoesntExist_thenReturnNotFound() throws Exception {
		when(service.getCarDetails(Mockito.any())).thenReturn(Optional.empty());
		mvc.perform(
			get("/api/cars/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
		
		verify(service, times(1)).getCarDetails(anyLong());
	}
}
