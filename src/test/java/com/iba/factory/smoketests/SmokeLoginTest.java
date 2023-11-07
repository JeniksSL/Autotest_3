package com.iba.factory.smoketests;

import com.iba.factory.factorypages.LoginPage;
import com.iba.factory.factorypages.MainFactoryPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.lang.reflect.InvocationTargetException;

import static com.iba.framework.core.lib.WigglePageURLs.LOGGED_URL;
import static com.iba.framework.core.utils.TestProperties.USER_1_LOGIN;
import static com.iba.framework.core.utils.TestProperties.USER_1_PASSWORD;
import static org.hamcrest.CoreMatchers.containsString;;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeLoginTest extends BasicLoginTest {

    LoginPage loginPage = new LoginPage();

    //The first test is just for fun but
    @Test(
            dataProvider="loginPageControlsDataProvider",
            dataProviderClass = LoginPage.class,
            description = "Assert the sign in page is loaded, controls is displayed"
    )
    public void assertSignInPageLoadedAllControlsAreDisplayed(String controlsName, String method) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        assertTrue(((WebElement)((loginPage.getClass().getMethod(method).invoke(loginPage)))).isDisplayed(),controlsName.concat(" is not displayed"));
    }

    @Test(description = "Assert the sign in page is loaded, all controls is displayed")
    public void assertSignInPageLoadedControlsAreDisplayed(){
        assertTrue(loginPage.getLoginInput().isDisplayed(), "Login input is not displayed");
        assertTrue(loginPage.getPasswordInput().isDisplayed(), "Password input is not displayed");
        assertTrue(loginPage.getSubmitButton().isDisplayed(), "Submit button is not displayed");
    }



    @Test(
            description = "Assert the sign in page is loaded, login and password typed",
            dependsOnMethods = "assertSignInPageLoadedControlsAreDisplayed"
    )
    public void assertSignInnPageLoadedLoginAndPasswordTyped()  {
        loginPage.typeLogin(USER_1_LOGIN);
        loginPage.typePassword(USER_1_PASSWORD);
        assertEquals(loginPage.getLoginText(), USER_1_LOGIN);
        assertEquals(loginPage.getPasswordText(), USER_1_PASSWORD);
    }

    @Test(
            description = "Assert sign in is performed and main page is displayed with my account link",
            dependsOnMethods = "assertSignInnPageLoadedLoginAndPasswordTyped"
    )
    public void assertSignInPerformedMainPageIsDisplayed()  {
        loginPage.typeLogin(USER_1_LOGIN);
        loginPage.typePassword(USER_1_PASSWORD);
        loginPage.clickOnSubmitButton();
        assertThat("Main page is not displayed", getDriver().getCurrentUrl(), containsString(LOGGED_URL));
        assertTrue(new MainFactoryPage().isAccountLinkDisplayed(), "My account link s not displayed");
    }





}
