package com.epandt.stepdefinitions;

import com.epandt.webpages.State_Code_File;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_State extends State_Code_File{
	
	State_Code_File state = new State_Code_File();

	@When("I enter username and password in login fields")
	public void i_enter_username_and_password_in_login_fields() {
		state.loginPage();
	}
	
	@And("I click on login button")
	public void i_click_on_login_button() {
	    
		state.loginButton();
	}
	
	@Then("I click on state button")
	public void i_click_on_state_button() {
		state.clickStateLink();
	}
	
	@When("I select {string} from the select country drop down")
	public void i_select_from_the_select_country_drop_down(String countryName) {
		
	    state.selectCountry(countryName);
	}

	@And("I add state name in state name field")
	public void i_add_state_name_in_state_name_field() {
	    state.addState();
	}

	@Then("I click on submit button")
	public void i_click_on_submit_button() {
		state.clickSubmit();
	}

	@When("I click on edit button from the table records")
	public void i_click_on_edit_button_from_the_table_records() {
	   state.clickEditState();
	}

	@And("I Edit state name in the state name field")
	public void i_edit_state_name_in_the_state_name_field() {
	    state.editStateName();
	}

	@And("I click on delete button from the table records")
	public void i_click_on_delete_button_from_the_table_records() {
	    state.deleteState();
	}

	@And("I click on yes from the confirmation pop up")
	public void i_click_on_yes_from_the_confirmation_pop_up() {
	   state.confirmDeleteState();
	}

	@When("I click on the edit button from the table data")
	public void i_click_on_the_edit_button_from_the_table_data() {
		 state.clickEditState();
	}

	@Then("I click on reset button")
	public void i_click_on_reset_button() {
	  state.resetPage();
	}

	@When("I click on filter icon from the state name column")
	public void i_click_on_filter_icon_from_the_state_name_column() {
		state.stateFilterIcon();
	}
	
	@Then("I enter text in the state filter textbox")
	public void i_enter_text_in_the_state_filter_textbox() {
		state.searchStateText();
	}
	
	@And("I click on the filter button")
	public void i_click_on_the_filter_button() {
		state.sfilterButton();
	}

	@And("I click on filter icon from country name column")
	public void i_click_on_filter_icon_from_country_name_column() {
		state.countryFilterIcon();
	}
	
	@Then("I enter text in the country filter textbox")
	public void i_enter_text_in_the_country_filter_textbox() {
		state.searchCountryText();
	}

	@And("I click on filter button")
	public void i_click_on_filter_button() {
		state.cfilterButton();
	}
	
	@And("I click on state name filter icon and clear the filter by clicking on clear button")
	public void i_click_on_state_name_filter_icon_and_clear_the_filter_by_clicking_on_clear_button() {
		state.clearStateFilter();
	}

	@Then("I click on country name filter icon and clear the filter by clicking on clear button")
	public void i_click_on_country_name_filter_icon_and_clear_the_filter_by_clicking_on_clear_button() {
		state.clearCountryFilter();
	}
}
