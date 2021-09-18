package com.crm.comcast.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListnerS implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + "is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName() + "is Failed");
		BaseClass baseclass = new BaseClass();
		try {
			String path = baseclass.getscreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName() + "is SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/ExtentReportsSDET21/ExtentReports1.html");

		reporter.config().setDocumentTitle("SDET21");
		reports = new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("BuildNO", "5.1");
		reports.setSystemInfo("Env", "Pre-Prod");
		reports.setSystemInfo("Platform", "Windows");
		reports.setSystemInfo("Browser Version", "Chrome 93");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
