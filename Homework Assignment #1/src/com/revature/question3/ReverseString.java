package com.revature.question3;
//Robert L Choboy
//Revature Week 1 Assignment 1 Question #3
public class ReverseString {
	
	public static void main (String[]  args) {
		//Reverse the string
		String flip  = "BuffaloBills";
		System.out.println();
		for (int i = 0; i < flip.length(); i++) 
		{
		    flip = flip.substring(1, flip.length() - i)
		        + flip.substring(0, 1)
		        + flip.substring(flip.length() - i, flip.length());
		}
		//Display the string in reverse form 
		 System.out.println(flip);
	}

	
	}


