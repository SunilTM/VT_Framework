package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;

@Listeners(com.crm.autodesk.genericUtility.listenerImplimentation.class)
public class TC_01_CrateContactWithOrganizationTest extends BaseClass {
	
	@Test
	public void creatcontactwithorganizationTest() throws Throwable {

		String contactName = eLib.getExceldata("Sheet1", 0, 2);
		String orgName = eLib.getExceldata("Sheet1", 0, 3);

		// Click on Contact
		driver.findElement(By.linkText("Contacts")).click();

		// Click on create Contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Create Contact
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		// Switch To Child Window
		wLib.switchToWindows(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		// driver.findElement(By.linkText("Reliance Digital")).click();

		// switch back to parent window
		wLib.switchToWindows(driver, "Contacts");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
	}

}
