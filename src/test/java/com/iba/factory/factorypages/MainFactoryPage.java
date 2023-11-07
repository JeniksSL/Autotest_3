package com.iba.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(css = "[aria-label='Sign in']")
    private WebElement signInLink;

    @FindBy(css = "[aria-label='My account']")
    private WebElement accountLink;
    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement trustButton;

    public boolean isSignInLinkDisplayed(){
        return signInLink.isDisplayed();
    }
    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }

    public void clickOnSignInLink(){
        signInLink.click();
    }

    public void clickOnTrustButton(){
        trustButton.click();
    }
}
