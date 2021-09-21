package com.crm.autodesk.ProductTests;

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

public class TC_01_ValidateProductName {
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

		String productName = eLib.getExceldata("Products", 1, 1);
		String productParts = eLib.getExceldata("Products", 1, 2);

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

		// Click on Product
		driver.findElement(By.linkText("Products")).click();

		// Click on create Product
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		// Enter Product name
		driver.findElement(By.name("productname")).sendKeys(productName);
		Thread.sleep(2000);
		// Enter Product parts
		driver.findElement(By.id("productcode")).sendKeys(productParts);

		// Save Create Product
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// fetch product part number
		String num = driver.findElement(By.id("dtlview_Part Number")).getText();

		// Click on Product
		driver.findElement(By.linkText("Products")).click();

		// Click on search for IN Box
		driver.findElement(By.id("bas_searchfield"));

		// click on search and send product name
		driver.findElement(By.xpath("//option[@value='productcode']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(num);

		// click on search now button
		driver.findElement(By.className("crmbutton")).click();

		// Validate product Number
		if (productParts.equals(num)) {
			System.out.println("Number is matching with : " + num);
		} else {
			System.out.println("Number is not matching");
		}
		// Sign out application
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[1]"));
		wLib.mouseOver(driver, ele);

		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		// Close the Browser
		driver.close();

	}
}
