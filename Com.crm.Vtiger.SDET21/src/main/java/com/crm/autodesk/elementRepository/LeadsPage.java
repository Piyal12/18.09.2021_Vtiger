package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class LeadsPage extends WebDriverUtility {

	WebDriver driver;

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[title='Create Lead...']")
	private WebElement createLeadImgLnk;

	@FindBy(linkText = "Leads")
	private WebElement leadPageLnk;

	@FindBy(name = "search_text")
	private WebElement searchForText;

	@FindBy(css = "input[name='submit']")
	private WebElement searchNowBtn;

	@FindBy(name = "search_field")
	private WebElement searchInDrpDwnLnk;

	@FindBy(xpath = "//table[@class='lvtBg']/tbody/tr/td/div/table/tbody/tr[3]/td[2]")
	private WebElement leadNoInLeadMainPage;

	// provide getters

	public WebElement getSearchForLnk() {
		return searchForText;
	}

	public WebElement getSearchNowLnk() {
		return searchNowBtn;
	}

	public WebElement getSearchInDrpDwnLnk() {
		return searchInDrpDwnLnk;
	}

	public WebElement getCreateLeadImgLnk() {
		return createLeadImgLnk;
	}

	public WebElement getLeadPageLnk() {
		return leadPageLnk;
	}

	public WebElement getLeadNoInLeadMainPage() {
		return leadNoInLeadMainPage;
	}

	// Business Methods
	public void clickOnCreateLeadImg() {
		createLeadImgLnk.click();
	}

	public String leadLnk() {
		return leadPageLnk.getText();
	}

	public void clickOnSearchFor(String searchName) {
		searchForText.sendKeys(searchName);
	}

	public void clickOnSearchNow(WebDriver driver) {
		searchNowBtn.click();
	}

	public void selectFromSearchInDrpDwnMenu(String drpDwnMenuName) {
		select(searchInDrpDwnLnk, drpDwnMenuName);
	}

	public String leadNoInfoInLeadMainPage() {

		return leadNoInLeadMainPage.getText();
	}

}
