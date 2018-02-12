package AnnotationTest; 

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = {"Feature"},
		format = {"pretty", "html:target/cucumber"},
		glue = {"stepDefinition"},
		tags = {"@SmokeTest","@RegressionTest"} ) 

public class runTest { }