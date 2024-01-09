package com.epandt.webpages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBase extends Common_Functions {

	public static WebDriver driver;
	public void openBrowser(String browserName) {
		
		if(browserName.toLowerCase().contains("chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.setBinary("D:/EP&T/Automation_script_git/EPandT/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}	
	}
	
	public void enterUrl(String URL) {
		
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.quit();
	}
}

