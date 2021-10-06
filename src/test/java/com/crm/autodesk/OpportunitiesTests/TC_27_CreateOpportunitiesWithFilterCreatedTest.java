package com.crm.autodesk.OpportunitiesTests;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateOpportunitiesPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.OpportunitiesNewCustomerViewPage;
import com.crm.autodesk.ElementRepository.OpportunityInfoPage;
import com.crm.autodesk.ElementRepository.OpportunityPage;
import com.crm.autodesk.genericUtility.BaseClass;

import junit.framework.Assert;

@Listeners(com.crm.autodesk.genericUtility.listenerImplimentation.class)
public class TC_27_CreateOpportunitiesWithFilterCreatedTest extends BaseClass {

	@Test(groups = "SmokeSuite",retryAnalyzer = com.crm.autodesk.genericUtility.RetryAnalyzier.class)
	public void createOpportunitiesWithFilterCreatedTest() throws Throwable {

		
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
		System.out.println(infopage.getOppurtunitiesInfo());

		// Again Navigate to OpportunityPage
		hp.clickonOpportunities();

		// Navigate New Customer View Page
		oppoPage.clickFilterdropdown();
		OpportunitiesNewCustomerViewPage oncvPage = new OpportunitiesNewCustomerViewPage(driver);
		oncvPage.newCustomerViewName(opportunityName);

		// Capture and check the text box
		OpportunityPage opofilText = new OpportunityPage(driver);
		String actoppor = opofilText.getFilterName();

		// Verification
		Assert.assertTrue(actoppor.contains(opportunityName));
		System.out.println(opportunityName + " :- Filter Created Successfully by View name And Test Script Pass");
	}
}
