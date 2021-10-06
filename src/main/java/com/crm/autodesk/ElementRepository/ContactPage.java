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
public class ContactPage {
	WebDriver driver;

	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll
	// Annotation
	@FindBy(linkText = "John")
	private WebElement firstNameEdt;

	@FindBy(id = "search_txt")
	private WebElement nameEnter;

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContact;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}
	
	public WebElement getNameEnter() {
		return nameEnter;
	}

	public WebElement getCreateContact() {
		return createContact;
	}

	// rule 05:- Access the WebElements using getter()/ business logic
	public void clickName(String firstNameEdt) {
		clickName(firstNameEdt);
	}

	public void sendName(String name) {
		sendName(name);
	}
	public void createconatct() {
		createContact.click();
	}
}
