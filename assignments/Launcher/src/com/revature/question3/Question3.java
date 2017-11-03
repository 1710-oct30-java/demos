package com.revature.question3;

public class Question3 {

	public static String reverse(String s) {
		
		char[] cArray = s.toCharArray();
		int startIndex = 0;
		int endIndex = cArray.length-1;
		char temp;
		
		while (startIndex < endIndex) {
			temp = cArray[startIndex];
			cArray[startIndex] = cArray[endIndex];
			cArray[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		return new String(cArray);
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("abcdefg"));
	}

}
