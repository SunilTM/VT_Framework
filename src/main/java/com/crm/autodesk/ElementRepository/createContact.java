package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rule 01:-Create seperate class for every WebPages
public class createContact {
	WebDriver driver;

	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public createContact
	(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll Annotation
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement sourceselect;
	
	@FindBy(id = "title")
	private WebElement selectTitle;
	
	@FindBy(id="email")
	private WebElement emailEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * @return the lastNameEdt
	 */
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	/**
	 * @return the savebtn
	 */
	public WebElement getSavebtn() {
		return savebtn;
	}

	/**
	 * @return the sourceselect
	 */
	public WebElement getSourceselect() {
		return sourceselect;
	}

	/**
	 * @return the selectTitle
	 */
	public WebElement getSelectTitle() {
		return selectTitle;
	}

	/**
	 * @return the emailEdt
	 */
	public WebElement getEmailEdt() {
		return emailEdt;
	}
	
	public void createConatactwithData(String contactName, String SourceSelect, String Title,
			String Email) {
		lastNameEdt.sendKeys(contactName);
		sourceselect.sendKeys(SourceSelect);
		selectTitle.sendKeys(Title);
		emailEdt.sendKeys(Email);
		savebtn.click();
	}	
}
