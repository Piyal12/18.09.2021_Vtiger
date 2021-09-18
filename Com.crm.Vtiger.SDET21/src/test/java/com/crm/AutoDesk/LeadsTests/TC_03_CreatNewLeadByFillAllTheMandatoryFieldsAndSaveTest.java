package com.crm.AutoDesk.LeadsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsInfoPage;
import com.crm.autodesk.elementRepository.LeadsPage;
import com.crm.comcast.GenericUtility.BaseClass;

public class TC_03_CreatNewLeadByFillAllTheMandatoryFieldsAndSaveTest extends BaseClass {

	@Test(groups = "RegressionSuite", retryAnalyzer = com.crm.comcast.GenericUtility.RetryAnalyzer.class)
	public void CreatNewLeadByFillAllTheMandatoryFieldsAndSave() throws Throwable {

		// read all the necessary data

		String HOMEPAGE = eLib.getExcelData("testCase", 6, 5);
		String LEADPAGE = eLib.getExcelData("testCase", 7, 5);
		String CREATELEADPAGE = eLib.getExcelData("testCase", 7, 6);

		String LASTNAME = eLib.getExcelData("testCase", 16, 6);
		String COMPANY = eLib.getExcelData("testCase", 17, 6);

		// Home page should be display
		HomePage hp = new HomePage(driver);

		// Validation
		Assert.assertTrue(hp.homeLnk().equals(HOMEPAGE));
		// System.out.println(hp.homeLnk());
		System.out.println("2.=> Home page dispalyed");

		// Click on "Lead" then click on "Create Lead " Image.
		hp.clickOnLeads();
		LeadsPage ldp = new LeadsPage(driver);
		// Validation
		Assert.assertTrue(ldp.leadLnk().equals(LEADPAGE));
		// System.out.println(ldp.leadLnk());
		System.out.println("2.1.=> Leads page dispalyed");

		ldp.clickOnCreateLeadImg();
		CreateLeadsPage clp = new CreateLeadsPage(driver);
		// Validation
		Assert.assertTrue(clp.createNewLeadPageText().equals(CREATELEADPAGE));
		// System.out.println(clp.createNewLeadPageText());
		System.out.println("3.=> CreatNewLead page is displaying");

		// Fill all Lead Information
		clp.mandatryLeadInformation(LASTNAME, COMPANY);

		// click on save button
		clp.clickOnSaveButton();

		// take the auto generated lead number
		LeadsInfoPage lip = new LeadsInfoPage(driver);
		String UNIQUELEADNO = lip.UniqueLeadNo();

		// Again click on "Lead"
		hp.clickOnLeads();

		// put the auto generated lead number in search for text box
		ldp.clickOnSearchFor(UNIQUELEADNO);

		// click on search now button
		ldp.clickOnSearchNow(driver);
		Thread.sleep(1000);
		// fetch unique Lead No
		System.out.println("4. " + ldp.leadNoInfoInLeadMainPage() + " unique Lead No generated");

	}
}
