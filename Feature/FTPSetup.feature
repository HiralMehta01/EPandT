Feature: FTP Setup

  @Regression
  Scenario: 
    Given I open "chrome" browser and enter URL "http://demo.zealousys.com:9050/"
    When I click on Commissioning menu and FTP setup from the submenu 
    And I add all the details in the form and submit it to add the record in table
    And I select one record edit it and delete it from the table
    Then I check all the sorting and filter options of the grid
    And Close the browser