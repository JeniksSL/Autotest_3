package com.iba.bdd.steps;


import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import com.iba.framework.core.drivers.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;


import java.time.Duration;


import static org.testng.Assert.assertTrue;

public class FirstScenarioSteps {
    private static WebDriver driver;
    private MainFactoryPage mainFactoryPage;
    private LoginPage loginPage;


    @Before
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Given("a web browser is on page {string}")
    public void openPage(String page){
        driver.get(page);
        mainFactoryPage = new MainFactoryPage();
        loginPage = new LoginPage();
    }

    @And("^the accept cookies button is pressed$")
    public void pressAcceptCookies(){
        mainFactoryPage.waitUntilTrustedButtonDisplayedAndIfDisplayedPressIt();
    }

    @When("^the sign in link is pressed$")
    public void pressSignInLink(){
        mainFactoryPage.clickOnSignInLink();
    }

    @Then("^the log in to Wiggle page is shown$")
    public void checkLoginPageIsShown(){
        assertTrue(loginPage.isLoginContainerDisplayed());
    }


}
