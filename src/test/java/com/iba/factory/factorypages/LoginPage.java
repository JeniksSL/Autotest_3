package com.iba.factory.factorypages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

@Getter
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

    public void typeLogin(String login){
        loginInput.sendKeys(login);
    }
    public void typePassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }
    public void clickOnSignUpAnchor(){
        signUpAnchor.click();
    }

    public String getLoginText(){
        return loginInput.getAttribute("value");
    }
    public String getPasswordText(){
        return passwordInput.getAttribute("value");
    }

    @DataProvider(name = "loginPageControlsDataProvider")
    public static Object[][] loginPageControlsDisplayed() {
        return new Object[][] {
                { "Login input", "getLoginInput" },
                { "Password input", "getPasswordInput" },
                {"Submit button", "getSubmitButton" },
                {"Sign up Anchor", "getSignUpAnchor"},
                {"Forgot password Anchor", "getForgotPasswordAnchor"}
        };
    }


}
