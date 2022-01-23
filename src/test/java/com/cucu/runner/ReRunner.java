package com.cucu.runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		glue = "com.cucu.step_definition",
		dryRun = false,
		monochrome = true	
		
)
public class ReRunner {

}
