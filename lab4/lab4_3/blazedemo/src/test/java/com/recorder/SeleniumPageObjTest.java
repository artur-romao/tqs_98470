package com.recorder;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
class SeleniumPageObjTest {

    private WebDriver driver;
    @BeforeEach
    public void setUp() {
      driver = new ChromeDriver();
    }
    @AfterEach
    public void tearDown() {
      driver.quit();
    }

    @Test
    void test() {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        assertEquals("BlazeDemo", driver.getTitle());

        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.chooseLocations("Philadelphia", "Cairo");

        FlightPage flightPage = PageFactory.initElements(driver, FlightPage.class);
        flightPage.selectFlight(5);

        PurchasePage purchasePage = PageFactory.initElements(driver, PurchasePage.class);
        assertEquals("Airline: United", purchasePage.getAirline());
        assertEquals("Flight Number: UA954", purchasePage.getFlightNumber());
        assertEquals("Price: 400", purchasePage.getPrice());
        assertEquals("Arbitrary Fees and Taxes: 514.76", purchasePage.getFeesAndTaxes());
        purchasePage.fillForm("Rikipalooza", "123 Main St.", "Anytown", "State", "12345", "Visa", 123456789, 11, 2022, "Riki Palooza", true);

        ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
        ArrayList<String> info = confirmationPage.getReservationInfo();

        assertEquals("PendingCapture", info.get(0));
        assertEquals("555 USD", info.get(1));
        assertEquals("xxxxxxxxxxxx1111", info.get(2));
        assertEquals("11 /2018", info.get(3));
        assertEquals("888888", info.get(4));
        assertEquals("Thank you for your purchase today!", confirmationPage.getTitle());
    }

}
