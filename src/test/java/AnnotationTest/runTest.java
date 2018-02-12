package AnnotationTest; 

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"Feature"},
		glue = {"stepDefinition"},
		format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
//		plugin = {"json:target/cucumber-json-report"}
		) 

public class runTest { }