package com.iba.bdd.steps;

import com.iba.factory.factorypages.MainFactoryPage;
import com.iba.factory.factorypages.ChatFramePage;
import com.iba.framework.core.drivers.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.TERMS_AND_CONDITIONS_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FinalScenarioSteps {
    private static WebDriver driver;
    private MainFactoryPage mainFactoryPage;
    private ChatFramePage chatFramePage;


    @Before
    public void setUp(){
        driver = Driver.getDriver();
        mainFactoryPage = new MainFactoryPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Given("a web browser is on {string} page")
    public void openStartPage(String page){
        driver.get(page);
    }

    @And("^a cookie agreement button is pressed$")
    public void pressAcceptCookies(){
        mainFactoryPage.waitUntilTrustedButtonDisplayedAndIfDisplayedPressIt();
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
        mainFactoryPage.switchToChatFrame();
        chatFramePage=new ChatFramePage();
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


}
