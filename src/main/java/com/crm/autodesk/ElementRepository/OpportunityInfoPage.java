package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author SUNIL
 *
 */
//rule 01:-Create seperate class for every WebPages
public class OpportunityInfoPage {
	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll
	// Annotation
	@FindBy(className = "dvHeaderText")
	private WebElement oppurtunityInfo;

	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement Oppurtunitynameinfo;

	@FindBy(xpath = "//a[@title='Contacts']")
	private WebElement RelatedToInfo;

	@FindBy(linkText = "Support Group")
	private WebElement AssignedToInfo;

	@FindBy(id = "dtlview_Sales")
	private WebElement SalesStageInfo;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	public WebElement getOppurtunityInfo() {
		return oppurtunityInfo;
	}

	public WebElement getOppurtunitynameinfo() {
		return Oppurtunitynameinfo;
	}

	public WebElement getRelatedToInfo() {
		return RelatedToInfo;
	}

	public WebElement getAssignedToInfo() {
		return AssignedToInfo;
	}

	public WebElement getSalesStageInfo() {
		return SalesStageInfo;
	}

	// rule 05:- Access the WebElements using getter()/ business logic

	public String getOppurtunitiesInfo() {
		String value=oppurtunityInfo.getText();
		return value;
	}

	public void getOppurtunitynameinfo1() {
		Oppurtunitynameinfo.getText();
	}

	public void getRelatedToInfo1() {
		RelatedToInfo.getText();
	}

	public void getAssignedToInfo1() {
		AssignedToInfo.getText();
	}

	public void getSalesStageInfo1() {
		SalesStageInfo.getText();
	}

}
