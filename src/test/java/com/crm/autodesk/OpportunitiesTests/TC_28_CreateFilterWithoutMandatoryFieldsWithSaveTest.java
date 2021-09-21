package com.crm.autodesk.OpportunitiesTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateOpportunitiesPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.OpportunitiesNewCustomerViewPage;
import com.crm.autodesk.ElementRepository.OpportunityInfoPage;
import com.crm.autodesk.ElementRepository.OpportunityPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class TC_28_CreateFilterWithoutMandatoryFieldsWithSaveTest extends BaseClass {

	@Test(groups = "RegressionSuite",retryAnalyzer = com.crm.autodesk.genericUtility.RetryAnalyzier.class)
	public void createFilterWithMandatoryFieldsWithoutSaveTest() throws Throwable {

		String opportunityName = eLib.getExceldata("Opportunity", 1, 1) + jLib.getRandomNum();
		String modType = eLib.getExceldata("Opportunity", 1, 2); // contact
		String amount = eLib.getExceldata("Opportunity", 1, 4); // 1000
		String date =eLib.getExceldata("Opportunity", 1, 5);//2020/12/25
		//String name =eLib.getExceldata("Contacts", 1, 1);//Sunil
		
		// Navigate to OpportunityPage
		HomePage hp = new HomePage(driver);
		hp.clickonOpportunities();

		// Navigate to create Opportunities
		OpportunityPage oppoPage = new OpportunityPage(driver);
		oppoPage.clickonCrerateopportunity();

		// Create ooportunity
		CreateOpportunitiesPage createOppoPage = new CreateOpportunitiesPage(driver);
		createOppoPage.assigntoUserDropdown();
		createOppoPage.SalesStage();
		createOppoPage.clickCalender(date);
		createOppoPage.createopprunity(opportunityName);
		createOppoPage.RelatedToContact(modType);
		createOppoPage.SelectLookUp();
		
		// Navigate To contactPage
		wLib.switchToWindows(driver, "Contacts");
		driver.findElement(By.id("1")).click();
		wLib.switchToWindows(driver, "EditView");

		// Select Sales Stages and Click on Save Button
		createOppoPage.enterAmount(amount);
		OpportunityInfoPage infopage = new OpportunityInfoPage(driver);
		infopage.getOppurtunitiesInfo();

		// Again Navigate to OpportunityPage
		hp.clickonOpportunities();

		// Navigate New Customer View Page by clicking create filter
		oppoPage.clickFilterdropdown();
		OpportunitiesNewCustomerViewPage oncvPage = new OpportunitiesNewCustomerViewPage(driver);
		oncvPage.newCustomerSave();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText() + "        -: Should not be empty");
		alt.dismiss();

	}
}
