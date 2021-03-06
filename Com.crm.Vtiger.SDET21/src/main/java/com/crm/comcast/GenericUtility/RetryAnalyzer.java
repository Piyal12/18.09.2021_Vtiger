package com.crm.comcast.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int count = 0;
	int retryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		while (count < retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
