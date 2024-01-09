package com.epandt.webpages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SiteNotes_Code_File extends SiteDoc_Code_File {

	SiteDoc_Code_File siteDoc_Code_File = new SiteDoc_Code_File();
	
	private By siteDetails = By.xpath("//span[contains(text(),'Site Details')]");

	private By siteNoteLink = By.cssSelector("button[title='Site Notes']");

	private By notes = By.xpath("//textarea[@id='Notes']");

	private By submitNote = By.xpath("//button[@id='btnSubmitSiteNotes']");

	private By commentsFilter = By.xpath("//a[@title='Comments Filter Menu']");

	private By commentInput = By.xpath("//input[@aria-label='Comments Filter']");

	private By filterButton = By.xpath("//button[contains(text(),'Filter')]");

	private By commentedOnFilter = By.xpath("//a[@title='Commented on Filter Menu']");

	private By commentedOnInput = By.xpath("//input[@aria-label='Commented on Filter']");

	private By commentedByFilter = By.xpath("//a[@title='Commented By Filter Menu']");

	private By commentedByInput = By.xpath("//input[@aria-label='Commented By Filter']");

	private By resetButton = By.xpath("//button[@id='btnResetSiteNotes']");

	private By commentsSorting = By.xpath("//span[contains(text(),'Comments')]");

	private By commentedOnSorting = By.xpath("//span[contains(text(),'Commented on')]");

	private By actionToggle = By.xpath("//input[@id='flexSwitchCheckChecked']");

	private By historyButton = By.xpath("//a[@id='span_historySiteNote']");

	private By viewButton = By.xpath("//a[@id='a_viewSiteNote']");

	private By downloadButton = By.xpath("//a[@id='span_downloadSiteNote']");

	private By documentUpload = By.xpath("//input[@id='uploadedDocumentFile']");

	private By deleteButton = By.xpath("//a[@id='span_deletesitenote']");
	
	private By editButton = By.xpath("//a[@title='Edit']");
	
	public void clickOnSiteDetails() {
		try {
			driver.findElement(siteDetails).click();
		} catch (Exception e) {
			Assert.fail("Site details button is not clicked");
		}
	}

	// select menu site notes
	public void clickOnSiteNote() {

		try {
			Thread.sleep(2000);
			driver.findElement(siteNoteLink).click();
		} catch (Exception e) {
			Assert.fail("Site notes button is not clicked");
		}
	}

	// Add data in sitenotes
	public void addDataInNotes() {
		try {
			driver.findElement(notes).sendKeys("This is example data");
		} catch (Exception e) {
			Assert.assertFalse("Your data is not added", false);
		}
	}
	
	//Add document in notes
	public void uploadDocument() {
		
		try {
			
			 int randomNum = (int)(Math.random() * 2);
			 String filename;
			 if(randomNum == 1) {
				filename = "Doc";
				}else {filename = "exact 50 Mb";}
			 
			File fileInvalid = new File("./Docs/"+filename+".pdf");
			WebElement element = driver.findElement(documentUpload);
			element.sendKeys(fileInvalid.getAbsolutePath());
			Thread.sleep(3000);
			By fileValidation = By.xpath("//*[@id=\"formSiteNotes\"]/div[2]/div[1]/p");
			
			if(driver.findElement(fileValidation).isDisplayed()) {
				
				System.out.println(driver.findElement(fileValidation).getText());
			}
			
		} catch (Exception e) {

			Assert.assertFalse("Your document is not submitted", false);
		}
	}
	
	//Click on submit button
	public void clickOnSubmitButton() {
		try {
			driver.findElement(submitNote).click();
		} catch (Exception e) {
			Assert.fail("Submit button is not clicked");
		}
	}

	// Filters and all operations
	public void filtersandOperations() {

		try {

			Actions action = new Actions(driver);
			List<Filter> filters = new ArrayList<>();
			filters.add(new Filter("test 1", "sep", "Ruchir"));

			for (Filter filter : filters) {

				Thread.sleep(3000);
				driver.findElement(commentsFilter).click();
				Thread.sleep(2000);
				driver.findElement(commentInput).click();
				driver.findElement(commentInput).sendKeys(filter.comments);
				driver.findElement(filterButton).click();
				driver.findElement(commentsFilter).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'Clear')]")).click();

				driver.findElement(commentedOnFilter).click();
				Thread.sleep(2000);
				driver.findElement(commentedOnInput).sendKeys(filter.commentDate);
				Thread.sleep(3000);
				driver.findElement(filterButton).click();
				driver.findElement(commentedOnFilter).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'Clear')]")).click();

				Thread.sleep(1000);
				driver.findElement(commentedByFilter).click();
				Thread.sleep(3000);
				driver.findElement(commentedByInput).sendKeys(filter.commentBy);
				driver.findElement(filterButton).click();
				driver.findElement(commentedByFilter).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'Clear')]")).click();

				driver.findElement(resetButton).click();
				WebElement link = driver.findElement(commentsSorting);
				WebElement linkOne = driver.findElement(commentedOnSorting);
				action.doubleClick(link).perform();
				action.doubleClick(linkOne).perform();
			}
		} catch (Exception e) {
			
			Assert.fail("Unable to perform filter operations");
		}

	}

	// action toggle and all action operations
	public void actionandOperations() {

		try {

			driver.findElement(historyButton).click();
			driver.findElement(By.cssSelector("button[title='Close']")).click();
			Thread.sleep(3000);
			WebElement view = driver.findElement(viewButton);
			Thread.sleep(3000);
			WebElement download = driver.findElement(downloadButton);
			
			if(view.isEnabled()) {
				
				Thread.sleep(2000);
				driver.findElement(viewButton).click();
				driver.findElement(By.cssSelector("button[title='Close']")).click();
				
			} else if(download.isEnabled()){
				
				driver.findElement(downloadButton).click();
				
			}else {
				
				editDocument();
			}
			
			if(download.isEnabled()){
				driver.findElement(downloadButton).click();
			}else {
				
				editDocument();
			}	
			
			driver.findElement(deleteButton).click();
			driver.findElement(By.id("SiteDoc_ConfirmBox_Overlap_BtnYes")).click();
			Thread.sleep(3000);
			driver.findElement(actionToggle).click();
			driver.findElement(By.id("btnResetSiteNotes")).click();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	// edit the document
	public void editDocument() {

		try { 
				driver.findElement(By.xpath("//a[@title='Edit']")).click();
				File fileInvalid = new File("./Docs/26.8MB.pdf");
				double fileSize = (double) fileInvalid.length() / (1024 * 1024);
				WebElement element = driver.findElement(documentUpload);
				element.sendKeys(fileInvalid.getAbsolutePath());
				Thread.sleep(3000);
				driver.findElement(By.id("btnSubmitSiteNotes")).click();
				
				if(fileSize>10) {
					
					WebElement errorOnEditTime = element.findElement(By.xpath("//p[contains(text(),'File size exceeds the maximum limit')]"));
					System.out.println(errorOnEditTime.getText());
					driver.findElement(editButton).click();
					Thread.sleep(3000);
					WebElement elementOnEditTime = driver.findElement(By.id("uploadedDocumentFile"));
					File file = new File("./Docs/doc.pdf");
					elementOnEditTime.sendKeys(file.getAbsolutePath());
					driver.findElement(By.id("btnSubmitSiteNotes")).click();
				}

			} catch (Exception e) {
				
	    	    e.printStackTrace();
	       }
	  }
}
