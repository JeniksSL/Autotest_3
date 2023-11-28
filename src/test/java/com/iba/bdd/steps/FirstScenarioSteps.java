package com.iba.bdd.steps;

import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import com.iba.framework.core.drivers.Driver;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static org.testng.Assert.assertTrue;

public class FirstScenarioSteps {

    public static WebDriver getDriver() {
        return Driver.getDriver();
    }
    private static WebDriver driver;
    private static MainFactoryPage mainFactoryPage ;

    @BeforeAll
    public static void setUp(){
        driver = getDriver();
        mainFactoryPage = new MainFactoryPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }


    @Given("^a web browser is on www\\.wiggle\\.com page$")
    public void openPage(){
        driver.get(START_URL);
    }

    @And("^a cookie agreement window is displayed$")
    public void checkCookieWindow(){
        assertTrue(mainFactoryPage.isTrustedButtonDisplayed());
    }

    @When("^the accept cookies button is pressed$")
    public void pressAcceptCookies(){
        mainFactoryPage.clickOnTrustButton();
    }

    @And("^the sign in link is pressed$")
    public void pressSignInLink(){
        mainFactoryPage.clickOnSignInLink();
    }

    @Then("^the log in to Wiggle page is shown$")
    public void checkLoginPageIsShown(){
        assertTrue(new LoginPage(driver).isLoginContainerDisplayed());
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
