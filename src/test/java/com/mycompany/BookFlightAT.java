package com.mycompany;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {},
        features = "src/test/resources/features",
        glue = "com.mycompany",
        monochrome = true,
        format = {"pretty", "html:target/cucumber"})
public class BookFlightAT {
}
