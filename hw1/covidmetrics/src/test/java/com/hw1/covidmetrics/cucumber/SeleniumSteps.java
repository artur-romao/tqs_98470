package com.hw1.covidmetrics.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumSteps {
  private WebDriver driver;
    
  @When("I access {string}")
  public void accessCovidMetrics(String url) {
    driver = new ChromeDriver();
    driver.get(url);
    driver.manage().window().setSize(new Dimension(1920, 1080));
    assertEquals("Covid-19 World statistics since the beginning of the pandemic", driver.findElement(By.cssSelector("h1")).getText());
  }

  @And("I click on {string} and check world statistics") 
  public void accessWorldwideMetrics(String world) {
    driver.findElement(By.linkText(world)).click();
    assertEquals("Select a date and check world's Covid-19 statistics:", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("World", driver.findElement(By.cssSelector("h4")).getText());
  }

  @And("I click on {string} and observe a page to Select a country") 
  public void accessCountrywideMetrics(String country) {
    driver.findElement(By.linkText(country)).click();
    assertEquals("Country\nISO ALPHA-3", driver.findElement(By.cssSelector("h4")).getText());
  }

  @Then("I choose {string} to check it's statistics")
  public void chooseCountry(String country) {
    driver.findElement(By.linkText("Country Statistics")).click();
    {
      WebElement dropdown = driver.findElement(By.cssSelector("select"));
      dropdown.findElement(By.xpath("//option[. = '" + country + "']")).click();
    }
    assertEquals("Portugal\nPRT", driver.findElement(By.cssSelector("h4")).getText());

    driver.quit();
  }
}
