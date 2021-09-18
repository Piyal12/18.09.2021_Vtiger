package com.crm.AutoDesk.LeadsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;
import com.crm.comcast.GenericUtility.BaseClass;

public class TC_05_CreatNewLeadByKeepAllTheMandatoryFieldBlankAndSaveTest extends BaseClass {

	@Test(groups = "RegressionSuite", retryAnalyzer = com.crm.comcast.GenericUtility.RetryAnalyzer.class)
	public void CreatNewLeadByKeepAllTheMandatoryFieldBlankAndSave() throws Throwable {

		// read all the necessary data

		String HOMEPAGE = eLib.getExcelData("testCase", 6, 5);
		String LEADPAGE = eLib.getExcelData("testCase", 7, 5);
		String CREATELEADPAGE = eLib.getExcelData("testCase", 7, 6);
		String ACTUALERRMSG = eLib.getExcelData("testCase", 43, 6);
		String FIRSTNAME = eLib.getExcelData("testCase", 15, 6);
		String TITLE = eLib.getExcelData("testCase", 18, 6);
		String VALUE = eLib.getExcelData("testCase", 19, 6);
		String NOOFEMP = eLib.getExcelData("testCase", 20, 6);
		String SECEMAIL = eLib.getExcelData("testCase", 21, 6);
		String PHNNO = eLib.getExcelData("testCase", 22, 6);
		String MOBILENO = eLib.getExcelData("testCase", 23, 6);
		String FAX = eLib.getExcelData("testCase", 24, 6);
		String EMAILNO = eLib.getExcelData("testCase", 25, 6);
		String WEBSITE = eLib.getExcelData("testCase", 26, 6);
		String STREET = eLib.getExcelData("testCase", 27, 6);
		String POBOX = eLib.getExcelData("testCase", 28, 6);
		String PCODE = eLib.getExcelData("testCase", 29, 6);
		String CITY = eLib.getExcelData("testCase", 30, 6);
		String COUNTRY = eLib.getExcelData("testCase", 31, 6);
		String STATE = eLib.getExcelData("testCase", 32, 6);
		String DES = eLib.getExcelData("testCase", 33, 6);

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
		clp.exceptMandatoryleadInformation(FIRSTNAME, TITLE, VALUE, NOOFEMP, SECEMAIL, PHNNO, MOBILENO, FAX, EMAILNO,
				WEBSITE, STREET, POBOX, PCODE, CITY, COUNTRY, STATE, DES);

		// click on save By Keep All The Mandatory Field Blank And Save
		clp.clickOnSaveButton();

		// display Alert
		String expectedErrMsg = clp.fetchAlert(driver);
		System.out.println("\"" + expectedErrMsg + "\"" + " is displaying");
		// Alert msg validation
		Assert.assertTrue(expectedErrMsg.equals(ACTUALERRMSG));

		// accept alert
		clp.acceptAlertMsg(driver);

	}
}
