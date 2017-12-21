package com.ss.test;

public class Demo8 {

	public static void main(String[] args) {
		String str = "a,b,,,,f";
		String[] strs = str.split(",");
		//System.out.println(strs[2].equals(""));
		for(int i=0;i<strs.length;i++) {
			System.out.println(strs[i]);
		}
	}

}
