  Feature: Register Page
  
  Scenario: Registeration
  
     Given User is in Register page
     When User enters valid <username>,<password>,<password confirmation>
     |User6|
     |dsalgo123|
     |dsalgo123|
     And User clicks Register button
     Then User is redirected to Homepage with the messsage "New Account Created. You are logged in as " <username>
     |User6| 
