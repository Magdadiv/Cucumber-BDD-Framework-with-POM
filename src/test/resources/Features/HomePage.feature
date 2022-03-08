
Feature: Home page


Scenario: Home page data structures 
Given User is in the home page
Then User sees 6 panes of different <data structures>
|Array|
|Linked List|
|Stack|
|Queue|
|Tree|
|Graph|

When User clicks Get Started button below any one of the <data structures>
|Data Structures-Introduction|
|Array|
|Linked List|
|Stack|
|Queue|
|Tree|
|Graph|

Then User should see the alert message "You are not logged in"


Scenario: Dropdown menu
Given User is in the home page
When User clicks Data Structures dropdown
And User sees 6 different data structure entries
When User selects any one of the data Structure in dropdown	
Then User should see the alert message "You are not logged in"

Scenario: Sign in
Given User is in the home page
When User clicks on the Sign in link
Then User sees the title of the navigated page as "Login"


Scenario: Register
Given User is in the home page
When User clicks on the Register link
Then User sees the title of the navigated page as "Registration"

