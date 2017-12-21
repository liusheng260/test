package com.ss.ecshop.data;

import org.testng.annotations.DataProvider;

import com.ss.framework.utils.ReadExcel;

public class TestDataFactory{
	@DataProvider(name="loginTestData")
	public static Object[][] getLoginTestData(){
		/*
		return new Object[][] {
			{"ss01","123456","登录成功"},
			{"ss01","111111","用户名或密码错误"},
			{"ss","111111","用户名或密码错误"},
			{"","123456","用户名不能为空"},
			{"ss01","","登录密码不能为空"},
		};
		*/
		return ReadExcel.getDataFromExcel("loginTestData.xlsx", "Sheet1");
	}
	@DataProvider(name="registerTestData_tips")
	public static Object[][] getregisterTestData_tips(){
		Object[][] object = ReadExcel.getDataFromExcel("registerTestData.xlsx", "Sheet1");
		return object;
	}
	
	@DataProvider(name="registerTestData_success")
	public static Object[][] getregisterTestData_success(){
		return ReadExcel.getDataFromExcel("registerTestData.xlsx", "Sheet2");
	}
}
