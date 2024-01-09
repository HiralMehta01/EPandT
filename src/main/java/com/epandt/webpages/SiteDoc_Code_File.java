package com.epandt.webpages;

import java.io.File;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteDoc_Code_File extends WebBase {

	private By siteDetailLink = By.cssSelector("a[href='site-document']");

	private By sitePortfolio = By.xpath("//select[@id='PortfolioDDL']/option[2]");

	private By site = By.xpath("//select[@class='ng-untouched ng-pristine ng-valid']");

	private By selectDocumentType = By.xpath("*//select[@id='documentTypeId']/option");

	private By mainDropdown = By.id("documentTypeId");
	
	private By documentUpload = By.id("uploadedDocumentFile");
	
	private By warningMsg = By.xpath("/html/body/app-root/kendo-notification-container/div/kendo-notification/div/div/div");
	
	private By selectMonth = By.xpath("//*[@class='k-input k-dateinput']/input");
	
	private By dropdownUtility = By.id("DDLSelectUtility"); 
	
	private By selectUtility = By.xpath("//option[contains(text(),'Select Utility')]");
	
	// Select site document option from side menu
	public void clickOnSiteDetailLink() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(siteDetailLink));
			driver.findElement(siteDetailLink).click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse("Site document button is not clicked",false);
		}
	}
	
	// Select Portfolio and Site from the top
	public void selectPortfolioSite() {
		try {
			driver.findElement(By.id("PortfolioDDL")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(sitePortfolio));
			driver.findElement(sitePortfolio).click();
			
			WebDriverWait siteWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			siteWait.until(ExpectedConditions.elementToBeClickable(site));
			driver.findElement(site).click();
		} catch (Exception e) {
			Assert.fail("Unable to click on portfolio or site");
		}
	}

	// Select document type
	public void selectDocumentType(String documentType, String pType) {
		try {
				driver.findElement(mainDropdown).click();
				Thread.sleep(3000);
				List<WebElement> lstofDocument = driver.findElements(selectDocumentType);
				driver.findElement(By.xpath("//html")).click();
				for (WebElement getDocument : lstofDocument) {
					String txtDoctype = getDocument.getText();
					if (!txtDoctype.equalsIgnoreCase("Select Document Type")) {
						if (txtDoctype.equalsIgnoreCase(documentType)) {
							System.out.print("Document type gets clicked");
							getDocument.click();
							break;
						} else {
						    System.out.print("Unable to click on document type");
					    }
					}
			    }
		  }catch (Exception e) {
			 Assert.assertFalse("Document is not match with...", false);
		}
	}
	
	//Select bill and invoice document type
	public void billandInvoiceDocument(String docType,String utilityType,String periodType ) {
		try {
			driver.findElement(mainDropdown).click();
			Thread.sleep(3000);
			List<WebElement> lstofDocument = driver.findElements(selectDocumentType);
			List<WebElement> lstUtility = driver.findElements(selectUtility);
			driver.findElement(By.xpath("//html")).click();
			for (WebElement getDocument : lstofDocument) {
				String txtDoctype = getDocument.getText();
				if (!txtDoctype.equalsIgnoreCase("Select Document Type")) {
					if (txtDoctype.equalsIgnoreCase(docType)) {
						getDocument.click();
						break;
					}else {
						Assert.assertFalse("Document type is not match with..", false);
					}
				}
			}
			if (docType.equals("Bills and Invoices")) {				 
				 if(lstUtility.size()>= 0)
					{
					   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					   wait.until(ExpectedConditions.elementToBeClickable(dropdownUtility));
					   driver.findElement(dropdownUtility).click();
					   driver.findElement(By.xpath("//html")).click();
					   for (WebElement getUtility : lstUtility) {
							String txtUtilitytype = getUtility.getText();
							if (!txtUtilitytype.equalsIgnoreCase("Select Utility")) {
								if (txtUtilitytype.equalsIgnoreCase(utilityType)) {
									getUtility.click();
									break;
								}else {
									Assert.assertFalse("Utility type is not match with..", false);
								}
							}
					   }
					   Common_Functions.periodMonthandPeriod("month");
					}
			   }
		} catch (Exception e) {
			Assert.assertFalse("Site document button is not clicked",false);
		}
	}
	
	//Upload document
	public void uploadDocandSubmit() throws InterruptedException {
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
				driver.findElement(By.id("btnSubmitSiteDocument")).click();
				By fileValidation = By.xpath("//*[@id='formSiteDocument']/div[2]/div[1]/p");
				
				if(driver.findElement(warningMsg).isDisplayed() && driver.findElement(fileValidation).isDisplayed() ) {
					System.out.println(driver.findElement(warningMsg).getText());
					System.out.println(driver.findElement(fileValidation).getText());
				}
			} catch (Exception e) {
			Assert.assertFalse("Your document is not submitted", false);
		}
	}
	
	// Select period type radio button with calendar dates
	public void selectSubtypeDocument(String documentType,String periodType) {
		
		try {
			driver.findElement(mainDropdown).click();
			Thread.sleep(3000);
			List<WebElement> lstofDocument = driver.findElements(selectDocumentType);
			driver.findElement(By.xpath("//html")).click();
			for (WebElement getDocument : lstofDocument) {
				System.out.println(lstofDocument);
				String txtDoctype = getDocument.getText();
				if (!txtDoctype.equalsIgnoreCase("Select document type")) {
					if (txtDoctype.equalsIgnoreCase(documentType)) {
						System.out.print("Document type gets clicked");
						getDocument.click();
						break;
					} else {
					    System.out.print("Unable to click on document type");
				    }
				}
			}
	  }catch (Exception e) {
		  Assert.assertFalse("Document type is not match with..", false);
	  }	
	}
	
	//Select month from the audit reports page 
	public void selectMonth() {
		
		try {
			System.out.println(selectMonth);
			WebElement month = driver.findElement(selectMonth);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(month));
			System.out.println(month);
			Thread.sleep(3000);
			month.sendKeys(Keys.ARROW_UP);
			Thread.sleep(3000);
			month.sendKeys(Keys.ARROW_UP);
		} catch (Exception e) {
			Assert.assertFalse("Month is not selected", false);
		}
	}
}
