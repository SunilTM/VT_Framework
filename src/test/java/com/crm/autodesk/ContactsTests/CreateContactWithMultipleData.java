package com.crm.autodesk.ContactsTests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateOpportunitiesPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.OpportunityPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateContactWithMultipleData extends BaseClass {

	@DataProvider
	public Object[][] getData() throws Throwable {
		return eLib.getExcelData("Contacts");
	}

	@Test(dataProvider = "getData",retryAnalyzer = com.crm.autodesk.genericUtility.RetryAnalyzier.class)
	public void createoppWithMultipleData(String contactName, String SourceSelect, String Title,
			String Email) {

		// Navigate to OpportunityPage
		HomePage hp = new HomePage(driver);
		hp.clickonOpportunities();

		// Navigate to create Opportunities
		OpportunityPage oppoPage = new OpportunityPage(driver);
		oppoPage.clickonCrerateopportunity();

		// Create ooportunity
		CreateOpportunitiesPage createOppoPage = new CreateOpportunitiesPage(driver);
		createOppoPage.createOpportunitywithData(contactName,SourceSelect, Title, Email);
		wLib.switchToWindows(driver, "Contacts");
		driver.findElement(By.id("1")).click();
		wLib.switchToWindows(driver, "EditView");

		driver.close();
	}
}
