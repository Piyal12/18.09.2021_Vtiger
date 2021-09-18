package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	public OrganizationsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// Locate all elements
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImgLnk;

	@FindBy(name = "search_text")
	private WebElement searchEdt;

	@FindBy(name = "submit")
	private WebElement submitBtn;

	// //provide getters

	public WebElement getCreateOrgImgLnk() {
		return createOrgImgLnk;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	// provide business methods

	public void clickOnCreateOrgImg() {
		createOrgImgLnk.click();
	}

}
