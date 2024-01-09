Feature: NEM12 Data Upload 

 
  Background: 
   Given I open "chrome" browser and enter URL "http://demo.zealousys.com:9050/"
   
  @Regression
  Scenario: 
    When I click on Commissioning menu and NEM12 Data Upload from the submenu 
    And I upload invalid and valid file and submit it and check response
    #And I Sort all the columns of grid and download one document
    #Then I reset the form by clicking on the cancel button 
    #And Close the browser