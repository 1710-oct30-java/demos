package com.revature.Homework1.Q11a;

import com.revature.Homework1.Q11b.*;

public class Q11a {
	//Access two floats in another package
	public static void main(String[] args) {
		Q11b test = new Q11b();
		System.out.println("math from another package: "+ test.a+" + " +test.b+" = "+ (test.a+test.b));
	}
}
