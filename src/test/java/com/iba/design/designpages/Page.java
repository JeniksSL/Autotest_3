package com.iba.design.designpages;

import com.iba.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected static WebDriver getDriver() {
        return Driver.getDriver();
    }
}
