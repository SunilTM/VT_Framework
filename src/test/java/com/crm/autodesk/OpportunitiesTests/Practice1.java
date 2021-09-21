package com.crm.autodesk.OpportunitiesTests;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ElementRepository.CreateOpportunitiesPage;
import com.crm.autodesk.ElementRepository.HomePage;
import com.crm.autodesk.ElementRepository.OpportunityPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class Practice1 extends BaseClass {
	@Test(groups = "SmokeSuite",retryAnalyzer = com.crm.autodesk.genericUtility.RetryAnalyzier.class)
	public void creatOpportunitiesWithFilterViewnameTest() throws Throwable {


		String opportunityName = eLib.getExceldata("Opportunity", 1, 1) + jLib.getRandomNum();
		String modType = eLib.getExceldata("Opportunity", 1, 2); // contact
		String date =eLib.getExceldata("Opportunity", 1, 5);//2020/12/25
		
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
		//createOppoPage.SalesStage();
		createOppoPage.SalesStageIdDecision();

		// Navigate To contactPage
		wLib.switchToWindows(driver, "Contacts");
		driver.findElement(By.id("1")).click();
		wLib.switchToWindows(driver, "EditView");

	}
}
