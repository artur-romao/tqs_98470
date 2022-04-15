package com.recorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
    @FindBy(name="fromPort")
    private WebElement fromLocation;

    @FindBy(name="toPort")
    private WebElement toLocation;

    @FindBy(className="btn-primary")
    private WebElement findButton;

    public void chooseLocations(String from, String to) {
        updateSelect(fromLocation, from);
        updateSelect(toLocation, to);
        findButton.click();
    }

    private void updateSelect(WebElement dropdown, String text) {
        dropdown.findElement(By.xpath("//option[. = '" + text + "']")).click();
    }
}
