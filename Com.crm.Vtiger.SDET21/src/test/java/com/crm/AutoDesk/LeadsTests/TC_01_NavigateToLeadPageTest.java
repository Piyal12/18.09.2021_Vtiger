package com.crm.AutoDesk.LeadsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;
import com.crm.comcast.GenericUtility.BaseClass;

public class TC_01_NavigateToLeadPageTest extends BaseClass {

	@Test(groups = "SmokeSuite", retryAnalyzer = com.crm.comcast.GenericUtility.RetryAnalyzer.class)
	public void NavigateToLeadPageTest() throws Throwable {
		// Read the data from excel
		String HOMEPAGE = eLib.getExcelData("testCase", 6, 5);
		String LEADPAGE = eLib.getExcelData("testCase", 7, 5);
		String CREATELEADPAGE = eLib.getExcelData("testCase", 7, 6);

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

	}
}
