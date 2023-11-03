package com.iba.factory.factorytests;

import com.iba.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static com.iba.framework.core.lib.WigglePageURLs.START_URL;

public class BasicFactoryTest {
    public static WebDriver getDriver() {
        return Driver.getDriver();
    }

    @BeforeClass(description = "Start browser")
    public void setUp() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() throws Exception {
        getDriver().quit();
    }
}
