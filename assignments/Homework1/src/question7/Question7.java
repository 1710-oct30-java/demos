package question7;

import java.util.Arrays;

/*
 * Sort two employees based on their name, department, and age using the Comparator
 * interface.
 */

public class Question7 {
	
	public static void main(String[] args) {

		// creates new employees and stores them in array
		Employee ted = new Employee("ted", "Tech", 43);
		Employee mark = new Employee("mark", "Sales", 50);
		
		Employee[] empList = {ted, mark};
		
		// sorts the employees by department
		System.out.println("Sort by Department");
		Arrays.sort(empList, new EmployeeDepartmentComparator());
		
		for(Employee emp: empList) {
			System.out.println(emp);
		}
		System.out.println();
		
		// sorts the employees by age
		System.out.println("Sort by Age");
		Arrays.sort(empList, new EmployeeAgeComparator());
		
		for(Employee emp: empList) {
			System.out.println(emp);
		}
		System.out.println();
		
		// sorts the employees by Name
		System.out.println("Sort by Name");
		Arrays.sort(empList, new EmployeeNameComparator());
		
		for(Employee emp: empList) {
			System.out.println(emp);
		}
		System.out.println();
			
	}


}
