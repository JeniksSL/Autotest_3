package com.iba.finalbdd;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature/final_task.feature"},
        glue = {"com.iba.finalbdd.steps"})
public class FinalBddTest extends AbstractTestNGCucumberTests {

}
