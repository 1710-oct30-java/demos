package com.revature.Homework1.Q13;

public class Q13 {
	public static void main(String[] args) {
		
		String prevString = "0";
		
		//place number on left side or right
		//initial 0 is on the 'right' of nothing
		boolean right = false;
		int n = 1;
		
		System.out.println(prevString);
		
		for(int i = 0; i<3; i++) {
			if(right) {
				prevString = prevString+" "+n;
				right = false;
			}else {
				prevString = n+" "+prevString;
				right = true;
			}
			if(prevString.charAt(0) == prevString.charAt(prevString.length()-1)) {
				if(n == 0) {n = 1;}
				else {n= 0;}
			}
			System.out.println(prevString);
		}
	}
}
