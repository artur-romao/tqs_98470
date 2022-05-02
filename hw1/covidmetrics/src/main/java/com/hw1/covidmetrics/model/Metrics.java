package com.hw1.covidmetrics.model;

public class Metrics {
    
    private String Country;

    private String Continent;

    private String ThreeLetterSymbol;

    private long Population;

    private long TotalCases;

    private long NewCases;

    private long TotalDeaths;

    private long NewDeaths;

    private long TotalRecovered;

    private long NewRecovered;

    private long ActiveCases;

    private long TotalTests;

    private long one_Caseevery_X_ppl;

    private long one_Deathevery_X_ppl;

    private long one_Testevery_X_ppl;

    private double TotCases_1M_Pop;

    private double Deaths_1M_pop;

    private double Tests_1M_Pop;

    // Constructor for World Data
    public Metrics(long TotalCases, long NewCases, long TotalDeaths, long NewDeaths, long TotalRecovered, long NewRecovered, long ActiveCases, double TotCases_1M_Pop, double Deaths_1M_pop) {
        this.TotalCases = TotalCases;
        this.NewCases = NewCases;
        this.TotalDeaths = TotalDeaths;
        this.NewDeaths = NewDeaths;
        this.TotalRecovered = TotalRecovered;
        this.NewRecovered = NewRecovered;
        this.ActiveCases = ActiveCases;
        this.TotCases_1M_Pop = TotCases_1M_Pop;
        this.Deaths_1M_pop = Deaths_1M_pop;
    }

    // Constructor for Country Data
    public Metrics(String Country, String Continent, String ThreeLetterSymbol, long Population, long TotalCases, long NewCases, long TotalDeaths, 
    long NewDeaths, long TotalRecovered, long NewRecovered, long ActiveCases, long TotalTests, long one_Caseevery_X_ppl, 
    long one_Deathevery_X_ppl, long one_Testevery_X_ppl, double TotCases_1M_Pop, double Deaths_1M_pop, double Tests_1M_Pop) {
        this.Country = Country;
        this.Continent = Continent;
        this.ThreeLetterSymbol = ThreeLetterSymbol;
        this.Population = Population;
        this.TotalCases = TotalCases;
        this.NewCases = NewCases;
        this.TotalDeaths = TotalDeaths;
        this.NewDeaths = NewDeaths;
        this.TotalRecovered = TotalRecovered;
        this.NewRecovered = NewRecovered;
        this.ActiveCases = ActiveCases;
        this.TotalTests = TotalTests;
        this.one_Caseevery_X_ppl = one_Caseevery_X_ppl;
        this.one_Deathevery_X_ppl = one_Deathevery_X_ppl;
        this.one_Testevery_X_ppl = one_Testevery_X_ppl;
        this.TotCases_1M_Pop = TotCases_1M_Pop;
        this.Deaths_1M_pop = Deaths_1M_pop;
        this.Tests_1M_Pop = Tests_1M_Pop;
    }

    public String getCountry() {
        return this.Country;
    }

    public String getContinent() {
        return this.Continent;
    }

    public String getThreeLetterSymbol() {
        return this.ThreeLetterSymbol;
    }

    public long getPopulation() {
        return this.Population;
    }

    public long getTotalCases() {
        return this.TotalCases;
    }

    public long getNewCases() {
        return this.NewCases;
    }

    public long getTotalDeaths() {
        return this.TotalDeaths;
    }

    public long getNewDeaths() {
        return this.NewDeaths;
    }

    public long getTotalRecovered() {
        return this.TotalRecovered;
    }

    public long getNewRecovered() {
        return this.NewRecovered;
    }

    public long getActiveCases() {
        return this.ActiveCases;
    }

    public long getTotalTests() {
        return this.TotalTests;
    }

    public long getOne_Caseevery_X_ppl() {
        return this.one_Caseevery_X_ppl;
    }

    public long getOne_Deathevery_X_ppl() {
        return this.one_Deathevery_X_ppl;
    }

    public long getOne_Testevery_X_ppl() {
        return this.one_Testevery_X_ppl;
    }

    public double getTotCases_1M_Pop() {
        return this.TotCases_1M_Pop;
    }

    public double getDeaths_1M_pop() {
        return this.Deaths_1M_pop;
    }

    public double getTests_1M_Pop() {
        return this.Tests_1M_Pop;
    }


    @Override
    public String toString() {
        return "{" +
            " Country='" + getCountry() + "'" +
            ", Continent='" + getContinent() + "'" +
            ", ThreeLetterSymbol='" + getThreeLetterSymbol() + "'" +
            ", Population='" + getPopulation() + "'" +
            ", TotalCases='" + getTotalCases() + "'" +
            ", NewCases='" + getNewCases() + "'" +
            ", TotalDeaths='" + getTotalDeaths() + "'" +
            ", NewDeaths='" + getNewDeaths() + "'" +
            ", TotalRecovered='" + getTotalRecovered() + "'" +
            ", NewRecovered='" + getNewRecovered() + "'" +
            ", ActiveCases='" + getActiveCases() + "'" +
            ", TotalTests='" + getTotalTests() + "'" +
            ", one_Caseevery_X_ppl='" + getOne_Caseevery_X_ppl() + "'" +
            ", one_Deathevery_X_ppl='" + getOne_Deathevery_X_ppl() + "'" +
            ", one_Testevery_X_ppl='" + getOne_Testevery_X_ppl() + "'" +
            ", TotCases_1M_Pop='" + getTotCases_1M_Pop() + "'" +
            ", Deaths_1M_pop='" + getDeaths_1M_pop() + "'" +
            ", Tests_1M_Pop='" + getTests_1M_Pop() + "'" +
            "}";
    }

}
