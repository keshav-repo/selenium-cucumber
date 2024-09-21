package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = { "classpath:features"},
        glue = { "classpath:com/automation/stepdefination",  "classpath:com/automation/helper" },
        plugin = {"pretty", "summary"})
public class FeatureRunner {
}
