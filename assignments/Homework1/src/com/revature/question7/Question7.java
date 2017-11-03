package com.revature.question7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question7 {

	public static void main(String[] args) {
		
		ArrayList<Question7Employee> empList = new ArrayList<Question7Employee>();
		
		empList.add(new Question7Employee("Austin", "Computer", 24));
		empList.add(new Question7Employee("Zebra", "Sales", 7));
		
		Collections.sort(empList, new Question7Sort());
		System.out.println("Sorted by name");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));
		
		Collections.sort(empList, new Question7DepartmentSort());
		System.out.println("\nSorted by department");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));
		
		Collections.sort(empList, new Question7AgeSort());
		System.out.println("\nSorted by age");
		for (int i = 0; i < empList.size(); i++)
			System.out.println(empList.get(i));
			
		
		

	}

}
