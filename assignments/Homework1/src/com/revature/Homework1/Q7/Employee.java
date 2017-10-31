package com.revature.Homework1.Q7;

import java.util.Comparator;

public class Employee {
	private String Name;
	private String Department;
	private int Age;
	
	
	
	public Employee(String name, String department, int age) {
		Name = name;
		Department = department;
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String toString() {
		return ("Name: "+ Name+ "; Department: "+ Department+"; Age: "+ Age);
	}
	public static Comparator<Employee> EmpNameComparator = new Comparator<Employee>() {
		public int compare(Employee a, Employee b)
	    {
	        return(a.getName().compareToIgnoreCase(b.getName()));
	    }
	};
	public static Comparator<Employee> EmpDepartmentComparator = new Comparator<Employee>() {
		public int compare(Employee a, Employee b)
	    {

	        return(a.getDepartment().compareToIgnoreCase(b.getDepartment()));
	    }
	};
	public static Comparator<Employee> EmpAgeComparator = new Comparator<Employee>() {
		public int compare(Employee a, Employee b)
	    {
		   if(a.getAge()<b.getAge()) {
			   return(1);
		   }
		   if(a.getAge()>b.getAge()) {
			   return(-1);
		   }
		   return(0);
	    }
	};
	
}
