package com.ss.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo1 {
	@BeforeSuite
	public void beforeSuiteM() {
		System.out.println("....Before Suite....");
	}
	@AfterSuite
	public void afterSuiteM() {
		System.out.println("....After Suite....");
	}
	@BeforeTest
	public void beforeTestM() {
		System.out.println("....Before Test1....");
	}
	@AfterTest
	public void afterTestM() {
		System.out.println("....After Test1....");
	}
	@BeforeClass
	public void beforeClassM() {
		System.out.println("....Before Class1....");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("....After Class1....");
	}
	@BeforeMethod
	public void beforeMethodM() {
		System.out.println("....Before Method1....");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("....After Method1....");
	}
	@Test
	public void myTest1Func() {
		System.out.println("....testmethod ----  myTest1Func");
	}
	//enabled=false 表示该测试用例暂时不执行
	@Test(enabled=false)
	public void myTest2Func() {
		System.out.println("....testmethod ----  myTest2Func");
	}
	//dependsOnMethods= {"myTest1Func"} 依赖上一个成功后才可以执行，依赖会导致执行顺序发生改变
	@Test(dependsOnMethods= {"myTest1Func"})
	public void myTest3Func() {
		System.out.println("....testmethod ----  myTest3Func");
	}
}
