package com.stv.design.designpages;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected static WebDriver getDriver() {
        return Driver.getDriver();
    }
}
