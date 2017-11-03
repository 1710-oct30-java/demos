package com.revature.Homework1.Q8;

import java.util.ArrayList;

public class Q8 {
	public static void main(String[] args) {
		String[] strings = {"karan","madam","tom","civic",
				"radar","sexes","jimmy","kayak","john",
				"refer","billy","did"};
		ArrayList<String> palindromes = new ArrayList<String>();
		ArrayList<String> otherStrings = new ArrayList<String>();
		
		for(int i = 0; i < strings.length;i++) {
			if(isPalindrome(strings[i])) {
				palindromes.add(strings[i]);
			}else {
				otherStrings.add(strings[i]);
			}
		}
		System.out.println("Palindromes:");
		for(int i = 0; i < palindromes.size(); i++) {
			System.out.println(palindromes.get(i));
		}
		System.out.println("\n\nOther Strings:");
		for(int i = 0; i < otherStrings.size(); i++) {
			System.out.println(otherStrings.get(i));
		}
		
		
	}
	static boolean isPalindrome(String in) {
		for(int i = 0; i < in.length()/2;i++) {
			if(in.charAt(i) != in.charAt(in.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
