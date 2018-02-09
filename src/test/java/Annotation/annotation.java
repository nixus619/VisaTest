package Annotation; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When; 

public class annotation { 
	
   @When("^The bat file is run$") 
	public void runBat() throws IOException{ 
     System.out.println("Ran");
     String output = null;
     String error = null;
     String line = null;
     
//     Process p = Runtime.getRuntime().exec("cmd /c start C:/Users/Admin/Desktop/test.bat");
     Process p = Runtime.getRuntime().exec("C:/Users/Admin/Desktop/test.bat");

     BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
     BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

     while((line = stdOut.readLine()) != null){
    	 output = output + line;
     }
     
     while((line = stdErr.readLine()) != null) {
    	 error = error + line;
     }
     
//     System.out.println("OUTPUT:");
//     System.out.println("---");
//     System.out.println(output);

     System.out.println("ERROR:");
     System.out.println("---");
     System.out.println(error);
   }
	
} 