package com.iba.factory.smoketests;

import com.iba.factory.factorypages.LoginPage;
import org.testng.annotations.Test;

import static com.iba.framework.core.utils.TestProperties.USER_1_LOGIN;
import static com.iba.framework.core.utils.TestProperties.USER_1_PASSWORD;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeLoginTest extends BasicLoginTest {

    private LoginPage loginPage = new LoginPage();


    @Test
    public void assertLoginPageOpened() throws InterruptedException {
        assertTrue(loginPage.isControlsDisplayed(), "Controls isn't visible");
        loginPage.typeLogin(USER_1_LOGIN);
        loginPage.typePassword(USER_1_PASSWORD);
        //loginPage.clickOnSubmitButton();
        Thread.sleep(5000);
        assertEquals(loginPage.getLoginText(), USER_1_LOGIN);
        assertEquals(loginPage.getPasswordText(), USER_1_PASSWORD);

    }
}
