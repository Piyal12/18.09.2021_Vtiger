package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {
	// Constructor
	public LeadsInfoPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// locate webelements
	@FindBy(className = "dvHeaderText")
	private WebElement leadInfo;

	@FindBy(xpath = "//td[.='Lead No']/../td[4]")
	private WebElement uniqueLeadNo;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameInfo;

	@FindBy(id = "mouseArea_Company")
	private WebElement companyNameInfo;

	@FindBy(id = "mouseArea_Industry")
	private WebElement industryInfo;

	// provide getters
	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}

	public WebElement getCompanyNameInfo() {
		return companyNameInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getLeadInfo() {
		return leadInfo;
	}

	public WebElement getUniqueLeadNo() {
		return uniqueLeadNo;
	}

	// provide business methods
	/**
	 * get Lead Information
	 */

	public WebElement LeadInfo() {
		return leadInfo;
	}

	/**
	 * get unique lead No
	 */

	public String UniqueLeadNo() {
		return uniqueLeadNo.getText();
	}

	public String lastNameInfo() {
		return lastNameInfo.getText();
	}

	public String companyNameInfo() {
		return companyNameInfo.getText();
	}

	public String industryInfo() {
		return industryInfo.getText();
	}

}
