package com.homeworkOne.problemEighteen;

public class ProblemEighteenSubclass extends ProblemEighteen {

	public ProblemEighteenSubclass() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean upperCase(String word) {
		for(int i = 0; i<word.length();i++)
		{
			if(Character.isUpperCase(word.charAt(i)))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	String lowerToUpper(String word) {
		StringBuilder letter = new StringBuilder(word);
		//char[] letters = word.toCharArray();
		for(int i = 0; i<word.length();i++)
		{
			if(Character.isLowerCase(letter.charAt(i)))
				letter.setCharAt(i, Character.toUpperCase(letter.charAt(i)));
		}
		return letter.toString();
	}

	@Override
	void stringToInt(String word) {
		try {
			System.out.println(Integer.parseInt(word) + 10);
		
		}
		catch(Exception e){
			System.out.println(word + " is not a number");
		}
		
	}
	

}
