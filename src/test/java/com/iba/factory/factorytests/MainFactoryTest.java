package com.iba.factory.factorytests;

import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    @Test (description = "Assert the main page is loaded and account icon is visible")
    public void assertAccountIconIsDisplayed() {
        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
        Assert.assertTrue(actualResult, "Account link isn't visible");
    }

    @Test (description = "Assert the login page is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void assertLoginPageOpened() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        Assert.assertTrue(new LoginPage().isLoginContainerDisplayed(), "Login page isn't loaded properly");
    }
}
