package com.revature.strings;

public class BuilderBuffer {
	public static void main(String[] args) {
		StringBuilder sbr = new StringBuilder("hello");
		sbr.append(" world!!!");
		System.out.println(sbr);
		
		StringBuffer sbuff = new StringBuffer("hello");
		sbuff.append(" world!!!");
		System.out.println(sbuff);
	}
}
