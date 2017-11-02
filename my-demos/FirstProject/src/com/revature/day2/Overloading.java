package com.revature.day2;

public class Overloading {
	public static void main(String[] args) {
		int i = 5;
		overload(i, 10, 15, 25, 2, 4);
	}
	
	private static void overload() {
		System.out.println("no params");
	}
	
	private static void overload(int i) {
		System.out.println("primitive int");
	}
	
	private static void overload(Integer i) {
		System.out.println("wrapper int");
	}
	
	private static void overload(long l) {
		System.out.println("primitive long");
	}
	
	
	private static void overload(int... params) {
		System.out.println("var args for each loop");
		for(int ele: params) {
			System.out.println(ele);
		}
		
		System.out.println("standard");
		for(int i = 0; i < params.length; i++) {
			System.out.println(params[i]);
		}
		
	}
	
	
}
