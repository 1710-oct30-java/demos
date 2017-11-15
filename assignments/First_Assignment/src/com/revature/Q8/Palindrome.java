package com.revature.Q8;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
	public static void main(String[] args) {
		List<String> notPalindrome = new ArrayList<String>();
		List<String> palindrome = new ArrayList<String>();
		String s = "";
		s.substring(0);
		
		notPalindrome.add("karan");
		notPalindrome.add("madam");
		notPalindrome.add("tom");
		notPalindrome.add("civic");
		notPalindrome.add("radar");
		notPalindrome.add("sexes");
		notPalindrome.add("jimmy");
		notPalindrome.add("kayak");
		notPalindrome.add("john");
		notPalindrome.add("refer");
		notPalindrome.add("billy");
		notPalindrome.add("did");
		
		for(int i = 0; i < notPalindrome.size(); i++) {
			s = new StringBuilder(notPalindrome.get(i)).reverse().toString();
			if(s.equals(notPalindrome.get(i))) {
				palindrome.add(notPalindrome.get(i));
			}
		}
		System.out.println(palindrome);
	}
}
