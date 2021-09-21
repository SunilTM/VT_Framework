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
// rule 01 :-Create seperate class for every WebPages
public class HomePage extends WebDriverUtility {

	WebDriver driver;

	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll
	// Annotation
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Calendar")
	private WebElement calendarLink;

	@FindBy(linkText = "Leads")
	private WebElement leadLink;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLnk;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	// rule 05:- Access the WebElementsusing getter()/ business logic
	public void clickonOpportunities() {
		opportunitiesLink.click();
	}

	public void clickoCalendar() {
		calendarLink.click();
	}

	public void clickonLead() {
		leadLink.click();
	}

	public void clickonOrganizations() {
		organizationsLink.click();
	}

	public void clickonContacts() {
		contactsLink.click();
	}

	public void clickonProducts() {
		productsLink.click();
	}

	public void clickonCampaigns() {
		campaignsLink.click();
	}

	public void clickonAdministrator() {
		administratorImg.click();
	}

	public void clickonSignout(WebDriver driver) {
		mouseOver(driver, administratorImg);
		signoutLnk.click();
	}

}
