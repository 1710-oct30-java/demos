package com.revature.question11a;

import com.revature.question11b.Question11B; //Import package to access variables

/*
 * Write a program that would access two float-variables from a class
 * that exists in another package. Note, you will create two packages to demonstrate
 * the solution
 */
public class Question11A {
	
	public static void main(String[] args) {
		//show that we can access the two float variable modifiers from package B
		Question11B accessVariables = new Question11B();
		accessVariables.firstVariableB = 3.5f;
		accessVariables.secondVariableB = 2.4f;
	}
	
}
