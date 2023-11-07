package com.iba.factory.smoketests;

import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import com.iba.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;

public class BasicLoginTest {
    public static WebDriver getDriver() {
        return Driver.getDriver();
    }
    private WebDriver driver;
    private MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @BeforeClass(description = "Start browser, skip accept cookies")
    public void beforeClass() {
        driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        mainFactoryPage.clickOnTrustButton();
    }
    @BeforeMethod(description = "Open login page")
    public void setUp() {
        mainFactoryPage.clickOnSignInLink();
        Assert.assertTrue(new LoginPage().isLoginContainerDisplayed(), "Login page isn't loaded properly");
    }
    @AfterMethod(description = "Open main page")
    public void tearDown(){
        driver.get(START_URL);
    }

    @AfterClass
    public void afterClass() throws Exception {
        getDriver().quit();
    }
}
