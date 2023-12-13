package com.iba.factory.factorypages;

import com.iba.framework.core.drivers.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChatFramePage extends FactoryPage {


    @FindBy(id = "egain-chat-message-input-textarea")
    WebElement textArea;

    @FindBy(css=".chat-launch-input")
    private WebElement chatLauncher;


    @FindBy(css = ".bubble > .ng-binding")
    private WebElement messageSpan;

    public boolean textAreaDisplayed() {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textArea));
        return textArea.isDisplayed();
    }
    public void typeInTextArea(String message){
        textArea.sendKeys(message);
    }

    public void clickOnChatLauncher(){chatLauncher.click();}

    public String getEnteredText() {
        return messageSpan.getText();
    }

    public void waitUntilMessageDisplayed() {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageSpan));
    }

    public void pressEnterKey() {
        new Actions(Driver.getDriver()).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
    }
}
