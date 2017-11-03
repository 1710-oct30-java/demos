package com.revature.question18;

public class Question18Launcher {

	public static void main(String[] args) {
		Subclass test = new Subclass();
		//using the methods and outputting results
		System.out.println("First Method: " + test.firstMethod("hello"));
		System.out.println("Second Method: " + test.secondMethod("hellO"));
		System.out.print("Third Method: " );
		test.thirdMethod("10");

	}

}
