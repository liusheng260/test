package com.ss.test071210;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.println("F");
	}
	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.println(".");
	}
}
