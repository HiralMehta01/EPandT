package com.epandt.webpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FTPSetup_Code_File extends WebBase {

	private By ftpSetup = By.xpath("//span[contains(text(),'FTP Setup')]");

	private By ftpURL = By.xpath("//input[@id='NEM12ImportFTPURL']");

	private By userName = By.xpath("//input[@id='username']");

	private By password = By.xpath("//input[@id='password']");

	private By supplierName = By.xpath("//input[@id='suppliername']");

	private By supplierEmail = By.xpath("//textarea[@id='supplierEmailAddessString']");

	private By submitButton = By.cssSelector("button[title='Submit']");

	private By editButton = By.cssSelector("span[title='Edit']");

	private By yesButton = By.cssSelector("button[title='Yes']");

	private By deleteButton = By.cssSelector("span[title='Delete']");

	private By filterButton = By.cssSelector("a[title='FTP URL Filter Menu']");

	private By filterInput = By.cssSelector("input[aria-label='FTP URL Filter']");

	private By applyFilter = By.xpath("//button[contains(text(),'Filter')]");

	private By clearFilter = By.xpath("//button[contains(text(),'Clear')]");

	private By userNameFilter = By.cssSelector("a[title='UserName Filter Menu']");

	private By userNameInput = By.xpath("//input[@aria-label='UserName Filter']");

	private By passwordFilter = By.cssSelector("a[title='Password Filter Menu']");

	private By passwordFilterInput = By.xpath("//input[@aria-label='Password Filter']");

	private By passwordFilterClick = By.xpath("//button[normalize-space()='Filter']");

	private By passwordFilterClear = By.xpath("//button[normalize-space()='Clear']");
	
	private By FTPURL = By.xpath("//span[contains(text(),'FTP URL')]");
	
	private By userNameSort = By.xpath("//span[contains(text(),'UserName')]");
	
	private By passwordSort = By.xpath("//span[contains(text(),'Password')]");
	
	private By SupplierName = By.xpath("//span[contains(text(),'Supplier Name')]");
	
	private By resetButton  = By.cssSelector("button[id='btnReset'");
	
	public void mainMenu() {

		try {
			Actions actions = new Actions(driver);
			WebElement mainMenu = driver.findElement(By.xpath("//span[contains(text(),'Commissioning')]"));
			actions.moveToElement(mainMenu).build().perform();
			Thread.sleep(3000);
			driver.findElement(ftpSetup).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Form data
	public void formData() {

		try {

			Thread.sleep(2000);
			driver.findElement(ftpURL).click();
			driver.findElement(ftpURL).sendKeys("www.google.com");
			driver.findElement(userName).click();
			driver.findElement(userName).sendKeys("Joey tribyani");
			driver.findElement(password).click();
			driver.findElement(password).sendKeys("Test@123");
			driver.findElement(supplierName).click();
			driver.findElement(supplierName).sendKeys("Ross Galler");
			driver.findElement(supplierEmail).click();
			driver.findElement(supplierEmail).sendKeys("Test@gmail.com;ross@mail.com");
			driver.findElement(submitButton).click();

			driver.findElement(By.cssSelector("button[title='Yes']")).click();

		} catch (Exception e) {

			System.out.println(e);
		}
	}

	// Edit and delete record
	public void editDeleteData() {

		try {

			driver.findElement(editButton).click();
			Thread.sleep(2000);
			driver.findElement(supplierEmail).clear();
			driver.findElement(submitButton).click();
			driver.findElement(deleteButton).click();
			Thread.sleep(2000);
			driver.findElement(yesButton).click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Filter 
	public void filters() {

		try {
			
			//FTP Url Filter
			driver.findElement(filterButton).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(filterInput));
			driver.findElement(filterInput).click();
			driver.findElement(filterInput).sendKeys("www");
			driver.findElement(applyFilter).click();
			driver.findElement(filterButton).click();
			Thread.sleep(2000);
			driver.findElement(clearFilter).click();
			
			//User Name Filter
			driver.findElement(userNameFilter).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(userNameInput));
			driver.findElement(userNameInput).click();
			driver.findElement(userNameInput).sendKeys("asd");
			driver.findElement(applyFilter).click();
			Thread.sleep(2000);
			driver.findElement(userNameFilter).click();
			Thread.sleep(2000);
			driver.findElement(clearFilter).click();
			
			//Password Filter
			driver.findElement(passwordFilter).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFilterInput));
			driver.findElement(passwordFilterInput).click();
			driver.findElement(passwordFilterInput).sendKeys("123");
			Thread.sleep(2000);
			driver.findElement(passwordFilterClick).click();
			driver.findElement(passwordFilter).click();
			Thread.sleep(2000);
			driver.findElement(passwordFilterClear).click();
			
		} catch (Exception e) {

			System.out.println(e);
		}
	}
	
	
	//Sorting 
	public void Sorting() {
		
		Actions action = new Actions(driver);
		WebElement FTPlink = driver.findElement(FTPURL);
		WebElement userName  = driver.findElement(userNameSort);
		WebElement password = driver.findElement(passwordSort);
		WebElement supplierName = driver.findElement(SupplierName);
	
		action.doubleClick(FTPlink).perform();
		action.doubleClick(userName).perform();
		action.doubleClick(password).perform();
		action.doubleClick(supplierName).perform();	
		
		driver.findElement(resetButton).click();
		
		
	}
}
