package com.homeworkOne.problemEighteen;

public class ProblemEighteenLauncher {
	public static void main(String[] args) {
		
		ProblemEighteenSubclass word = new ProblemEighteenSubclass();		
		System.out.println(word.upperCase("helLo"));
		System.out.println(word.lowerToUpper("hello"));
		word.stringToInt("10");
	}
	

}
