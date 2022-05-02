package com.hw1.covidmetrics.model;

public class Metrics {
    
    private String name;

    private String continent;

    private String isoCode;

    private long population;

    private long totalCases;

    private long newCases;

    private long totalDeaths;

    private long newDeaths;

    private long totalRecovered;

    private long newRecovered;

    private long activeCases;

    private long totalTests;

    private long oneCaseEveryXPeople;

    private long oneDeathEveryXPeople;

    private long oneTestEveryXPeople;

    private double cases1MPop;

    private double deaths1MPop;

    private double tests1MPop;

    // Constructor for World Data
    public Metrics(long totalCases, long newCases, long totalDeaths, long newDeaths, long totalRecovered, long newRecovered, long activeCases, double cases1MPop, double deaths1MPop) {
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.newRecovered = newRecovered;
        this.activeCases = activeCases;
        this.cases1MPop = cases1MPop;
        this.deaths1MPop = deaths1MPop;
    }

    // Constructor for Country Data
    public Metrics(String name, String continent, String isoCode, long population, long totalCases, long newCases, long totalDeaths, 
    long newDeaths, long totalRecovered, long newRecovered, long activeCases, long totalTests, long oneCaseEveryXPeople, 
    long oneDeathEveryXPeople, long oneTestEveryXPeople, double cases1MPop, double deaths1MPop, double tests1MPop) {
        this.name = name;
        this.continent = continent;
        this.isoCode = isoCode;
        this.population = population;
        this.totalCases = totalCases;
        this.newCases = newCases;
        this.totalDeaths = totalDeaths;
        this.newDeaths = newDeaths;
        this.totalRecovered = totalRecovered;
        this.newRecovered = newRecovered;
        this.activeCases = activeCases;
        this.totalTests = totalTests;
        this.oneCaseEveryXPeople = oneCaseEveryXPeople;
        this.oneDeathEveryXPeople = oneDeathEveryXPeople;
        this.oneTestEveryXPeople = oneTestEveryXPeople;
        this.cases1MPop = cases1MPop;
        this.deaths1MPop = deaths1MPop;
        this.tests1MPop = tests1MPop;
    }

    public String getName() {
        return this.name;
    }

    public String getContinent() {
        return this.continent;
    }

    public String getIsoCode() {
        return this.isoCode;
    }

    public long getPopulation() {
        return this.population;
    }

    public long getTotalCases() {
        return this.totalCases;
    }

    public long getNewCases() {
        return this.newCases;
    }

    public long getTotalDeaths() {
        return this.totalDeaths;
    }

    public long getNewDeaths() {
        return this.newDeaths;
    }

    public long getTotalRecovered() {
        return this.totalRecovered;
    }

    public long getNewRecovered() {
        return this.newRecovered;
    }

    public long getActiveCases() {
        return this.activeCases;
    }

    public long getTotalTests() {
        return this.totalTests;
    }

    public long getOneCaseEveryXPeople() {
        return this.oneCaseEveryXPeople;
    }

    public long getOneDeathEveryXPeople() {
        return this.oneDeathEveryXPeople;
    }

    public long getOneTestEveryXPeople() {
        return this.oneTestEveryXPeople;
    }

    public double getCases1MPop() {
        return this.cases1MPop;
    }

    public double getDeaths1MPop() {
        return this.deaths1MPop;
    }

    public double getTests1MPop() {
        return this.tests1MPop;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", continent='" + getContinent() + "'" +
            ", isoCode='" + getIsoCode() + "'" +
            ", population='" + getPopulation() + "'" +
            ", totalCases='" + getTotalCases() + "'" +
            ", newCases='" + getNewCases() + "'" +
            ", totalDeaths='" + getTotalDeaths() + "'" +
            ", newDeaths='" + getNewDeaths() + "'" +
            ", totalRecovered='" + getTotalRecovered() + "'" +
            ", newRecovered='" + getNewRecovered() + "'" +
            ", activeCases='" + getActiveCases() + "'" +
            ", totalTests='" + getTotalTests() + "'" +
            ", oneCaseEveryXPeople='" + getOneCaseEveryXPeople() + "'" +
            ", oneDeathEveryXPeople='" + getOneDeathEveryXPeople() + "'" +
            ", oneTestEveryXPeople='" + getOneTestEveryXPeople() + "'" +
            ", cases1MPop='" + getCases1MPop() + "'" +
            ", deaths1MPop='" + getDeaths1MPop() + "'" +
            ", tests1MPop='" + getTests1MPop() + "'" +
            "}";
    }

}
