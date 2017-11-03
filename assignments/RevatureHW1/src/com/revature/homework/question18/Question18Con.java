package com.revature.homework.question18;

public class Question18Con extends Question18Abs {

	@Override
	public boolean checkUppercase(String str) {
		
		boolean hasUppercase = !str.equals(str.toLowerCase());
		return hasUppercase;
	}

	@Override
	public String convertLowerToUpper(String str) {
		// make all lower case upper
		return str.toUpperCase();
	}

	@Override
	public int convertStringToInt(String str) {
		return str.hashCode()+10;
	}


}
