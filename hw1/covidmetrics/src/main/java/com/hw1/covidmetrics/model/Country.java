package com.hw1.covidmetrics.model;

public class Country {
    
    private String Country;
    private String ThreeLetterSymbol;


    public Country(String name, String ThreeLetterSymbol) {
        this.Country = name;
        this.ThreeLetterSymbol = ThreeLetterSymbol;
    }

    public String getCountry() {
        return this.Country;
    }

    public String getThreeLetterSymbol() {
        return this.ThreeLetterSymbol;
    }
    

    @Override
    public String toString() {
        return "{" +
            " Country='" + getCountry() + "'" +
            ", ThreeLetterSymbol='" + getThreeLetterSymbol() + "'" +
            "}";
    }

}
