package com.homeworkOne.problemThirteen;

public class ProblemThirteen {
//Print a triangle using numbers
	public static void main(String[] args) {
		String printNumber = "0";
		int counter = 0;
		for(int i = 0;i<4;i++)
		{
			System.out.println(printNumber);
			switch(counter) {
			case 0:
				printNumber = "10";
				counter++;
				break;
			case 1:
				printNumber = "101";
				counter++;
				break;
			case 2:
				printNumber = "0101";
				break;
			}
			
		}
	}
}
