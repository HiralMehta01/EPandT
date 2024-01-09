package com.epandt.stepdefinitions;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import com.epandt.webpages.*;

import io.cucumber.java.en.And;
public class Steps_NEM12DataUpload {
	
	NEM12DataUpload_Code_File nemdata = new NEM12DataUpload_Code_File();

	@When("I click on Commissioning menu and NEM12 Data Upload from the submenu")
	public void i_click_on_commissioning_menu_and_nem12_data_upload_from_the_submenu() {
		
		nemdata.selectMenu();
	}

	@And("I upload invalid and valid file and submit it and check response")
	public void i_upload_invalid_and_valid_file_and_submit_it_and_check_response() {
		
		nemdata.uploadFile();
		
	}

	@And("I Sort all the columns of grid and download one document")
	public void i_sort_all_the_columns_of_grid_and_download_one_document() {
		
	}

	@Then("I reset the form by clicking on the cancel button")
	public void i_reset_the_form_by_clicking_on_the_cancel_button() {
	
	}

}
