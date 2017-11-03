package com.revature.homework.question13;
// display a triangle on the console
public class Question13 {
	
	public static void main(String[] args) {
	
	// All lines can be substringed from this string
	String str = "0101";
	
	for (int i=0;i<5;i++) {
		
		// Substring that grows after each iteration
		String temp = str.substring(0, i);
		
		// prints the first and last line
		if (temp.length()==1 || temp.length()==4){
		System.out.println(temp);
		}
		
		// prints the 2nd and 3rd line
		else {
			System.out.println(str.substring(1, i+1));
		}
		
	}
}
}
