package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;

	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;

	@FindBy(xpath = "//td[contains(@onmouseover,'mail.com')]/img")
	private WebElement adminIconLnk;

	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLnk;

	@FindBy(linkText = "Products")
	private WebElement productsLnk;

	@FindBy(linkText = "Email")
	private WebElement emailLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;

	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement homePageLnk;

	// Generate Getters

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getAdministratorImg() {
		return adminIconLnk;
	}

	public WebElement getSignoutLnk() {
		return signOutLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	// provide business logic
	public void clickOnLeads() {
		leadsLnk.click();
	}

	public void signOut(WebDriver driver) {

		mouseOverMovetoElement(driver, adminIconLnk);
		signOutLnk.click();
	}

	public String homeLnk() {
		return homePageLnk.getText();
	}

}
