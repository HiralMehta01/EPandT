package com.epandt.webpages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common_Functions {

	public static WebDriver driver = null;
	//public static WebDriver driver;


	// month and period
	public static void periodMonthandPeriod(String ptype) {

		try {
			
			 if (ptype.equalsIgnoreCase("month")) {
				Thread.sleep(3000);
				WebElement month = driver.findElement(By.xpath("//*[@class='k-input k-dateinput']/input"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(month));
				month.sendKeys(Keys.ARROW_UP);
				Thread.sleep(3000);
				month.sendKeys(Keys.ARROW_UP);
				
			 } else if (ptype.equalsIgnoreCase("period")) {
				    // period
				    Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@id='RBPeriodperiod']")).click();
					WebElement calStart = driver.findElement(By.cssSelector("#CalPeriodStart > input"));
					calStart.click();
					Thread.sleep(4000);
					WebElement calEnd = driver.findElement(By.cssSelector("#CalPeriodEnd > input"));
					calEnd.sendKeys(Keys.ARROW_UP);
					Thread.sleep(4000);
					calEnd.sendKeys(Keys.ARROW_UP);
					calEnd.sendKeys(Keys.ARROW_UP);
					Thread.sleep(3000);
					Actions action = new Actions(driver);
					action.moveByOffset(0, 0).click().build().perform();				
			 } else {
				System.out.println("No any period type is selected");
		   }
		} catch (Exception e) {
			System.out.println("Catch block executed " + e);
		}
	}
}
