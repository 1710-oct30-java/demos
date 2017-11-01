package com.homeworkOne.problemSix;

public class ProblemSix {
	
	//Check if a number is even without using % operator
	public static void main(String[] args) {
		
		isEven(3298);
		isEven(223468);
		isEven(25555);
		isEven(890);
		isEven(0);
	}
	public static void isEven(int number)
	{
		int divider = number/2; //since we use int, only whole numbers will be stored.

		if(divider*2 == number) //checks if quotient of number times 2 is the number
		{
			System.out.println(number + " is even");
		}
		else
		{
			System.out.println(number + " is odd");
		}
	}
	

}
