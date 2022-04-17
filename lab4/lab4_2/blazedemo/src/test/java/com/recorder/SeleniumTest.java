package com.recorder;

// Generated by Selenium IDE
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class SeleniumTest {
  private WebDriver driver;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void seleniumTest() {
    // Test name: SeleniumTest
    // Step # | name | target | value
    // 1 | open | https://blazedemo.com/ | 
    driver.get("https://blazedemo.com/");
    // 2 | setWindowSize | 1920x1180 | 
    driver.manage().window().setSize(new Dimension(1920, 1080));

    assertEquals("BlazeDemo", driver.getTitle());

    // 3 | select | name=fromPort | label=Philadelphia
    {
      WebElement dropdown = driver.findElement(By.name("fromPort"));
      dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
    }
    // 4 | mouseDownAt | name=fromPort | -0.20000076293945312,0
    {
      WebElement element = driver.findElement(By.name("fromPort"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 5 | mouseMoveAt | name=fromPort | -0.20000076293945312,0
    {
      WebElement element = driver.findElement(By.name("fromPort"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 6 | mouseUpAt | name=fromPort | -0.20000076293945312,0
    {
      WebElement element = driver.findElement(By.name("fromPort"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 7 | select | name=toPort | label=Cairo
    {
      WebElement dropdown = driver.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = 'Cairo']")).click();
    }
    // 8 | mouseDownAt | name=toPort | -0.20000076293945312,0
    {
      WebElement element = driver.findElement(By.name("toPort"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    // 9 | mouseMoveAt | name=toPort | -0.20000076293945312,0
    {
      WebElement element = driver.findElement(By.name("toPort"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 10 | mouseUpAt | name=toPort | -0.20000076293945312,0
    {
      WebElement element = driver.findElement(By.name("toPort"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    // 11 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
    // 12 | click | css=tr:nth-child(5) .btn | 
    driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
    // 13 | click | id=inputName | 
    driver.findElement(By.id("inputName")).click();
    // 15 | type | id=inputName | Rikipalooza
    driver.findElement(By.id("inputName")).sendKeys("Rikipalooza");
    // 16 | click | id=address | 
    driver.findElement(By.id("address")).click();
    // 17 | type | id=address | 123 Main St.
    driver.findElement(By.id("address")).sendKeys("123 Main St.");
    // 18 | type | id=city | Anytown
    driver.findElement(By.id("city")).sendKeys("Anytown");
    // 19 | type | id=state | State
    driver.findElement(By.id("state")).sendKeys("State");
    // 20 | type | id=zipCode | 12345
    driver.findElement(By.id("zipCode")).sendKeys("12345");
    // 21 | click | id=creditCardNumber | 
    driver.findElement(By.id("creditCardNumber")).click();
    // 22 | type | id=creditCardNumber | 123456789
    driver.findElement(By.id("creditCardNumber")).sendKeys("123456789");
    // 23 | click | id=creditCardMonth | 
    driver.findElement(By.id("creditCardMonth")).click();
    // 24 | click | id=creditCardYear | 
    driver.findElement(By.id("creditCardYear")).click();
    // 25 | type | id=creditCardYear | 2022
    driver.findElement(By.id("creditCardYear")).sendKeys("2022");
    // 26 | click | id=nameOnCard | 
    driver.findElement(By.id("nameOnCard")).click();
    // 27 | type | id=nameOnCard | Riki Palooza
    driver.findElement(By.id("nameOnCard")).sendKeys("Riki Palooza");
    // 28 | click | id=rememberMe | 
    driver.findElement(By.id("rememberMe")).click();


    // Asserts in reservation page
    assertEquals("Your flight from TLV to SFO has been reserved.", driver.findElement(By.cssSelector("h2")).getText());
    assertEquals("Airline: United", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(2)")).getText());
    assertEquals("Flight Number: UA954", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(3)")).getText());
    assertEquals("Price: 400", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(4)")).getText());
    assertEquals("Arbitrary Fees and Taxes: 514.76", driver.findElement(By.cssSelector("div:nth-child(2) > p:nth-child(5)")).getText());

    // 29 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();

    assertEquals("Thank you for your purchase today!", driver.findElement(By.cssSelector("h1")).getText());

    // Asserts in confirmation page
    assertEquals("PendingCapture", driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText());
    assertEquals("555 USD", driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText());
    assertEquals("xxxxxxxxxxxx1111", driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).getText());
    assertEquals("11 /2018", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2)")).getText());
    assertEquals("888888", driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(2)")).getText());

    assertEquals("BlazeDemo Confirmation", driver.getTitle());
  }
  
}