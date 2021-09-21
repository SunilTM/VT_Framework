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
public class OpportunitiesNewCustomerEditPage {

	WebDriver driver;

	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public OpportunitiesNewCustomerEditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll Annotation
	@FindBy(className = "lvtHeaderText")
	private WebElement captureEditCustomerViewEdt;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	/**
	 * @return the captureEditCustomerViewEdt
	 */
	public WebElement getCaptureEditCustomerViewEdt() {
		return captureEditCustomerViewEdt;
	}
	
	// rule 05:- Access the WebElements using getter()/ business logic
	
	public String editCustomerView()
	{
		String view = captureEditCustomerViewEdt.getText();
		return view;
	}
}
