Feature: Site Document

Background: 
	Given I open "chrome" browser and enter URL "http://demo.zealousys.com:9050/"
  When I click on site document button with site and portfolio

  #@Sanity
  #Scenario: Verify and upload Assets register document
    #And I select "<document type>" with its "<type>" 
    #And I upload document and click on submit button
    #Then Close the browser
    #
     #Examples: 
      #| document type | type |
      #| Asset Register |       |
    
   #@Sanity
   #Scenario: Verify and upload Audit report document 
      #And I select "<document type>" with "<period type>"
      #And I select month from the dropdown
      #And I upload document and click on submit button
      #Then Close the browser
      #
    #Examples: 
      #| document type |  Period type|
      #| Audit Reports |    Period |
  
  @Sanity
  Scenario: Verify and Upload bill and invoice documents
    And I select "<document type>" from the document type dropdown
    And I select "<utility type>" from the utility type dropdown
    Then I select "<period type>" from the period type radio buttons
    And I upload document and click on submit button
    Then Close the browser   
     
   Examples: 
     | document type | utility type | period type |
     | Bills and Invoices |  Gas  |  period  |
    
    #@Sanity
    #Scenario: Verify Update the record
    #And I select one record from the table and edit the record
    #Then Close the browser  
     
    #@Sanity
    #Scenario: Verify to download and delete record
    #And I Select one record download it and delete it from the table
    #Then Close the browser
    
    #@Sanity
    #Scenario: Verify to view and download all the records
    #And I select two records to download the zip file
    #And I view the document from the table
    #Then Close the browser
     
    #@Sanity
    #Scenario: Verify the filters and reset the grid
    #And I select filter with text and click on filter button
    #And Click on clear button to get back the real data
    #Then Click on reset button to reset the form
    #And Close the browser
    