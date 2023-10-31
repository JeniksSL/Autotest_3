package com.stv.design.designpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    private final By REGISTER_LINK_LOCATOR = By.xpath("//img[contains(@alt,'Wiggle')]");
    private final By TRUST_BUTTON = By.xpath("//button[contains(text(),'Accept all')]");

    public boolean isMainLogoDisplayed(){
        WebElement registerLink = getDriver().findElement(REGISTER_LINK_LOCATOR);
        return registerLink.isDisplayed();
    }

    public void clickOnTrustButton(){
        WebElement trustButton = getDriver().findElement(TRUST_BUTTON);
        trustButton.click();
    }

}
