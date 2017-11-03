package com.revature.question19;

import java.awt.List;
import java.util.ArrayList;

/*
 * Create ArrayList and insert int 1-10
 * Display ArrayList
 * Add all even numbers up and display result
 * Add all odd numbers up and display result
 * Remove prime numbers and print out remaining ArrayList
 */

public class Question19 {

	static int even = 0;
	static int odd = 0;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		for (int i = 1; i <= 10; i++)
			list.add(i);

		System.out.println(list);

		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				even += list.indexOf(i);
			else
				odd += list.indexOf(i);
		}

		for (int i = 0; i < 10; i++) {
			int counter = 0;
			for (int j = i; j >= 1; j--) {
				if (i % j == 0) {
					counter = counter + 1;
				}
			}
				if (counter != 2 && i <= 7) {
					list2.add(i);
				}
			}
		
			System.out.println("Sum of all even numbers: " + even);
			System.out.println("Sum of all odd numbers: " + odd);
			System.out.println("Original list without prime numbers: " + list2);

		
	}

}
