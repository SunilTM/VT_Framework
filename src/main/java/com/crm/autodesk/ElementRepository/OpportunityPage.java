package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;
/**
 * 
 * @author SUNIL
 *
 */
//rule 01:-Create seperate class for every WebPages
public class OpportunityPage extends WebDriverUtility {
	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll
	// Annotation
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement crerateopportunityImg;

	@FindBy(linkText = "Create Filter")
	private WebElement createfilterlnk;

	@FindBy(xpath = "//select[@id='viewname']")
	private WebElement filterdropdownclk;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]/a[2]")
	private WebElement editFilterLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLnk;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	public WebElement getCrerateopportunityImg() {
		return crerateopportunityImg;
	}
	
	public WebElement getEditFilterLink() {
		return editFilterLink;
	}
	public WebElement getCreatefilterlnk() {
		return createfilterlnk;
	}

	public WebElement getFilterdropdownclk() {
		return filterdropdownclk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	// rule 05:- Access the WebElements using getter()/ business logic
	public void clickonCrerateopportunity() {
		crerateopportunityImg.click();
	}
	public void editFilterLink()
	{
		editFilterLink.click();
	}

	public void clickFilterdropdown()
	{
		createfilterlnk.click();
	}
	public String getFilterName()
	{
		String filtername = filterdropdownclk.getText();
		return filtername;
	}
	public void administratorImg() {
		administratorImg.click();
	}

	public void getsignoutLnk() {
		signoutLnk.click();
	}
}
