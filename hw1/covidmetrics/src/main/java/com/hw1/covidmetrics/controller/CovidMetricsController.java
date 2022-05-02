package com.hw1.covidmetrics.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.hw1.covidmetrics.model.Country;
import com.hw1.covidmetrics.model.Metrics;
import com.hw1.covidmetrics.service.CovidMetricsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CovidMetricsController {
    
    @Autowired
    public CovidMetricsService service;

    @GetMapping("/")
    public ModelAndView index(Model model) throws IOException, InterruptedException {
        Metrics worldData = service.getWorldData();
        
        model.addAttribute("worldData", worldData);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("TotalCases", worldData.getTotalCases());
        modelAndView.addObject("TotalDeaths", worldData.getTotalDeaths());
        modelAndView.addObject("TotalRecovered", worldData.getTotalRecovered());

        return modelAndView;
    }

    @GetMapping("/world")
    public ModelAndView worldStatistics(Model model) throws IOException, InterruptedException {
        Metrics worldData = service.getWorldData();

        model.addAttribute("worldData", worldData);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("world");

        modelAndView.addObject("TotalCases", worldData.getTotalCases());
        modelAndView.addObject("TotalDeaths", worldData.getTotalDeaths());
        modelAndView.addObject("TotalRecovered", worldData.getTotalRecovered());

        return modelAndView;
    }

    @GetMapping("/country")
    public ModelAndView findAllCountries(Model model) throws IOException, InterruptedException {
        ArrayList<Country> countriesList = service.getListOfCountries();
        model.addAttribute("countriesList", countriesList);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("select_country");
        return modelAndView;
    }

    @GetMapping("/country/{country}/{isoCode}")
    public ModelAndView countryStatistics(@PathVariable(value="country") String country, @PathVariable(value="isoCode") String isoCode, Model model) throws IOException, InterruptedException {
        Metrics countryData = service.getCountryData(country, isoCode);

        model.addAttribute("countryData", countryData);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("country");

        modelAndView.addObject("Country", countryData.getCountry());
        modelAndView.addObject("ThreeLetterSymbol", countryData.getThreeLetterSymbol());
        modelAndView.addObject("Continent", countryData.getContinent());
        modelAndView.addObject("Population", countryData.getPopulation());
        
        return modelAndView;
    }
}
