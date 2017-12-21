package com.ss.test;

import java.lang.reflect.Proxy;

public class RunProxyDemo {
	public static void main(String[] args) {
		ITestAnno ta = (ITestAnno)Proxy.newProxyInstance(
				ITestAnno.class.getClassLoader(), 
				new Class[] {ITestAnno.class}, 
				new TestAnnoInvocationHandler());
		ta.sayHi();
	}
}
