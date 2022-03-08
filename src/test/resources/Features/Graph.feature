Feature: Graph page

Background:
Given User already logged in to the application with valid <username> , <password>
|username|password |
|User6	 |dsalgo123|




Scenario Outline: To check Graph
Given user is in home page
When The user clicks the Get Started button in the Graph Pane 
Then User navigated to the Graph page 
And The user clicks "<Topics>" in the page
Then The user should be directed to "<Topics>" Page
And user clicks Try here button
Then User navigated to "Assessment" page
Examples:
|TOPICS|
|Graph|
|Graph Representations|

Scenario Outline: To insert Python code in editor
Given User is on the Assessment page
When User enters Python Code <Python code> in editor
|print("Hello World")|
Then User sees output as "Hello World"


