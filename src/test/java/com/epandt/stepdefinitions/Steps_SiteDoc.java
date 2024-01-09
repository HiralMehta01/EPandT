package com.epandt.stepdefinitions;


import com.epandt.webpages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_SiteDoc {

	WebBase webBase = new WebBase();
	SiteDoc_Code_File sitedoc = new SiteDoc_Code_File();

	@Given("I open {string} browser and enter URL {string}")
	public void i_open_browser_and_enter_url(String browserName, String URL) {

		webBase.openBrowser(browserName);
		webBase.enterUrl(URL);
	}

	@When("I click on site document button with site and portfolio")
	public void i_click_on_site_document_button_with_site_and_portfolio() {

		sitedoc.clickOnSiteDetailLink();
		sitedoc.selectPortfolioSite();
	}
	
	@And("I select {string} with its {string}")
	public void i_select_with_its(String documentType, String type) {
		
		sitedoc.selectDocumentType(documentType, type);
		//sitedoc.selectUtility(type, pType);
	}
	
	@And("I upload document and click on submit button")
	public void i_upload_document_and_click_on_submit_button() throws InterruptedException {

		sitedoc.uploadDocandSubmit();
	}
	
	@When("I select {string} with {string}")
	public void i_select_with(String documenttype, String periodtype ) {
		
		sitedoc.selectSubtypeDocument(documenttype,periodtype);
	}
	
	@And("I select {string} from the document type dropdown")
	public void i_select_from_the_document_type_dropdown(String docType) {
	   
	}

	@And("I select {string} from the utility type dropdown")
	public void i_select_from_the_utility_type_dropdown(String utilityType) {
	   
	}

	@And("I select {string} from the period type radio buttons")
	public void i_select_from_the_period_type_radio_buttons(String periodType) {
	    
	}
	
	@Then("Close the browser")
	public void close_the_browser() throws InterruptedException {

		webBase.closeBrowser();
	}
}