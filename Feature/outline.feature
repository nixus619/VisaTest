@FunctionalTest
Feature: MySql Test
 
@SmokeTest @RegressionTest
Scenario: Add entry to Customer Database
Given The user has access to the bat file and database
When The bat file is run
Then The user should be added to the database