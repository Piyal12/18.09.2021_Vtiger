package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class CreateLeadsPage extends WebDriverUtility {
	WebDriver driver;

	public CreateLeadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "button")
	private WebElement saveBtn;

	@FindBy(xpath = "//span[text()='Creating New Lead']")
	private WebElement createNewLeadPage;

	@FindBy(name = "salutationtype")
	private WebElement firstNameTitle;

	@FindBy(name = "firstname")
	private WebElement firstNameEdt;

	@FindBy(name = "lastname")
	private WebElement lastnameEdt;

	@FindBy(name = "company")
	private WebElement companynameEdt;

	@FindBy(id = "designation")
	private WebElement titleEdt;

	@FindBy(name = "leadsource")
	private WebElement leadSrcDrpDwn;

	@FindBy(name = "industry")
	private WebElement industryDrpDwn;

	@FindBy(name = "leadstatus")
	private WebElement leadStatusDrpDwn;

	@FindBy(name = "rating")
	private WebElement ratingDrpDwn;

	@FindBy(name = "annualrevenue")
	private WebElement annualrvnEdt;

	@FindBy(id = "noofemployees")
	private WebElement noOfEmpEdt;

	@FindBy(id = "secondaryemail")
	private WebElement secEmailEdt;

	@FindBy(id = "phone")
	private WebElement phnEdt;

	@FindBy(id = "mobile")
	private WebElement mobileEdt;

	@FindBy(id = "fax")
	private WebElement faxEdt;

	@FindBy(id = "email")
	private WebElement emailEdt;

	@FindBy(name = "website")
	private WebElement websiteEdt;

	@FindBy(name = "lane")
	private WebElement streetEdt;

	@FindBy(id = "pobox")
	private WebElement poBoxEdt;

	@FindBy(id = "code")
	private WebElement postalCodeEdt;

	@FindBy(id = "city")
	private WebElement cityEdt;

	@FindBy(id = "country")
	private WebElement countryEdt;

	@FindBy(id = "state")
	private WebElement stateEdt;

	@FindBy(name = "description")
	private WebElement descrptnEdt;

	// provide getters

	public WebElement getCreateNewLeadPage() {
		return createNewLeadPage;
	}

	public WebElement getLeadSrcDrpDwn() {
		return leadSrcDrpDwn;
	}

	public WebElement getIndustryDrpDwn() {
		return industryDrpDwn;
	}

	public WebElement getLeadStatusDrpDwn() {
		return leadStatusDrpDwn;
	}

	public WebElement getRatingDrpDwn() {
		return ratingDrpDwn;
	}

	public WebElement getFirstNameTitle() {
		return firstNameTitle;
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getCompanynameEdt() {
		return companynameEdt;
	}

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getAnnualrvnEdt() {
		return annualrvnEdt;
	}

	public WebElement getNoOfEmpEdt() {
		return noOfEmpEdt;
	}

	public WebElement getSecEmailEdt() {
		return secEmailEdt;
	}

	public WebElement getPhnEdt() {
		return phnEdt;
	}

	public WebElement getMobileEdt() {
		return mobileEdt;
	}

	public WebElement getFaxEdt() {
		return faxEdt;
	}

	public WebElement getEmailEdt() {
		return emailEdt;
	}

	public WebElement getWebsiteEdt() {
		return websiteEdt;
	}

	public WebElement getStreetEdt() {
		return streetEdt;
	}

	public WebElement getPoBoxEdt() {
		return poBoxEdt;
	}

	public WebElement getPostalCodeEdt() {
		return postalCodeEdt;
	}

	public WebElement getCityEdt() {
		return cityEdt;
	}

	public WebElement getCountryEdt() {
		return countryEdt;
	}

	public WebElement getStateEdt() {
		return stateEdt;
	}

	public WebElement getDescrptnEdt() {
		return descrptnEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// business method
	public String createNewLeadPageText() {
		return createNewLeadPage.getText();
	}

	public void leadInformation(String firstname, String lastname, String company, String title, String value,
			String noofemp, String secemail, String phnNo, String mobileNo, String fax, String emailNo, String website,
			String street, String pobox, String pcode, String city, String country, String state, String des) {
		select(firstNameTitle, "Mr.");
		getFirstNameEdt().sendKeys(firstname);
		getLastnameEdt().sendKeys(lastname);
		getCompanynameEdt().sendKeys(company);
		getTitleEdt().sendKeys(title);
		select(leadSrcDrpDwn, "Trade Show");
		select(leadStatusDrpDwn, "Contacted");
		select(industryDrpDwn, "Manufacturing");
		select(ratingDrpDwn, "Active");
		getAnnualrvnEdt().sendKeys(value);
		getNoOfEmpEdt().sendKeys(noofemp);
		getSecEmailEdt().sendKeys(secemail);
		getPhnEdt().sendKeys(phnNo);
		getMobileEdt().sendKeys(mobileNo);
		getFaxEdt().sendKeys(fax);
		getEmailEdt().sendKeys(emailNo);
		getWebsiteEdt().sendKeys(website);
		getStreetEdt().sendKeys(street);
		getPoBoxEdt().sendKeys(pobox);
		getPostalCodeEdt().sendKeys(pcode);
		getCityEdt().sendKeys(city);
		getCountryEdt().sendKeys(country);
		getStateEdt().sendKeys(state);
		getDescrptnEdt().sendKeys(des);

	}

	public void exceptMandatoryleadInformation(String firstname, String title, String value, String noofemp,
			String secemail, String phnNo, String mobileNo, String fax, String emailNo, String website, String street,
			String pobox, String pcode, String city, String country, String state, String des) {
		select(firstNameTitle, "Mr.");
		getFirstNameEdt().sendKeys(firstname);
		getTitleEdt().sendKeys(title);
		select(leadSrcDrpDwn, "Trade Show");
		select(leadStatusDrpDwn, "Contacted");
		select(industryDrpDwn, "Manufacturing");
		select(ratingDrpDwn, "Active");
		getAnnualrvnEdt().sendKeys(value);
		getNoOfEmpEdt().sendKeys(noofemp);
		getSecEmailEdt().sendKeys(secemail);
		getPhnEdt().sendKeys(phnNo);
		getMobileEdt().sendKeys(mobileNo);
		getFaxEdt().sendKeys(fax);
		getEmailEdt().sendKeys(emailNo);
		getWebsiteEdt().sendKeys(website);
		getStreetEdt().sendKeys(street);
		getPoBoxEdt().sendKeys(pobox);
		getPostalCodeEdt().sendKeys(pcode);
		getCityEdt().sendKeys(city);
		getCountryEdt().sendKeys(country);
		getStateEdt().sendKeys(state);
		getDescrptnEdt().sendKeys(des);

	}

	public void mandatryLeadInformation(String lastname, String company) {
		getLastnameEdt().sendKeys(lastname);
		getCompanynameEdt().sendKeys(company);
	}

	public void clickOnSaveButton() {
		getSaveBtn().click();
	}

	public String fetchAlertMsg(WebDriver driver) {
		return fetchAlert(driver);
	}

	public void acceptAlertMsg(WebDriver driver) {
		acceptAlert(driver);
	}

	public void createLeadWithIndustry(String LastName, String Company, String IndustryType) {
		lastnameEdt.sendKeys(LastName);
		companynameEdt.sendKeys(Company);
		select(industryDrpDwn, IndustryType);
		saveBtn.click();
	}

}
