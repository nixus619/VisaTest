package AnnotationTest; 

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"Feature"},
		glue = {"stepDefinition"},
		plugin = {"json:target/cucumber-json-report"}
		) 

public class runTest { }