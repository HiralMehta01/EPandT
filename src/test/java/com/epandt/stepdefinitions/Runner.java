package com.epandt.stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
				 monochrome = true,
				 features = "src/test/java/feature",
				 plugin = { "pretty","html:target/cucumber-pretty",
	                "json:target/cucumber.json" },
				 glue= "Runner/Steps",
				 dryRun = true)
				 

public class Runner {
	
}



 
















