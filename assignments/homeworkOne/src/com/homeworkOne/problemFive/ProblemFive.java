package com.homeworkOne.problemFive;

public class ProblemFive {
	
	//Write a substring method
	public static void main(String[] args) {
		
		//Init variables
		String str = "problemfive";
		int idx = 5;
		subString(str,idx);
	}
	
	//substring method
	public static void subString(String string, int index)
	{
		//create char array to hold substring
		char[] newString = new char[index+1];
		
		//perform operation
		for(int i = 0; i<index; i++)
		{
			newString[i] = string.charAt(i);
		}
		
		//print result
		System.out.println(newString);
	}

}
