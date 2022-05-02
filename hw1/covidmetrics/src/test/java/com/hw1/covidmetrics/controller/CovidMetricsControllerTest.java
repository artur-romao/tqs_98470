package com.hw1.covidmetrics.controller;


import com.hw1.covidmetrics.model.Metrics;
import com.hw1.covidmetrics.service.CovidMetricsService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@WebMvcTest(CovidMetricsController.class)
public class CovidMetricsControllerTest {
    @Autowired
	private MockMvc mvc;

	@MockBean
	private CovidMetricsService service;

    @Test
	void getWorldDataTest() throws Exception {
		Metrics worldMetrics = new Metrics(513697783, 154755, 6262191, 623, 467939862, 337659, 39495730, 65903, 803.4);

		when(service.getWorldData()).thenReturn(worldMetrics);
		
		mvc.perform(
				get("/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(view().name("index"))
				.andExpect(model().attribute("TotalCases", is(worldMetrics.getTotalCases())))
				.andExpect(model().attribute("TotalDeaths", is(worldMetrics.getTotalDeaths())))
				.andExpect(model().attribute("TotalRecovered", is(worldMetrics.getTotalRecovered()))
		);

		mvc.perform(
                get("/world").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("world"))
                .andExpect(model().attribute("TotalCases", is(worldMetrics.getTotalCases())))
                .andExpect(model().attribute("TotalDeaths", is(worldMetrics.getTotalDeaths())))
                .andExpect(model().attribute("TotalRecovered", is(worldMetrics.getTotalRecovered()))
		);

		verify(service, times(2)).getWorldData();

	}

	@Test
	void getCountryDataTest() throws Exception {
		Metrics countryMetrics = new Metrics("Portugal", "Europe", "prt", 10142397, 
        3853800, 0, 22280, 0, 3831520, 0, 0, 
        41336850, 3, 455, 0, 379969, 2197, 4075649);

		when(service.getCountryData("Portugal", "prt")).thenReturn(countryMetrics);

		mvc.perform(
                get("/country/Portugal/prt").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("country"))
                .andExpect(model().attribute("Country", is(countryMetrics.getCountry())))
                .andExpect(model().attribute("ThreeLetterSymbol", is(countryMetrics.getThreeLetterSymbol())))
                .andExpect(model().attribute("Continent", is(countryMetrics.getContinent())))
                .andExpect(model().attribute("Population", is(countryMetrics.getPopulation()))
		);


		verify(service, times(1)).getCountryData("Portugal", "prt");

	}
}
