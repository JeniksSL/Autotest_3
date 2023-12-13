package com.iba.bdd.cucumbertest;



import com.iba.framework.core.drivers.Driver;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
        features = {"src/test/java/com/iba/bdd/features/final_task.feature"},
        glue = {"com.iba.bdd.steps"})
public class TestFinalBddRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void tearDown(){
        Driver.getDriver().quit();
    }
}
