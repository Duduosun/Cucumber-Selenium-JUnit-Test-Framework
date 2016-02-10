package com.nat.jenkins.qa;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        glue = "com.nat.jenkins.qa.step",
        features = "classpath:com/nat/jenkins/qa/feature/newItem/newItem.feature"
)
public class RunCukeTest {
}
