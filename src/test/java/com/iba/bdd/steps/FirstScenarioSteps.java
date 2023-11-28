package com.iba.bdd.steps;

import com.iba.bdd.factorypage.CucumberLoginPage;
import com.iba.bdd.factorypage.CucumberMainFactoryPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static org.testng.Assert.assertTrue;

public class FirstScenarioSteps {
    private WebDriver driver;
    private CucumberMainFactoryPage mainFactoryPage;

    private CucumberLoginPage loginPage;


    @Before
    public void setUp(){
        driver = new ChromeDriver();
        mainFactoryPage = new CucumberMainFactoryPage(driver);
        loginPage = new CucumberLoginPage(driver);
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
        assertTrue(loginPage.isLoginContainerDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
