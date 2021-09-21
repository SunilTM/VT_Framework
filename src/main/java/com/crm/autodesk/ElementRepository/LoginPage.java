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
// rule 01:-Create seperate class for every WebPages
public class LoginPage {
	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll Annotation
	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginbtn;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//rule 05:- Access the WebElements using getter()/ business logic
	public void login(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();	
	}
}
