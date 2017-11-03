package com.revature.question8;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a program that stores the following strings in an ArrayList and saves 
 * all the palindromes in another ArrayList
 */
public class Question8 {

	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		List<String> palin = new ArrayList<String>();
		a.add("karan");
		a.add("madam");
		a.add("tom");
		a.add("civic");
		a.add("radar");
		a.add("sexes");
		a.add("jimmy");
		a.add("kayak");
		a.add("john");
		a.add("refer");
		a.add("billy");
		a.add("did");
		
		for (int i = 0; i < a.size(); i++) {
			String current = a.get(i);
			int len = current.length();
			for (int j = 0; j < len/2; j++) {
				if(current.charAt(j) != current.charAt(len - j - 1))
					break;
				else {
					palin.add(current);
					break;
				}
			}
		}
		
		System.out.println(palin);
			
		
		
		
		
	}

}
