package com.crm.autodesk.OrganizationsTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.JSONFileUtilty;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnOrganization5thCheckboxofCheckList {

	WebDriver driver;

	@Test
	public void OrganizationTest() throws Throwable {
		WebDriverManager.chromedriver().setup();
		JSONFileUtilty jsonLib = new JSONFileUtilty();
		// Launch the browser
		
		String BROWSER = jsonLib.readDataFromJson("browser");
		String URL = jsonLib.readDataFromJson("url");
		String USERNAME = jsonLib.readDataFromJson("username");
		String PASSWORD = jsonLib.readDataFromJson("password");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
		// Load the URL
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButto")).click();

		// Click on Organization
		driver.findElement(By.linkText("Organizations")).click();

		// Navigate to Checkbox
		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/input[@name='selected_id']"));
		
		//Select 5th row of organization table(Index starts from "0")
		for (int i = 0; i < list.size(); i++) {
			list.get(i = 4).click();
		}

	}
}
