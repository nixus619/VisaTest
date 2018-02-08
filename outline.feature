@FunctionalTest
Feature: MySql Test
 
@SmokeTest @RegressionTest
Scenario: Add entry to Customer Database
Given The bat file is run
 
@RegressionTest
Scenario: UnSuccessful Login
Given This is a blank test