
Feature: Feature to test Login funtionality

Scenario: Check login is successful with valid username and password
  
 Given User is on login page
 When User enters  valid <username> ,<password>
  |username|password|
  |User6   |dsalgo123|
  And Clicks login button
 Then User sees the message "You are logged in" with <username> on the top in the Home page.
  |username|
  |User6   |
   
   
Scenario: Check login with invalid username and password
 
 Given User is on login page
  When User enters  invalid <username>,<password>
 |username|password|
 |123 		| 	12   |
 And Clicks login button
 Then User sees the message "Invalid Username and Password"
      