package com.iba.finalbdd.steps;

import com.iba.bdd.factorypage.CucumberMainFactoryPage;
import com.iba.finalbdd.pages.ChatFramePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;
import static com.iba.framework.core.lib.WigglePageURLs.TERMS_AND_CONDITIONS_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class FirstScenarioStepsFinal {
    private WebDriver driver;
    private CucumberMainFactoryPage mainFactoryPage;
    private ChatFramePage chatFramePage;

    private By wrapperDiv = By.id("egain-chat-wrapper");

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
        assertThat("Terms and conditions page is not displayed", driver.getCurrentUrl(), containsString(TERMS_AND_CONDITIONS_URL));
    }

    @And("wiggle chat wrapper is clicked")
    public void waggleChatWrapperIsClicked() throws InterruptedException {


        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webElement= wait.until(ExpectedConditions.visibilityOfElementLocated(wrapperDiv));
        driver.switchTo().frame(driver.findElement(By.id("egain-chat-iframe")));
        mainFactoryPage = new CucumberMainFactoryPage(driver);
        mainFactoryPage.clickOnChatLauncher();
        /*
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('egain-chat-wrapper').click()");
        jse.executeScript("document.getElementById('egain-chat-iframe').click()");*/
       // mainFactoryPage.clickOnChatWrapper();
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
