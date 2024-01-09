package com.epandt.webpages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class State_Code_File extends WebBase {

	private By stateMenu = By.xpath("//span[contains(text(),'State')]");

	private By username = By.xpath("//input[@id='emailOrLoginName']");

	private By password = By.xpath("//input[@id='password']");

	private By loginButton = By.xpath("//button[contains(text(),'Login')]");
	
	private By countryDropDown = By.xpath("//select[@id='CountryData']");

	private By selectCountry = By.xpath("//*[@id='CountryData']/option");
	
	private By stateName = By.xpath("//input[@id='stateName']");
	
	private By submitButton = By.xpath("//button[@id='btnSubmitSiteNotes']");
	
	private By editButton = By.xpath("(//span[@id='span_editstate'])[1]");
	
	private By deletebutton = By.xpath("//*[@id=\"span_deletestate\"]/span");
	
	private By stateWarningMsg = By.xpath("/html/body/app-root/kendo-notification-container/div/kendo-notification");
	
	private By resetButton = By.xpath("//button[@id='btnResetSiteNotes']");
	
	private By stateFilterIcon = By.xpath("(//span[@class='k-icon k-i-filter'])[1]");
	
	private By searchStateText = By.xpath("//input[@aria-label='State Name Filter']");
	
	private By sfilterButton = By.xpath("//button[contains(text(),'Filter')]");
	
	private By countryFilterIcon = By.xpath("(//span[@class='k-icon k-i-filter'])[2]");
	
	private By searchCountryText = By.xpath("//input[@aria-label='Country Name Filter']");
	
	private By cfilterButton = By.xpath("//button[contains(text(),'Filter')]");
	
	private By stateClearFilter = By.xpath("//button[contains(text(),'Clear')]");
	
	private By countryClearFilter = By.xpath("//button[contains(text(),'Clear')]");
	
	public void loginPage() {

		try {
			WebElement usernameElement = driver.findElement(username);
			usernameElement.click();
			usernameElement.sendKeys("nehalj");
			WebElement passwordElement = driver.findElement(password);
			passwordElement.click();
			passwordElement.sendKeys("Ept1234567890$$");
		} catch (Exception e) {

			e.getStackTrace();
		}
	}

	public void loginButton() {

		try {
			driver.findElement(loginButton).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Click on state menu
	public void clickStateLink() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(stateMenu));
			driver.findElement(stateMenu).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to click on State button");
		}
	}
	
	//Select one country from dropdown
	public void selectCountry(String countryName) {
		
		try {
			driver.findElement(countryDropDown).click();
			Thread.sleep(3000);
			List<WebElement> lstofCountry = driver.findElements(selectCountry);
			driver.findElement(By.xpath("//html")).click();
			for (WebElement getCountry : lstofCountry) {
				String txtDoctype = getCountry.getText();
				if (!txtDoctype.equalsIgnoreCase("Please Select Country")) {
					System.out.println(txtDoctype);	
					if (txtDoctype.equalsIgnoreCase(countryName)) {
						Thread.sleep(2000);
						getCountry.click();
						break;
					} else {
					    System.out.print("Country name is not match with ..");
				    }
				}
		    }
	  }catch (Exception e) {
		
		 e.printStackTrace();
		 Assert.fail("Country has been not selected");
	}
  }
	
	//Add state name 
	public void addState() {
		try {
			driver.findElement(stateName).click();
			driver.findElement(stateName).sendKeys("state");
		} catch (Exception e) {
			Assert.assertFalse("state name is not added",false);
		}
	}
	
	//Click on submit button
	public void clickSubmit() {
		try {
			driver.findElement(submitButton).click();
		} catch (Exception e) {
			Assert.assertFalse("submit button is not clicked", false);
		}
	}
	
	//Edit state name  
	public void clickEditState() {
		try {
			driver.findElement(By.xpath("//span[contains(text(),'State Name')]")).click();
			Thread.sleep(2000);
			driver.findElement(editButton).click();
		} catch (Exception e) {
			Assert.assertFalse("Edit button is not clicked",false);
		}
	}
	
	
	//Edit new name in state name field
	public void editStateName() {
		try {
			Thread.sleep(3000);
			driver.findElement(stateName).clear();
			driver.findElement(stateName).sendKeys("State 101");
		} catch (Exception e) {
			Assert.assertFalse("Edit button is not clicked",false);
		}
	}
	
	//Delete the state
	public void deleteState() {
		try {
			Thread.sleep(2000);
			driver.findElement(deletebutton).click();
		} catch (Exception e) {
			Assert.assertFalse("Unable to delete the record", false);
		}
	}
	
	//confirm to delete the state
	public void confirmDeleteState() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id='SiteDoc_ConfirmBox_Overlap_BtnYes']")).click();
			if(driver.findElement(stateWarningMsg).isDisplayed()) {
				System.out.println(driver.findElement(stateWarningMsg).getText());
			}
		} catch (Exception e) {
			Assert.assertFalse("state is not deleted because yes button is not clicked from confirmation pop up", false);
		}
	}
	
	//reset the form
	public void resetPage() {
		try {
			Thread.sleep(3000);
			driver.findElement(editButton).click();
			Thread.sleep(2000);
			driver.findElement(resetButton).click();
		} catch (Exception e) {
			Assert.assertFalse("Reset button is not clicked", false);
		}
	}
	
	//State filter
	public void stateFilterIcon() {
		try {
			Thread.sleep(2000);
			driver.findElement(stateFilterIcon).click();
		} catch (Exception e) {
			Assert.assertFalse("Filter icon not clicked", false);
		}
	}
	
	//Add text in State filter box
	public void searchStateText() {
		try {
			Thread.sleep(2000);
			driver.findElement(searchStateText).click();
			driver.findElement(searchStateText).sendKeys("nsw");
		} catch (Exception e) {
			Assert.assertFalse("Search text is not added", false);
		}
	}
	
	//Click on filter button
	public void sfilterButton() {
		try {
			driver.findElement(sfilterButton).click();
		} catch (Exception e) {
			Assert.assertFalse("Filter button is not clicked", false);
		}
	}
	
	//Country filter
	public void countryFilterIcon() {
		try {
			Thread.sleep(2000);
			driver.findElement(countryFilterIcon).click();	
		} catch (Exception e) {
			Assert.assertFalse("Filter icon is not clicked", false);
		}
	}
	
	//Add text in State filter box
	public void searchCountryText() {
		try {
			Thread.sleep(2000);
			driver.findElement(searchCountryText).click();
			driver.findElement(searchCountryText).sendKeys("ss1");
		} catch (Exception e) {
			Assert.assertFalse("Text is not added in filter textbox", false);
		}	
	}
		
	//Click on filter button
	public void cfilterButton() {
		try {
			Thread.sleep(2000);
			driver.findElement(cfilterButton).click();
		} catch (Exception e) {
			Assert.assertFalse("Filter button is not clicked", false);
		}	
	}
	
	//Clear filters of state and country
	public void clearStateFilter() {
		try {
			Thread.sleep(2000);
			driver.findElement(stateFilterIcon).click();
			Thread.sleep(2000);
			driver.findElement(stateClearFilter).click();
		} catch (Exception e) {
			Assert.assertFalse("Filter button is not clicked", false);
		}
	}
	
	//clear country filter
	public void clearCountryFilter() {
		try {
			Thread.sleep(2000);
			driver.findElement(countryFilterIcon).click();
			Thread.sleep(2000);
			driver.findElement(countryClearFilter).click();
		} catch (Exception e) {
			
		}
	}
}
