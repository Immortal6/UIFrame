package com.first.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestngRetry implements IRetryAnalyzer{
	private static int maxRetryCount = 2;
	private int retryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<=maxRetryCount){
			retryCount++;
			return true;
		}
		return false;
	}
}
