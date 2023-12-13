package com.iba.bdd.cucumbertest;



import com.iba.framework.core.drivers.Driver;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/com/iba/bdd/sign_in.feature"},
        glue = {"com.iba.bdd.steps"})
public class SignInRunner extends AbstractTestNGCucumberTests {

    @After("@featureTag")
    public void afterFeature(){
        Driver.getDriver().quit();
    }

}
