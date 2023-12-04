package com.iba.bdd.factorypage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class CucumberFactoryPage {

    public WebDriver getWebDriver() {
        return webDriver;
    }

    private final WebDriver webDriver;

    protected CucumberFactoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

}
