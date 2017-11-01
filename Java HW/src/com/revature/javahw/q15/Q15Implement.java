// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 15

package com.revature.javahw.q15;

// Q15. Write a program that defines an interface having the
//		following methods: addition, subtraction, multiplication,
//		and division. Create a class that implements this interface
//		and provides appropriate functionality to carry out the
//		required operations. Hard code two operands in a test
//		class having a main method that calls the implementing class.


public class Q15Implement implements SimpleMath<Integer>{

	@Override
	public Integer addition(Integer... args) {
		Integer sum = 0;
		for(Integer ele : args) {
			sum += ele;
		}
		return sum;
	}

	@Override
	public Integer subtraction(Integer... args) {
		Integer result = args[0];
		for(int i = 1; i < args.length; i++) {
			result -= args[i];
		}
		return result;
	}

	@Override
	public Integer multiplication(Integer... args) {
		Integer total = 1;
		for(Integer ele : args) {
			total *= ele;
		}
		return total;
	}

	@Override
	public Integer division(Integer... args) {
		Integer result = args[0];
		for(int i = 1; i < args.length; i++) {
			result /= args[i];
		}
		return result;
	}

}
