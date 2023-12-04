package com.iba.finalbdd.steps;

import com.iba.bdd.factorypage.CucumberLoginPage;
import com.iba.bdd.factorypage.CucumberMainFactoryPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static com.iba.framework.core.lib.WigglePageURLs.TERMS_AND_CONDITIONS_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class FirstScenarioStepsFinal {
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

    @And("^a cookie agreement button is pressed$")
    public void pressAcceptCookies(){
        mainFactoryPage.clickOnTrustButton();
    }

    @And("^main page is scrolled to footer$")
    public void scrollMainPage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @When("^the accept terms and conditions link is pressed$")
    public void pressTermsAndConditionsLink(){
        mainFactoryPage.clickOnTermsAdnConditionsLink();

    }

    @Then("^terms and conditions page is displayed$")
    public void checkTermsAndConditionsPageIsShown(){
        assertThat("Main page is not displayed", driver.getCurrentUrl(), containsString(TERMS_AND_CONDITIONS_URL));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}