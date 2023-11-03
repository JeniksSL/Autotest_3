package com.iba.factory.factorypages;

import com.iba.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class FactoryPage {
    private static WebDriver getDriver() {
        return Driver.getDriver();
    }
    protected FactoryPage(){
        PageFactory.initElements(getDriver(), this);
    }
}
