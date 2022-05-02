package com.hw1.covidmetrics.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import com.hw1.covidmetrics.model.Cache;
import com.hw1.covidmetrics.model.Country;
import com.hw1.covidmetrics.model.Metrics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CovidMetricsServiceTest {
    
    @Mock
    private HttpRequestService requestHandler;

    @Mock
    private Cache cache;

    @InjectMocks
    private CovidMetricsService service;

    @Test
    void getWorldDataTest() throws IOException, InterruptedException {
        Metrics worldMetrics = new Metrics(513697783, 154755, 6262191, 623, 467939862, 337659, 39495730, 65903, 803.4);

        Mockito.when(requestHandler.doHttpGet(Mockito.anyString())).thenReturn("[" + worldMetrics.toString() + "]");

        Metrics accurateMetrics = service.getWorldData();

        assertEquals(worldMetrics.toString(), accurateMetrics.toString());
    }

    @Test
    void getListOfCountriesTest() throws IOException, InterruptedException {
        Country afghanistan = new Country("Afghanistan", "afg");
        Country angola = new Country("Angola", "ago");

        Mockito.when(requestHandler.doHttpGet(Mockito.anyString())).thenReturn("[" + afghanistan.toString() + ", " + angola.toString() + "]");

        ArrayList<Country> countries = service.getListOfCountries();
        assertEquals(afghanistan.toString(), countries.get(0).toString());
        assertEquals(angola.toString(), countries.get(1).toString());
    }

    @Test
    void getCountryDataTest() throws IOException, InterruptedException {
        Metrics countryMetrics = new Metrics("Portugal", "Europe", "prt", 10142397, 
        3853800, 0, 22280, 0, 3831520, 0, 0, 
        41336850, 3, 455, 0, 379969, 2197, 4075649);

        Mockito.when(requestHandler.doHttpGet(Mockito.anyString())).thenReturn("[" + countryMetrics.toString() + "]");

        Metrics accurateMetrics = service.getCountryData("Portugal", "prt");

        assertEquals(countryMetrics.toString(), accurateMetrics.toString());
    }

}
