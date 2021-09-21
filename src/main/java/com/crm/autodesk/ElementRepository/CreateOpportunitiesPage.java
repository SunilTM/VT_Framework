package com.crm.autodesk.ElementRepository;

import org.openqa.selenium.Keys;
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
public class CreateOpportunitiesPage extends WebDriverUtility {
	WebDriver driver;

	// rule 04:-Create a Constructor and use pagefactory class to initialize
	public CreateOpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// rule 02:-Identify all WebElements by using @FindBy,@FindBys & @FindAll
	// Annotation
	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement opprunitynameEdt;

	@FindBy(name = "opportunity_type")
	private WebElement typeselect;

	@FindBy(name = "leadsource")
	private WebElement leadsourceselect;

	@FindBy(id = "related_to_type")
	private WebElement relatedToClk;

	@FindBy(name = "sales_stage")
	private WebElement selectsalesstages;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement selectLokupClk;

	@FindBy(xpath = "(//option[@value='Contacts'])[2]")
	private WebElement relatedToContactclk;

	@FindBy(xpath = "//input[@name='amount']")
	private WebElement amountClk;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(xpath = "(//input[@name='assigntype'])[1]")
	private WebElement assigntoUserDropdown;

	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement assigntoGroupDropdown;

	@FindBy(id = "jscal_field_closingdate")
	private WebElement calenderTextClk;

	@FindBy(id = "jscal_trigger_closingdate")
	private WebElement calenderLookupclk;

	@FindBy(xpath = "//table/tbody/tr[*]/td[@class='day selected today weekend']")
	private WebElement currentDateclk;

	@FindBy(xpath = "(//td[@class='dvtCellInfo']/select)[3]/option[@value='Prospecting']")
	private WebElement salesStageProspectingClk;

	@FindBy(xpath = "(//td[@class='dvtCellInfo']/select)[3]/option[@value='Id. Decision Makers']")
	private WebElement salesStageIdDecisionMakersClk;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLnk;

	// rule 03:-Declare all the Web-Elements as private and Provide getters methods
	public WebElement getOpprunitynameEdt() {
		return opprunitynameEdt;
	}

	public WebElement getSelectLokupClk() {
		return selectLokupClk;
	}

	public WebElement getAmountClk() {
		return amountClk;
	}

	public WebElement getCalenderTextClk() {
		return calenderTextClk;
	}

	public WebElement getSalesStageProspectingClk() {
		return salesStageProspectingClk;
	}

	public WebElement getRelatedToContactclk() {
		return relatedToContactclk;
	}

	public WebElement getRelatedToClk() {
		return relatedToClk;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getAssigntoUserDropdown() {
		return assigntoUserDropdown;
	}

	public WebElement getAssigntoGroupDropdown() {
		return assigntoGroupDropdown;
	}

	public WebElement getCalenderLookupclk() {
		return calenderLookupclk;
	}

	WebElement getCurrentDateclk() {
		return currentDateclk;
	}

	public WebElement getSalesStageClk() {
		return salesStageProspectingClk;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;

	}

	public WebElement getClaenderTextClk() {
		return calenderTextClk;
	}

	public WebElement getSalesStageIdDecisionMakersClk() {
		return salesStageIdDecisionMakersClk;
	}

	public WebElement getTypeselect() {
		return typeselect;
	}

	public WebElement getLeadsourceselect() {
		return leadsourceselect;
	}

	public WebElement getSelectsalesstages() {
		return selectsalesstages;
	}

	// rule 05:- Access the WebElements using getter()/ business logic
	/**
	 * This method will create opportunity with modType
	 * 
	 * @param relatedTo
	 * @param modType
	 */
	public void RelatedTo() {
		relatedToClk.click();

	}

	/**
	 * This method is for RelatedToContact
	 * 
	 * @param modType
	 */
	public void RelatedToContact(String modType) {
		relatedToContactclk.click();

	}

	/**
	 * Thi method is for Select LookUp
	 */

	public void SelectLookUp() {
		selectLokupClk.click();
	}

	/**
	 * This method is to save Create Opportunity WebPage
	 */
	public void Savebtn() {
		savebtn.click();
	}

	/**
	 * This method is to click on Administrator
	 */

	public void AdministratorImg() {
		administratorImg.click();
	}

	/**
	 * This method is to handle Calender
	 */
	public void CalenderLookup() {
		calenderLookupclk.click();
	}

	public void currentDate(String modifiedDate) {
		currentDateclk.sendKeys(modifiedDate, Keys.ESCAPE);
	}

	public void SalesStage() {
		salesStageProspectingClk.click();
		// savebtn.click();
	}

	public void SalesStageIdDecision() {
		salesStageIdDecisionMakersClk.click();
	}

	public void SignoutLnk() {
		signoutLnk.click();
	}

	public void selectLeadsource(String LeadSource) {
		leadsourceselect.sendKeys(LeadSource);
	}

	public void selectSalesStages(String salesStages) {
		selectsalesstages.sendKeys(salesStages);
	}

	public void clickCalender(String date) throws InterruptedException {
		calenderTextClk.clear();
		calenderTextClk.sendKeys(date);
	}

	public void createopprunity(String opportunityName) {
		opprunitynameEdt.sendKeys(opportunityName);
	}

	public void selectType(String OpportunityType) {
		typeselect.sendKeys(OpportunityType);
	}

	public void assigntoUserDropdown() {
		assigntoUserDropdown.click();
	}

	public void enterAmount(String amount) {
		amountClk.sendKeys(amount);
		savebtn.click();
	}

	public void createOpportunitywithData(String OpportunitytName, String OpportunityType, String salesStages,
			String LeadSource) {
		opprunitynameEdt.sendKeys(OpportunitytName);
		//relatedToContactclk.click();
		typeselect.sendKeys(OpportunityType);
		selectsalesstages.sendKeys(salesStages);
		leadsourceselect.sendKeys(LeadSource);
		savebtn.click();
	}

}
