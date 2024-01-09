Feature: Site Notes

	Background:
	 Given I open "chrome" browser and enter URL "http://demo.zealousys.com:9050/"
	 When I click on site details button with site and portfolio
	 And I select site notes
	 
  @Sanity
  Scenario: Verify site note added in the grid
	   And I enter data in the notes 
     Then I upload file for site notes 
 		 And Click on submit button
     And Close the browser
    
  @Sanity
  Scenario: Verify all the filters and action tab operations
     And I check all columns filter and click on reset button
     Then I check all the action column operations and click on active toggle button
     And Close the browser
     
    