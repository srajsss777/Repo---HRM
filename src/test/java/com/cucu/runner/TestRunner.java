package com.cucu.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Features",
		glue = "com.cucu.step_definition",
		dryRun = false,
		monochrome = true,
		plugin = {"rerun:target/failed_scenarios.txt"}
		
		)
public class TestRunner {
	
	

}
