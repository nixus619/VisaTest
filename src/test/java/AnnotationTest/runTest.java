package AnnotationTest; 

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"Feature"},
		glue = {"stepDefinition"},
		tags = {"@SmokeTest","@RegressionTest"},
		plugin = {"html:target/cucumber-html-report"}
		) 

public class runTest { }