package com.iba.bdd.steps;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature/sign_in.feature"},
        glue = {"com.iba.bdd.steps"})
public class SignInTest extends AbstractTestNGCucumberTests {
}
