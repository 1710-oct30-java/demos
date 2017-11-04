package com.revature.question18;

public class StringUtils extends StringUtilsAbstract {

	@Override
	public void checkUpperCase(String s) {
		
		// Convert the string to a charArray
		// to perform the methods
		char[] charArray = s.toCharArray();
		for (char ch : s.toCharArray()) {
			if(!Character.isUpperCase(ch))
				return false;
		}
		return true;
	}
	
	@Override
	public void goToUpperCase(String s) {
		String str = s.toUpperCase();
		
	}
	
	@Override
	public void add10(String s) {
		s += 10;
	}
}
