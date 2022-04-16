package com.lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager; 

public class BlazedemoSteps {
    private WebDriver driver;

    @When("I access {string}")
    public void accessBlazedemo(String url) {
        driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @And("I choose {string} for departure")
    public void chooseDeparture(String from) {
        driver.findElement(By.name("fromPort")).click();
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = '" + from + "']")).click();
    }

    @And("I choose {string} for destination")
    public void chooseDestination(String to) {
        driver.findElement(By.name("toPort")).click();
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = '" + to + "']")).click();
    }

    @And("I click find flights")
    public void findFlights() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @And("the title should be Flights from {string} to {string}:")
    public void getTitle(String from, String to) {
        assertEquals("Flights from " + from + " to " + to + ":", driver.findElement(By.cssSelector("h3")).getText());
    }
    
    @And("I select flight")
    public void chooseFlight() {
        driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
    }
    
    @And("I check the reservation info")
    public void checkInfo() {
        assertEquals("Your flight from TLV to SFO has been reserved.", driver.findElement(By.cssSelector("h2")).getText());
        assertEquals("Airline: United", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(2)")).getText());
        assertEquals("Flight Number: UA954", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(3)")).getText());
        assertEquals("Price: 400", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(4)")).getText());
        assertEquals("Arbitrary Fees and Taxes: 514.76", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(5)")).getText());
    }
    
    @And("I fill the form")
    public void fillForm() {
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Rikipalooza");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("123 Main St.");
        driver.findElement(By.id("city")).sendKeys("Anytown");
        driver.findElement(By.id("state")).sendKeys("State");
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("123456789");
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2022");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("Riki Palooza");
        driver.findElement(By.id("rememberMe")).click();
        
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
    
    @Then("I check purchase info")
    public void ending() {
        assertEquals("Thank you for your purchase today!", driver.findElement(By.cssSelector("h1")).getText());
        
        // Asserts in confirmation page
        assertEquals("PendingCapture", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText());
        assertEquals("555 USD", driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText());
        assertEquals("xxxxxxxxxxxx1111", driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).getText());
        assertEquals("11 /2018", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2)")).getText());
        assertEquals("888888", driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(2)")).getText());
        
        assertEquals("BlazeDemo Confirmation", driver.getTitle());
        driver.quit();
    }
}
