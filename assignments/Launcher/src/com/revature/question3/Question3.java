package com.revature.question3;

public class Question3 {

	public static String reverse(String s) {
		
		// convert the string to char array
		// and declare variables for the
		// start and end of the char array
		char[] cArray = s.toCharArray();
		int startIndex = 0;
		int endIndex = cArray.length-1;
		char temp;
		
		// swap the first and last indexes,
		// then the next-to-first and
		// next-to-last indexes, and so on
		while (startIndex < endIndex) {
			temp = cArray[startIndex];
			cArray[startIndex] = cArray[endIndex];
			cArray[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
		
		
		return new String(cArray);
	}
	
	//print out the reversed string
	public static void main(String[] args) {
		System.out.println(reverse("abcdefg"));
	}

}
