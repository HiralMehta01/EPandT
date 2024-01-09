Feature: Add State

Background: 
 Given I open "chrome" browser and enter URL "http://192.168.0.152:8085/login"
 When I enter username and password in login fields
 And I click on login button
 Then I click on state button 
 
@Sanity 		
Scenario: Add new state 
 And I select "<country>" from the select country drop down
 And I add state name in state name field 
 Then I click on submit button
 And Close the browser
 
 Examples: 
 		| country |
 		| Country 102 | 
 		
 @Sanity
 Scenario: Edit the state
 And I click on edit button from the table records
 And I Edit state name in the state name field
 Then I click on submit button
 And Close the browser
 
 @Sanity
 Scenario: Delete the state
 And I click on delete button from the table records
 Then I click on yes from the confirmation pop up
 And Close the browser
 
 @Sanity
 Scenario: Reset the page
 And I click on the edit button from the table data
 Then I click on reset button 
 And Close the browser 
 
 @Sanity
 Scenario: Filter state name and country name 
 And I click on filter icon from the state name column
 And I enter text in the state filter textbox
 And I click on the filter button 
 Then I click on filter icon from country name column
 And I enter text in the country filter textbox
 Then I click on filter button 
 And I click on state name filter icon and clear the filter by clicking on clear button
 Then I click on country name filter icon and clear the filter by clicking on clear button
 And Close the browser
 