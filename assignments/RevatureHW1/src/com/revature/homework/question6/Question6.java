package com.revature.homework.question6;
 // Determine if an integer is even without using modulus
public class Question6 {
	public static void main(String[] args) {
		int i =11;
		System.out.println(i+ " is an even number: " +isEven(i));
	}
	
	public static boolean isEven(int i) {
		// turn int into a double
		double d = (double)i;
		// divide it by 2
		d = d/2;
		// change from primitive to object
		Double div = new Double(d);
		// convert to string
		String str = div.toString();
		// check if string ends in ".5"
		// if so, false (odd); else its even (true)
		if (str.endsWith(".5")){
				return false;
		} else {
			return true;
		}
	}
}
