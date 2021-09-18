package practice;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.JSONFileUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;

public class RemoteExecution {
	@Test
	public void remoteExecution() throws Throwable {

		// read all the necessary data
		JSONFileUtility jsonLib = new JSONFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();

		String URL = jsonLib.readDataFromJSON("url");
		String BROWSER = jsonLib.readDataFromJSON("browser");
		String USERNAME = jsonLib.readDataFromJSON("username");
		String PASSWORD = jsonLib.readDataFromJSON("password");
		String HOMEPAGE = eLib.getExcelData("testCase", 6, 5);
		String LEADPAGE = eLib.getExcelData("testCase", 7, 5);
		String CREATELEADPAGE = eLib.getExcelData("testCase", 7, 6);
		URL url = new URL("http://192.168.1.21:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BROWSER);
		cap.setPlatform(Platform.WINDOWS);

		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get(URL);
		System.out.println("browser launch successfully");
		System.out.println("=======Actual Results of TC_01_NavigateToLeadPageTest==============");
		System.out.println("1.=> Login page is displaying");

		// Home page should be display
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.login(USERNAME, PASSWORD);
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

		// logout
		hp.signOut(driver);

		// close Browser
		wLib.closeBrowser(driver);

	}
}
