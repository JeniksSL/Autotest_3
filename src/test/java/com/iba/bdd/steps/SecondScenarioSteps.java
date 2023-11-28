package com.iba.bdd.steps;

import com.iba.bdd.factorypage.CucumberLoginPage;
import com.iba.bdd.factorypage.CucumberMainFactoryPage;
import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import com.iba.framework.core.drivers.Driver;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.LOGGED_URL;
import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static com.iba.framework.core.utils.TestProperties.USER_1_LOGIN;
import static com.iba.framework.core.utils.TestProperties.USER_1_PASSWORD;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondScenarioSteps {
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

    @Given("^a web browser is on log in to Wiggle page$")
    public void openPage(){
        driver.get(START_URL);
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnSignInLink();
        assertTrue(loginPage.isLoginContainerDisplayed());
    }

    @And("^email address and password is entered$")
    public void enterEmailAndPassword(){
        loginPage.typeLogin(USER_1_LOGIN);
        loginPage.typePassword(USER_1_PASSWORD);
        assertEquals(loginPage.getLoginText(), USER_1_LOGIN);
        assertEquals(loginPage.getPasswordText(), USER_1_PASSWORD);
    }


    @When("^the continue button is pressed$")
    public void pressContinueButton(){
        loginPage.clickOnSubmitButton();
    }

    @Then("^the main Wiggle page is shown$")
    public void checkLoginPageIsShown(){
        assertThat("Main page is not displayed", driver.getCurrentUrl(), containsString(LOGGED_URL));
    }

    @And("^account link is displayed$")
    public void checkAccountLink(){
        assertTrue(mainFactoryPage.isAccountLinkDisplayed(), "My account link s not displayed");
    }

    @After
    public void tearDown(){
        driver.quit();
    }



}
