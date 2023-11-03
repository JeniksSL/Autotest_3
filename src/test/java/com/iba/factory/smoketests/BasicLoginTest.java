package com.iba.factory.smoketests;

import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import com.iba.factory.factorytests.BasicFactoryTest;
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

    @BeforeClass(description = "Start browser")
    public void beforeClass() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @BeforeMethod(description = "Open login page")
    public void setUp() {
        MainFactoryPage mainFactoryPage = new MainFactoryPage();
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        Assert.assertTrue(new LoginPage().isLoginContainerDisplayed(), "Login page isn't loaded properly");
    }

    @AfterClass
    public void afterClass() throws Exception {
        getDriver().quit();
    }
}
