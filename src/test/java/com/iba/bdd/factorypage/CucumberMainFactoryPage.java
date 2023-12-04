package com.iba.bdd.factorypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CucumberMainFactoryPage extends CucumberFactoryPage{
    public CucumberMainFactoryPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(css = "[aria-label='Sign in']")
    private WebElement signInLink;

    @FindBy(css = "[aria-label='My account']")
    private WebElement accountLink;
    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement trustButton;

    @FindBy(id="egain-chat-wrapper")
    private WebElement chatWrapper;

    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    private WebElement termsAdnConditionsLink;

    public boolean isSignInLinkDisplayed(){
        return signInLink.isDisplayed();
    }
    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }
    public boolean isTrustedButtonDisplayed(){
        return trustButton.isDisplayed();
    }

    public void clickOnSignInLink(){
        signInLink.click();
    }

    public void clickOnChatWrapper(){chatWrapper.click();}

    public void clickOnTrustButton(){
        trustButton.click();
    }
    public void clickOnTermsAdnConditionsLink(){
        termsAdnConditionsLink.click();
    }
}
