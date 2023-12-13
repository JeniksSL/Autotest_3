package com.iba.factory.factorypages;

import com.iba.framework.core.drivers.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MainFactoryPage extends FactoryPage {

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

    private By frameBy = By.xpath("//iframe[@id='egain-chat-iframe']");

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
    public void waitUntilTrustedButtonDisplayedAndIfDisplayedPressIt(){
        try {
            Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(trustButton));
            trustButton.click();
        } catch (NoSuchElementException | TimeoutException e) {
//Crutch for cookies
        }

    }
    public void clickOnTermsAdnConditionsLink(){
        termsAdnConditionsLink.click();
    }


    public void waitUntilChatWrapperDisplayed() {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(chatWrapper));
    }
    public void switchToChatFrame(){
        WebDriver driver = Driver.getDriver();
        driver.switchTo().frame(driver.findElement(frameBy));
    }

    public boolean chatWrapperDisplayed() {
        return chatWrapper.isDisplayed();
    }
}
