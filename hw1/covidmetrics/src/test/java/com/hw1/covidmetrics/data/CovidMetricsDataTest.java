package com.hw1.covidmetrics.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hw1.covidmetrics.model.Metrics;

import org.junit.jupiter.api.Test;

public class CovidMetricsDataTest {
    
    @Test
    void covidDataMetricsTest() {
        
        // country metrics constructor
        Metrics countryMetrics = new Metrics("Angola", "Africa", "ago", 34732793, 99194, 
        0, 1900, 0, 97149, 0, 145, 1499795, 
        350, 18280, 23, 2856, 55, 43181);

        assertEquals("Angola", countryMetrics.getCountry());
        assertEquals("Africa", countryMetrics.getContinent());
        assertEquals("ago", countryMetrics.getThreeLetterSymbol());
        assertEquals(34732793, countryMetrics.getPopulation());
        assertEquals(99194, countryMetrics.getTotalCases());
        assertEquals(0, countryMetrics.getNewCases());
        assertEquals(1900, countryMetrics.getTotalDeaths());
        assertEquals(0, countryMetrics.getNewDeaths());
        assertEquals(97149, countryMetrics.getTotalRecovered());
        assertEquals(0, countryMetrics.getNewRecovered());
        assertEquals(145, countryMetrics.getActiveCases());
        assertEquals(1499795, countryMetrics.getTotalTests());
        assertEquals(350, countryMetrics.getOne_Caseevery_X_ppl());
        assertEquals(18280, countryMetrics.getOne_Deathevery_X_ppl());
        assertEquals(23, countryMetrics.getOne_Testevery_X_ppl());
        assertEquals(2856, countryMetrics.getTotCases_1M_Pop());
        assertEquals(55, countryMetrics.getDeaths_1M_pop());
        assertEquals(43181, countryMetrics.getTests_1M_Pop());

        // deaths + recovered <= total cases
        long totalCases = countryMetrics.getTotalCases();
        long deaths = countryMetrics.getTotalDeaths();
        long recovered = countryMetrics.getTotalRecovered();

        assertTrue((deaths + recovered) <= totalCases);

        // deaths + recovered + active cases = total cases
        long activeCases = countryMetrics.getActiveCases();
        
        assertEquals(totalCases, deaths + recovered + activeCases);

    }
}
