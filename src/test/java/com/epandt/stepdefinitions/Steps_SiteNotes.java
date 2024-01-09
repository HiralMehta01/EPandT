package com.epandt.stepdefinitions;


import com.epandt.webpages.*;

import io.cucumber.java.en.*;


public class Steps_SiteNotes extends SiteNotes_Code_File {
	
	WebBase webBase = new WebBase();
	SiteNotes_Code_File siteNotes = new SiteNotes_Code_File();

	@When("I click on site details button with site and portfolio")
	public void i_click_on_site_details_button_with_site_and_portfolio() {
		
		siteNotes.clickOnSiteDetails();
	}
	
	@And("I select site notes")
	public void i_select_site_notes() {
		
		siteNotes.clickOnSiteNote(); 
	}

	@And("I enter data in the notes")
	public void i_enter_data_in_the_notes() {
		
	   siteNotes.addDataInNotes();
	}
	
	@And("I upload file for site notes")
	public void i_upload_file_for_site_notes() {
		
	   siteNotes.uploadDocument();
	}

	@Then("Click on submit button")
	public void click_on_submit_button() {
		
		siteNotes.clickOnSubmitButton();
	}
	
	@And("I check all columns filter and click on reset button")
	public void i_check_all_columns_filter_and_click_on_reset_button() {
		
	    siteNotes.filtersandOperations();  
	}

	@Then("I check all the action column operations and click on active toggle button")
	public void i_check_all_the_action_column_operations_and_click_on_active_toggle_button() {
		
		   siteNotes.actionandOperations();
		   siteNotes.editDocument();
	}
}
