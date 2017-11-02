package com.revature.launcher;

import com.revature.generics.Calculator;

public class GenericLauncher {
	public static void main(String[] args) {
		Calculator<Long> intCalc =  new Calculator<>();
		System.out.println(intCalc.add(10000000000012l, 10000000000000l));
		System.out.println(10000000000000l);
	}
}
