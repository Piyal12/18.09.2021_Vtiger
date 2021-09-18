package com.crm.AutoDesk.LeadsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsInfoPage;
import com.crm.autodesk.elementRepository.LeadsPage;
import com.crm.comcast.GenericUtility.BaseClass;

@Listeners(com.crm.comcast.GenericUtility.ListnerS.class)
public class CreateLeadWithMultipleData extends BaseClass {
	@DataProvider
	public Object[][] getData() throws Throwable, IOException {
		return eLib.getExcelData("Sheet2");
	}

	@Test(dataProvider = "getData", retryAnalyzer = com.crm.comcast.GenericUtility.RetryAnalyzer.class)
	public void createLeadWithMultipleData(String lastName, String company, String industryType) {

		// navigate to Lead
		HomePage hp = new HomePage(driver);
		hp.clickOnLeads();

		// click on create Leads
		LeadsPage ldp = new LeadsPage(driver);
		ldp.clickOnCreateLeadImg();

		// create Leads
		CreateLeadsPage clp = new CreateLeadsPage(driver);
		clp.createLeadWithIndustry(lastName, company, industryType);

		// Validation
		LeadsInfoPage leadIn = new LeadsInfoPage(driver);
		String actuallastName = leadIn.lastNameInfo();
		Assert.assertTrue(actuallastName.contains(lastName));
		Assert.assertEquals(false, true);
		System.out.println(actuallastName);
		System.out.println(lastName);

		String actualcompany = leadIn.companyNameInfo();
		Assert.assertTrue(actualcompany.contains(company));

		System.out.println(actualcompany);
		System.out.println(company);

		String actualindustry = leadIn.industryInfo();
		Assert.assertTrue(actualindustry.contains(industryType));
		System.out.println(actualindustry);
		System.out.println(industryType);

	}
}
