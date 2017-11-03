package com.revature.question18;

public class Question18Sub extends Question18Super {

	public Question18Sub() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean uppercase(String s) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isUpperCase(c)) {
				return true;	
			}
		}
		return false;
	}
	
	@Override
	public String lowercaseString(String s) {
		String s2 = "";
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLowerCase(s.charAt(i))) {
				c = Character.toUpperCase(s.charAt(i));
				s2 += c;
			} else {
				s2 += c;
			}
		}
		return s2;
	}

	@Override
	public int convertString(String s) {
		int result = Integer.parseInt(s);
		result += 10;
		return result;
	}

}
