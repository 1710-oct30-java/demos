package q7;

import java.util.ArrayList;
import java.util.Collections;

public class SortEmployees {
	public static void main(String[] args) {
		Employee Adam = new Employee(20, "Adam", "HR");
		Employee Bob = new Employee(30, "Bob", "IT");
		ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
		EmployeeList.add(Bob);
		EmployeeList.add(Adam);

		System.out.println("Before Sort");
		for (Employee e : EmployeeList) {
			System.out.println(e);
		}
		Collections.sort(EmployeeList, new CompareEmployees());
		
		System.out.println("After Sort");
		
		for (Employee e : EmployeeList) {
			System.out.println(e);
		}
	}

}
