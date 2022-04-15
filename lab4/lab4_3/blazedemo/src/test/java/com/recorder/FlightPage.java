package com.recorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPage {
    @FindBy(className="table")
    private WebElement flightsTable;

    public void selectFlight(int flightNumber) {
        flightsTable.findElement(By.cssSelector("tr:nth-child(" + flightNumber + ") .btn")).click();
    }
}
