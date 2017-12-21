package com.ss.test;

import java.lang.reflect.Method;

public class RunAnno {

	public static void main(String[] args) throws Exception {
		TestAnno ta = new TestAnno();
		Method method = TestAnno.class.getDeclaredMethod("sayHi");
		RunTime rt = method.getAnnotation(RunTime.class);
		int count = rt.count();
		for(int i=0;i<count;i++) {
			method.invoke(ta);
		}
	}

}
