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
public class OpportunitiesNewCustomerViewPage {
	WebDriver driver;

	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public OpportunitiesNewCustomerViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll Annotation
	@FindBy(name = "viewName")
	private WebElement viewNameEdt;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement ncvSaveBtn;
	
	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement ncvCancelBtn;
	
	
	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	/**
	 * 
	 * @return the viewNameEdt
	 */
	public WebElement getViewNameEdt() {
		return viewNameEdt;
	}

	/**
	 * @return the ncvSaveBtn
	 */
	public WebElement getNcvSaveBtn() {
		return ncvSaveBtn;
	}

	/**
	 * @return the ncvCancelBtn
	 */
	public WebElement getNcvCancelBtn() {
		return ncvCancelBtn;
	}

	// rule 05:- Access the WebElements using getter()/ business logic
	public void customerViewPageWithCancel(String opportunityNames)
	{
		viewNameEdt.sendKeys(opportunityNames);
		ncvCancelBtn.click();
	}
	public void newCustomerViewName(String opportunityName)
	{
		viewNameEdt.sendKeys(opportunityName);
		ncvSaveBtn.click();
	}
	public void newCustomerSave()
	{
		ncvSaveBtn.click();
	}
	public void newCustomerCancel()
	{
		ncvCancelBtn.click();
	}
	
}
