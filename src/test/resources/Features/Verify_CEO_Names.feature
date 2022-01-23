@GetCEOName
Feature: This feature is to get the CEO name form the OrangeHRM app
Scenario: This test is to verify CEO Name
Given the user is logged in successfully & in homepage
When the user clicks on directory option from the menubar
And user selects job title as "Chief Executive Officer" from the dropdown using "text"
And clicks on Search button
Then the user should see the CEO name as "John Smith"


