package com.revature.question18;
/*
 * Write a program having a concrete subclass that inherits three
 * abstract methods from a superclass. Provide the following three implementations
 * in the subclass corresponding to the abstract methods in the superclass:
 * 
 * 1. Check for uppercase characters in a string, and return 'true' or 'false'
 * 	  depending if any are found
 * 2. Convert all of the lower case characters to uppercase in the input string, and
 * return the result
 * 3. Convert the input string to integer and add 10, output the result to the console
 */

//subclass implements the abstract methods that it inherited from the parent class
public class Subclass extends Question18{

	@Override
	public boolean firstMethod(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String secondMethod(String str) {
		char[] array = str.toCharArray();
		for(int i = 0; i < array.length; i++) {
			char c = array[i];
			//if the character is lower case convert it to uppercase in the input string,
			//the character is either lower case or uppercase if all of the lower case are 
			//changed to uppercase then the whole is string is upper case
			if(Character.isLowerCase(c)) {
				////Character.toUpperCase(str.charAt(i));
				//array[i] = Character.toUpperCase(array[i]);
				str = str.toUpperCase();
				break;
			}
		}
		return str;
	}

	@Override
	public void thirdMethod(String str) {
		int stringValue = Integer.parseInt(str); //convert string to int
		//System.out.println(stringValue);
		System.out.println(stringValue + 10); //output the value of the string plus 10
	}
	
}
