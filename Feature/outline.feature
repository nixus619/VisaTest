@FunctionalTest
Feature: MySql Test

@JustOne 
Scenario: I am blind
Given that I might be blind
 
@SmokeTest @RegressionTest
Scenario: Add entry to Customer Database
Given The user has access to the bat file and database
When The bat file is run
Then The user should be added to the database