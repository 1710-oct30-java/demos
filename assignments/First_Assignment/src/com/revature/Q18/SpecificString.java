package com.revature.Q18;

public class SpecificString extends GeneralString {
	
	public boolean checkCase(String s) {
		if(s.equals(s.toLowerCase())) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public String setCase(String s) {
		s = s.toUpperCase();
		return s;
	}
	
	public int convert(String s) {
		int x = Integer.parseInt(s) + 10;
		return x;
	}
	
	public static void main(String[] args) {
		
		SpecificString testString = new SpecificString();
		
		System.out.println(testString.checkCase("Hello World"));
		System.out.println(testString.checkCase("hi world"));
		System.out.println(testString.setCase("lower case is for the lower class"));
		System.out.println(testString.convert("45"));
	}
}
