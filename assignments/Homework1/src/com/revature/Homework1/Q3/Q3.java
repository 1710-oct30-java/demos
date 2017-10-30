package com.revature.Homework1.Q3;

public class Q3 {
//reverse string without temp variable( and other stuff)
	public static void main(String[] args) {
		String myString = "I think this is hard";
		for(int i = 0; i < myString.length()/2; i++) {
			/* 
			 * swap chars
			 * chars a,b are some char value
			 * a = a + b
			 * b = a - b; b is now the original a
			 * a = a - b; a is now the original b
			 * 
			 * the crazy substring stuff below is just a way to change one index of the string at a time
			 * it follows the same basic pattern as above
			 */
			myString = myString.substring(0,i)+ (char) (myString.charAt(i) + myString.charAt(myString.length()-1-i))+myString.substring(i+1,myString.length());
			myString = myString.substring(0,myString.length()-1-i)+ (char) (myString.charAt(i) - myString.charAt(myString.length()-1-i))+myString.substring(myString.length()-i,myString.length());//old char at 0
			myString = myString.substring(0,i)+ (char) (myString.charAt(i) - myString.charAt(myString.length()-1-i))+myString.substring(i+1,myString.length());//old char at end
		}
		System.out.println(myString);

	}

}
