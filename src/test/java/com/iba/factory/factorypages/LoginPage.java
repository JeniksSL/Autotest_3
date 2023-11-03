package com.iba.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {
    @FindBy(xpath = "//*[contains(text(),'Please log in')]")
    private WebElement loginContainer;

    @FindBy(id = "username")
    private WebElement loginInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@data-action-button-primary='true']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
    private WebElement forgotPasswordAnchor;
    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    private WebElement signUpAnchor;

    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public boolean isControlsDisplayed(){
        return loginInput.isDisplayed()&&passwordInput.isDisplayed()&&submitButton.isDisplayed();
    }
    public void typeLogin(String login){
        loginInput.sendKeys(login);
    }
    public void typePassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public String getLoginText(){
        return loginInput.getAttribute("value");
    }
    public String getPasswordText(){
        return passwordInput.getAttribute("value");
    }


}
