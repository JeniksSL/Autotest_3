package com.iba.finalbdd.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ChatFramePage {

    @FindBy(id = "egain-chat-message-input-textarea")
    WebElement textArea;

    private By frame = By.xpath("//iframe[@id='egain-chat-iframe']");

    public ChatFramePage(WebDriver webDriver) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOf(textArea));
    }

    public boolean textAreaDisplayed() {
        return textArea.isDisplayed();
    }
    public void typeInTextArea(String message){
        textArea.sendKeys(message);
    }



}
