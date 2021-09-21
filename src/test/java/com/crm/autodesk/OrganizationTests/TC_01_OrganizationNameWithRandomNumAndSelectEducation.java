package com.crm.autodesk.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.ExcelFileUtility;
import com.crm.autodesk.genericUtility.JSONFileUtilty;
import com.crm.autodesk.genericUtility.WebDriverUtility;
import com.crm.autodesk.genericUtility.javaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_OrganizationNameWithRandomNumAndSelectEducation {
	WebDriver driver;

	@Test
	public void readorganizationnameTest() throws Throwable {

		// read the necessary data
		JSONFileUtilty jsonLib = new JSONFileUtilty();
		javaUtility jLib = new javaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();

		String URL = jsonLib.readDataFromJson("url");
		String BROWSER = jsonLib.readDataFromJson("browser");
		String USERNAME = jsonLib.readDataFromJson("username");
		String PASSWORD = jsonLib.readDataFromJson("password");

		
		WebDriverManager.chromedriver().setup();
		
		// String contactName = eLib.getExceldata("Sheet1", 1, 3);
		String orgName = eLib.getExceldata("Sheet2", 1, 2);

		// Launch Browser
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser Name");
		}

		
		
		wLib.waitForPageLoad(driver);
		wLib.maximizebrowser(driver);
		driver.get(URL);
		
		
		
		// Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Click on Organization
		driver.findElement(By.linkText("Organizations")).click();

		// Click on create Organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Create Organization
		driver.findElement(By.name("accountname")).sendKeys(orgName + jLib.getRandomNum());

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Select education from industry
		driver.findElement(By.name("industry"));
		driver.findElement(By.xpath("//option[@value='Education']")).click();

		Thread.sleep(2000);
		// logout
		WebElement el = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wLib.waitforelementTobeVisible(driver, el);
		wLib.mouseOver(driver, el);

		driver.findElement(By.linkText("Sign Out")).click();

		// close browser
		driver.quit();

	}
}
