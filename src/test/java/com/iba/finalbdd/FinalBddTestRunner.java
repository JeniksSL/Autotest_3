package com.iba.finalbdd;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/com/iba/finalbdd/final_task.feature"},
        glue = {"com.iba.finalbdd.steps"})
public class FinalBddTestRunner extends AbstractTestNGCucumberTests {

}
