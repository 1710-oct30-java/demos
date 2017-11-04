package com.revature.question5;

public class Question5 {

	public static String subStringMethod(String str, int idx) {

		String newStr = "";

		for (int i = 0; i < idx; i++) {
			newStr = newStr + str.charAt(i);
		}

		return newStr;
	}

	public static void main(String[] args) {

		String testString = "Will work for Bitcoin";
		int strMaxIndex = 9;

		System.out.println(subStringMethod(testString, strMaxIndex));
	}
}
