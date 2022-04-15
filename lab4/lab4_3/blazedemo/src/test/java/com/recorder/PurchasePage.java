package com.recorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PurchasePage {
    @FindBy(css="div:nth-child(2) > p:nth-child(2)")
    private WebElement airline;
    @FindBy(css="div:nth-child(2) > p:nth-child(3)")
    private WebElement flightNumber;
    @FindBy(css="div:nth-child(2) > p:nth-child(4)")
    private WebElement price;
    @FindBy(css="div:nth-child(2) > p:nth-child(5)")
    private WebElement feesAndTaxes;

    @FindBy(id = "inputName")
    private WebElement nameInput;
    @FindBy(id = "address")
    private WebElement addressInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "state")
    private WebElement stateInput;
    @FindBy(id = "zipCode")
    private WebElement zipCodeInput;
    @FindBy(id = "cardType")
    private WebElement cardSelect;
    @FindBy(id = "creditCardNumber")
    private WebElement cardNumberInput;
    @FindBy(id = "creditCardMonth")
    private WebElement monthInput;
    @FindBy(id = "creditCardYear")
    private WebElement yearInput;
    @FindBy(id = "nameOnCard")
    private WebElement cardNameInput;
    @FindBy(id = "rememberMe")
    private WebElement rememberMeBox;
    @FindBy(className="btn-primary")
    private WebElement purchaseButton;

    public String getAirline() {
        return airline.getText();
    }

    public String getFlightNumber() {
        return flightNumber.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getFeesAndTaxes() {
        return feesAndTaxes.getText();
    }
    
    public void fillForm(String name, String address, String city, String state, String zipCode, String cardType, Integer cardNumber, Integer month, Integer year, String cardName, boolean rememberMe) {
        fillInputField(nameInput, name);
        fillInputField(addressInput, address);
        fillInputField(cityInput, city);
        fillInputField(stateInput, state);
        fillInputField(zipCodeInput, zipCode);
        fillSelectField(cardSelect, cardType);
        fillInputField(cardNumberInput, cardNumber.toString());
        fillInputField(monthInput, month.toString());
        fillInputField(yearInput, year.toString());
        fillInputField(cardNameInput, cardName);
        if (rememberMe) rememberMeBox.click();

        purchaseButton.click();
    }

    public void fillInputField(WebElement webElement, String field) {
        webElement.sendKeys(field);
    }
    
    public void fillSelectField(WebElement webElement, String field) {
        webElement.findElement(By.xpath("//option[. = '"  + field + "']")).click();
    }
    
}
