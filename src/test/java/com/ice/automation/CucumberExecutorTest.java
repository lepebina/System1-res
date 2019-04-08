package com.ice.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Test Runner for cucumber scenarios
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/ice/automation/scenarios/",
        glue = {"com.ice.automation"},
        plugin = {"com.ice.automation.reporters.AllureReporter",
                "json", "json:target/cucumber.json"}
)
public class CucumberExecutorTest {
}
