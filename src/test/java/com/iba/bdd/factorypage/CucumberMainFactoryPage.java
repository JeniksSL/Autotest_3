package com.iba.bdd.factorypage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(css=".chat-launch-input")
    private WebElement chatLauncher;

    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    private WebElement termsAdnConditionsLink;

    @FindBy(id = "egain-chat-wrapper")
    private WebElement chatWrapper;

    public boolean isSignInLinkDisplayed(){
        return signInLink.isDisplayed();
    }
    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }
    public boolean isTrustedButtonDisplayed(){
        return trustButton.isDisplayed();
    }

    public boolean isChatLauncherDisplayed(){
        return chatLauncher.isDisplayed();
    }

    public void clickOnSignInLink(){
        signInLink.click();
    }

    public void clickOnChatLauncher(){chatLauncher.click();}

    public void hoverChatWrapper(){
        /*Wait<WebDriver> wait = new WebDriverWait(super.getWebDriver(), Duration.ofSeconds(10));
        chatWrapper = wait.until(ExpectedConditions.visibilityOf(chatWrapper));
        Actions action  = new Actions(super.getWebDriver());
        action.moveToElement(chatWrapper).click().build().perform();*/
    }

    public void clickOnTrustButton(){
        trustButton.click();
    }
    public void clickOnTermsAdnConditionsLink(){
        termsAdnConditionsLink.click();
    }

    public void waitUntilChatWrapperDisplayed() {
        Wait<WebDriver> wait = new WebDriverWait(super.getWebDriver(), Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(chatWrapper));
    }

    public boolean chatWrapperDisplayed() {
        return chatWrapper.isDisplayed();
    }
}
