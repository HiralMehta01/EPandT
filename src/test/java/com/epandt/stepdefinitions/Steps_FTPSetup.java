package com.epandt.stepdefinitions;

import com.epandt.webpages.*;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_FTPSetup {
	
	FTPSetup_Code_File ftpsetup = new FTPSetup_Code_File();
	
	@When("I click on Commissioning menu and FTP setup from the submenu")
	public void i_click_on_commissioning_menu_and_ftp_setup_from_the_submenu() {
	   
		ftpsetup.mainMenu();
	}

	@And("I add all the details in the form and submit it to add the record in table")
	public void i_add_all_the_details_in_the_form_and_submit_it_to_add_the_record_in_table(){
	    
		ftpsetup.formData();
	}

	@And("I select one record edit it and delete it from the table")
	public void i_select_one_record_edit_it_and_delete_it_from_the_table() {
	    
		ftpsetup.editDeleteData();
	}
	
	@Then ("I check all the sorting and filter options of the grid")
	public void i_check_all_the_sorting_and_filter_options_of_the_grid() {
		
	    ftpsetup.filters();
	    ftpsetup.Sorting();
	}
}
