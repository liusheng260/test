package com.ss.test;

public class TestAnno {
	public int a = 10;
	@RunTime(count=10)
	public void sayHi() {
		System.out.println("Hi");
	}
}
