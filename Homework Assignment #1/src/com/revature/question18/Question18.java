package com.revature.question18;
//Robert Choboy
//Write a program having a concrete subclass that inherits three abstract methods from a superclass. Provide the following three implementations
//in the superclass:
//1. Return true or false if uppercase letters are found in the string.
//2. Convert all of the lower case characters to uppercase in the input string and return the result
//3. Convert the input string to integer and add 10, output the results to the console.

abstract class Question18 {
   
	abstract boolean upperCheck(String i);
	abstract String returnCheck(String j);
	abstract int stringToInt(String k);
	
}
  class SubClass<Array> extends Question18

{
	@Override
	boolean upperCheck(String i) {
		char[] ary = i.toCharArray();
		for (int a = 0; a<ary.length; a++)
		{
			char ch = ary[a];
			if (Character.isUpperCase(ch))
			{ 
				return true;
			}
		}
		return false;
		
	}
	
	
	@Override
	String returnCheck(String i) {
		char[] ary = i.toCharArray();
		char[] newAry = new char [ary.length];
		for (int a = 0; a<ary.length; a++)
		{
			char ch = ary [a];
			for (int b = 0; b<ary.length; b++)
			{
			char chNew = Character.toUpperCase(ch);
			}
		}
		
			String j = new String(newAry);
			return j;
			
			}
		@Override
		
	int stringToInt(String i) throws NumberFormatException{
		int result = Integer.valueOf(i);
				return result+10;
		
	}
			
			
		
	}
