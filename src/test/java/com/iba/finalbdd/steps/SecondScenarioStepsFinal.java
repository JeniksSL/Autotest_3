package com.iba.finalbdd.steps;

import com.iba.bdd.factorypage.CucumberLoginPage;
import com.iba.bdd.factorypage.CucumberMainFactoryPage;
import com.iba.finalbdd.pages.ChatFramePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.LOGGED_URL;
import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static com.iba.framework.core.lib.WigglePageURLs.TERMS_AND_CONDITIONS_URL;
import static com.iba.framework.core.utils.TestProperties.USER_1_LOGIN;
import static com.iba.framework.core.utils.TestProperties.USER_1_PASSWORD;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondScenarioStepsFinal {
    private WebDriver driver;
    private CucumberMainFactoryPage mainFactoryPage;

    private ChatFramePage chatFramePage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Given("^a web browser is on https://www.wiggle.com/terms-and-conditions$")
    public void openPage(){
        driver.get(TERMS_AND_CONDITIONS_URL);
        mainFactoryPage = new CucumberMainFactoryPage(driver);
       // mainFactoryPage.clickOnTrustButton();
        assertThat("Main page is not displayed", driver.getCurrentUrl(), containsString(TERMS_AND_CONDITIONS_URL));
    }

    @And("waggle chat wrapper is clicked")
    public void waggleChatWrapperIsClicked() {
        mainFactoryPage.clickOnChatWrapper();
    }

    @And("^wiggle live chat is displayed$")
    public void enterEmailAndPassword(){
        chatFramePage=new ChatFramePage(driver);
        assertTrue(chatFramePage.textAreaDisplayed());
    }


    @When("{string} is typed in typed area of wiggle live chat")
    public void pressContinueButton(String message){
       chatFramePage.typeInTextArea(message);
    }

    @And("^enter key is pressed$")
    public void checkAccountLink(){

    }

    @Then("{string} is displayed in chat area")
    public void checkLoginPageIsShown(String message){

       }



    @After
    public void tearDown(){
        driver.quit();
    }



}
