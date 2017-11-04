package com.revature.question16;

public class Question16 {
	public static void main(String[] args) {
		if (args.length < 1)
			System.out.println("Please enter a string");
		else
			System.out.println(args[0] + "has a length of " + args[0].length());
	}

}
