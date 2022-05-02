package com.hw1.covidmetrics.model;

public class Country {
    
    private String name;
    private String isoCode;


    public Country(String name, String isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    public String getName() {
        return this.name;
    }

    public String getIsoCode() {
        return this.isoCode;
    }
    
}
