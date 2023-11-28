package com.iba.bdd.steps;

import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import com.iba.framework.core.drivers.Driver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static org.testng.Assert.assertTrue;

public class SecondScenarioSteps {

    public static WebDriver getDriver() {
        return Driver.getDriver();
    }
    private static WebDriver driver;
    private MainFactoryPage mainFactoryPage = new MainFactoryPage();

    private LoginPage loginPage = new LoginPage();


    @BeforeAll
    public static void setUp(){
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }


    @Given("^a web browser is on log in to Wiggle page$")
    public void openPage(){
        driver.get(START_URL);
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnSignInLink();
        assertTrue(loginPage.isLoginContainerDisplayed());
    }

    @And("^email address and password is entered$")
    public void checkCookieWindow(){
        assertTrue(mainFactoryPage.isTrustedButtonDisplayed());
    }

    @When("^the accept cookies button is pressed$")
    public void pressAcceptCookies(){
        mainFactoryPage.clickOnTrustButton();
    }

    @And("^the continue button is pressed$")
    public void pressSignInCookies(){
        mainFactoryPage.clickOnSignInLink();
    }

    @Then("^the main Wiggle page is shown$")
    public void checkLoginPageIsShown(){
        assertTrue(new LoginPage().isLoginContainerDisplayed());
    }

    @And("^the continue button is pressed$")
    public void checkAccountLink(){
        mainFactoryPage.clickOnSignInLink();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    /*  public FirstScenarioSteps() {
       ;


       , () -> {
        });
       ;

        @When("^the continue button is pressed$", () -> {
        });
        @Then("^the main Wiggle page is shown$", () -> {
        });
        @And("^account link is displayed$", () -> {
        });
    }*/
}
