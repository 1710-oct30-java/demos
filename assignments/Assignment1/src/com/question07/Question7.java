package com.question07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * sort name, age, department using comparator interface
 */
public class Question7
{

	public static void main(String[] args)
	{
		List<Question7Employees> empList = new ArrayList<Question7Employees>();
		empList.add(new Question7Employees("John Doe", "Mathematics", 47));
		empList.add(new Question7Employees("Cait Johnson", "Biology", 25));
		empList.add(new Question7Employees("Kris Rock", "Accounting", 33));
		empList.add(new Question7Employees("Kris Flock", "Engineering", 65));

		// sorting by name
		Collections.sort(empList, new Question7NameComp());
		System.out.println("\nSorting by Name");
		for (Question7Employees emp : empList)
			System.out.println(emp.getName() + "\t: " + emp.getDepartment()
					+ " \t: " + emp.getAge());

		// sorting by Department
		Collections.sort(empList, new Question7DepComp());
		System.out.println("\nSorting by Department");
		for (Question7Employees emp : empList)
			System.out.println(emp.getName() + "\t: " + emp.getDepartment()
					+ " \t: " + emp.getAge());

		// sorting by age
		Collections.sort(empList, new Question7AgeComp());
		System.out.println("\nSorting by Age");
		for (Question7Employees emp : empList)
			System.out.println(emp.getName() + "\t: " + emp.getDepartment()
					+ " \t: " + emp.getAge());

	}
}
