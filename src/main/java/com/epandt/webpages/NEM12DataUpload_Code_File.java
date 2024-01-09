package com.epandt.webpages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NEM12DataUpload_Code_File extends WebBase {
	
	
	private By NEM12dataupload = By.xpath("//span[contains(text(),'NEM12 Data Upload')]");
	
	private By uploadFile = By.id("historicalfileupload");
	
	//select menu 
	public void selectMenu() {

		try {
			
			Actions actions = new Actions(driver);
			WebElement mainMenu = driver.findElement(By.xpath("//span[contains(text(),'Commissioning')]"));
			actions.moveToElement(mainMenu).build().perform();
			Thread.sleep(3000);
			driver.findElement(NEM12dataupload).click();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Upload File 
	public void uploadFile() {
		driver.findElement(uploadFile).click();
	}
}
