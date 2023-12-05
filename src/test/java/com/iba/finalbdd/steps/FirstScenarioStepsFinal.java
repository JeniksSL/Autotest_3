package com.iba.finalbdd.steps;

import com.iba.bdd.factorypage.CucumberMainFactoryPage;
import com.iba.finalbdd.pages.ChatFramePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static com.iba.framework.core.lib.WigglePageURLs.TERMS_AND_CONDITIONS_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstScenarioStepsFinal {
    private WebDriver driver;
    private CucumberMainFactoryPage mainFactoryPage;
    private ChatFramePage chatFramePage;


    @Before
    public void setUp(){
        driver = new ChromeDriver();
        mainFactoryPage = new CucumberMainFactoryPage(driver);
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
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(TERMS_AND_CONDITIONS_URL));
        assertThat("Terms and conditions page is not displayed", driver.getCurrentUrl(), containsString(TERMS_AND_CONDITIONS_URL));
    }
    @And("wiggle chat wrapper is shown")
    public void wiggleChatWrapperIsShown() {
        mainFactoryPage.waitUntilChatWrapperDisplayed();
        assertTrue(mainFactoryPage.chatWrapperDisplayed(), "Chat wrapper div is not displayed");
    }

    @When("wiggle chat wrapper is clicked")
    public void wiggleChatWrapperIsClicked() {
        chatFramePage=new ChatFramePage(driver);
        chatFramePage.clickOnChatLauncher();
    }

    @Then("^wiggle live chat is displayed$")
    public void wiggleChatIsDisplayed(){
        assertTrue(chatFramePage.textAreaDisplayed());
    }


    @When("{string} is typed in typed area of wiggle live chat")
    public void typeMassageInChat(String message){
        chatFramePage.typeInTextArea(message);
    }


    @And("^enter key is pressed$")
    public void pressEnterKey(){
        chatFramePage.pressEnterKey();
    }

    @Then("{string} is displayed in chat area")
    public void checkMessageIsShown(String message){
        chatFramePage.waitUntilMessageDisplayed();
        assertEquals(chatFramePage.getEnteredText(), message);

    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
