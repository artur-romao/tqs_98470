package com.recorder;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage {
    @FindBy(className = "table")
    private WebElement table;
    @FindBy(tagName="h1")
    private WebElement title;

    public ArrayList<String> getReservationInfo() {
        ArrayList<String> info = new ArrayList<>();
        info.add(getInfo(2)); // Status
        info.add(getInfo(3)); // Amount
        info.add(getInfo(4)); // Card Number
        info.add(getInfo(5)); // Expiration
        info.add(getInfo(6)); // Auth Code
        return info;
    }
    
    public String getInfo(int row) {
        return table.findElement(By.cssSelector("tr:nth-child(" + row + ") > td:nth-child(2)")).getText();
    }

    public String getTitle() {
        return title.getText();
    }
}
