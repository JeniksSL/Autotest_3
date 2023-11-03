package com.iba.framework.core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            setChromeDriver();
        }
        return driver;
    }

    private static void setChromeDriver()
    {
        driver = new ChromeDriver();
    }

    /**
     * The method can be used to run tests in Fire fox
     */


}
