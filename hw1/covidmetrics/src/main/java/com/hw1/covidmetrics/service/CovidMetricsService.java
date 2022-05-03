package com.hw1.covidmetrics.service;

import java.io.IOException;
import java.util.ArrayList;

import com.hw1.covidmetrics.model.Cache;
import com.hw1.covidmetrics.model.Country;
import com.hw1.covidmetrics.model.Metrics;

import org.springframework.stereotype.Service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CovidMetricsService {
    
    private HttpRequestService api = new HttpRequestService();

    private Cache cache = new Cache();

    private static final Logger log = LoggerFactory.getLogger(CovidMetricsService.class);

    public Metrics getWorldData() throws IOException, InterruptedException {
        
        if (cache.getEntry("world") != null) {
            log.info("[CACHE] Getting world metrics.");
            return (Metrics) cache.getEntry("world");
        }
        
        String response = api.doHttpGet("/npm-covid-data/world");
        JSONArray arrayJson = new JSONArray(response);
        JSONObject responseJson = (JSONObject) arrayJson.get(0);

        Long totalCases = Long.parseLong(responseJson.get("TotalCases").toString());
        Long newCases = Long.parseLong(responseJson.get("NewCases").toString());
        Long totalDeaths = Long.parseLong(responseJson.get("TotalDeaths").toString());
        Long newDeaths = Long.parseLong(responseJson.get("NewDeaths").toString());
        Long totalRecovered = Long.parseLong(responseJson.get("TotalRecovered").toString());
        Long newRecovered = Long.parseLong(responseJson.get("NewRecovered").toString()); 
        Long activeCases = Long.parseLong(responseJson.get("ActiveCases").toString());
        Double cases1MPop = Double.parseDouble(responseJson.get("TotCases_1M_Pop").toString());
        Double deaths1MPop = Double.parseDouble(responseJson.get("Deaths_1M_pop").toString());

        Metrics worldMetrics = new Metrics(totalCases, newCases, totalDeaths, newDeaths, totalRecovered, newRecovered, activeCases, cases1MPop, deaths1MPop);
        cache.addEntry("world", worldMetrics);

        log.info("[CACHE] Stored world metrics.");
        log.info("[APP] Returning world metrics.");

        return worldMetrics;
    }

    public ArrayList<Country> getListOfCountries() throws IOException, InterruptedException {
        if (cache.getEntry("countries") != null) {
            ArrayList<Country> list = (ArrayList<Country>) cache.getEntry("countries");
            log.info("[CACHE] Getting list of countries.");
            return list;
        }
        
        String response = api.doHttpGet("/npm-covid-data/countries-name-ordered");
        JSONArray arrayJson = new JSONArray(response);
        
        ArrayList<Country> countries = new ArrayList<>();

        for (int i = 0; i < arrayJson.length(); i++) {
            JSONObject responseJson = arrayJson.getJSONObject(i);
            String country = responseJson.get("Country").toString();
            String isoCode = responseJson.get("ThreeLetterSymbol").toString();
            countries.add(new Country(country, isoCode));
        }

        cache.addEntry("countries", countries);
        
        log.info("[CACHE] Stored list of countries.");
        log.info("[APP] Returning list of countries.");

        return countries;
    }

    public Metrics getCountryData(String country, String isoCode) throws IOException, InterruptedException {
        String key = country + "/" + isoCode;
        if (cache.getEntry(key) != null) {
            log.info("[CACHE] Getting " + country + " metrics.");
            return (Metrics) cache.getEntry(key);
        }

        country = country.replaceAll(" ", "%20"); // so URLs of countries with spaces don't give any troubles
        String response = api.doHttpGet("/npm-covid-data/country-report-iso-based/" + country + "/" + isoCode);
        JSONArray arrayJson = new JSONArray(response);
        JSONObject responseJson = arrayJson.getJSONObject(0);

        String name = responseJson.get("Country").toString();
        String continent = responseJson.get("Continent").toString();
        Long population = Long.parseLong(responseJson.get("Population").toString());
        Long totalCases = Long.parseLong(responseJson.get("TotalCases").toString());
        Long newCases = Long.parseLong(responseJson.get("NewCases").toString());
        Long totalDeaths = Long.parseLong(responseJson.get("TotalDeaths").toString());
        Long newDeaths = Long.parseLong(responseJson.get("NewDeaths").toString());
        Long totalRecovered = Long.parseLong(responseJson.get("TotalRecovered").toString());
        Long newRecovered = Long.parseLong(responseJson.get("NewRecovered").toString()); 
        Long activeCases = Long.parseLong(responseJson.get("ActiveCases").toString());
        Long totalTests = Long.parseLong(responseJson.get("TotalTests").toString());
        Long oneCaseEveryXPeople = Long.parseLong(responseJson.get("one_Caseevery_X_ppl").toString());
        Long oneDeathEveryXPeople = Long.parseLong(responseJson.get("one_Deathevery_X_ppl").toString());
        Long oneTestEveryXPeople = Long.parseLong(responseJson.get("one_Testevery_X_ppl").toString());
        Double cases1MPop = Double.parseDouble(responseJson.get("TotCases_1M_Pop").toString());
        Double deaths1MPop = Double.parseDouble(responseJson.get("Deaths_1M_pop").toString());
        Double tests1MPop = Double.parseDouble(responseJson.get("Tests_1M_Pop").toString());

        Metrics countryMetrics = new Metrics(name, continent, isoCode, population, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, newRecovered, activeCases, totalTests, oneCaseEveryXPeople, oneDeathEveryXPeople, oneTestEveryXPeople, cases1MPop, deaths1MPop, tests1MPop);
        cache.addEntry(key, countryMetrics);

        log.info("[CACHE] Stored " + country + " metrics.");
        log.info("[APP] Returning " + country + " metrics.");

        return countryMetrics;
    }
    

    // Not implemented for lack of time
    public Metrics getLast6MCountryData(String country, String isoCode) throws IOException, InterruptedException {
        String response = api.doHttpGet("/covid-ovid-data/");
        JSONArray arrayJson = new JSONArray(response);
        JSONObject responseJson = arrayJson.getJSONObject(0);

        String name = responseJson.get("Country").toString();
        String continent = responseJson.get("Continent").toString();
        Long population = Long.parseLong(responseJson.get("Population").toString());
        Long totalCases = Long.parseLong(responseJson.get("TotalCases").toString());
        Long newCases = Long.parseLong(responseJson.get("NewCases").toString());
        Long totalDeaths = Long.parseLong(responseJson.get("TotalDeaths").toString());
        Long newDeaths = Long.parseLong(responseJson.get("NewDeaths").toString());
        Long totalRecovered = Long.parseLong(responseJson.get("TotalRecovered").toString());
        Long newRecovered = Long.parseLong(responseJson.get("NewRecovered").toString()); 
        Long activeCases = Long.parseLong(responseJson.get("ActiveCases").toString());
        Long totalTests = Long.parseLong(responseJson.get("TotalTests").toString());
        Long oneCaseEveryXPeople = Long.parseLong(responseJson.get("oneCaseevery_X_ppl").toString());
        Long oneDeathEveryXPeople = Long.parseLong(responseJson.get("one_Deathevery_X_ppl").toString());
        Long oneTestEveryXPeople = Long.parseLong(responseJson.get("one_Testevery_X_ppl").toString());
        Long cases1MPop = Long.parseLong(responseJson.get("TotCases_1M_Pop").toString());
        Long deaths1MPop = Long.parseLong(responseJson.get("Deaths_1M_pop").toString());
        Long tests1MPop = Long.parseLong(responseJson.get("Tests_1M_Pop").toString());

        Metrics countryMetrics = new Metrics(name, continent, isoCode, population, totalCases, newCases, totalDeaths, newDeaths, totalRecovered, newRecovered, activeCases, totalTests, oneCaseEveryXPeople, oneDeathEveryXPeople, oneTestEveryXPeople, cases1MPop, deaths1MPop, tests1MPop);

        return countryMetrics;
    }
    
}
