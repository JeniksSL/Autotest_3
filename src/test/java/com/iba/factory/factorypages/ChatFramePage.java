package com.iba.factory.factorypages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChatFramePage extends FactoryPage {

    private WebDriver webDriver;

    @FindBy(id = "egain-chat-message-input-textarea")
    WebElement textArea;

    @FindBy(css=".chat-launch-input")
    private WebElement chatLauncher;


    @FindBy(css = ".bubble > .ng-binding")
    private WebElement messageSpan;

    private By frameBy = By.xpath("//iframe[@id='egain-chat-iframe']");

    public boolean textAreaDisplayed() {
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
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageSpan));
    }

    public void pressEnterKey() {
        new Actions(webDriver).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
    }
}
