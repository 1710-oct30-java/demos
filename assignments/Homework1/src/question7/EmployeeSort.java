package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class EmployeeSort {
	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("tim", "Wizardry", 52));
		employeeList.add(new Employee("alan", "Sales", 22));
		employeeList.add(new Employee("may", "Customer Service", 30));
		
		System.out.println("by name");
		Collections.sort(employeeList, new EmployeeNameComparator());
		
		Iterator<Employee> nameIterator = employeeList.iterator();
		while(nameIterator.hasNext()) {
			System.out.println(nameIterator.next());
		}
		
		System.out.println("by age");
		Collections.sort(employeeList, new EmployeeAgeComparator());
		
		Iterator<Employee> ageIterator = employeeList.iterator();
		while(ageIterator.hasNext()) {
			System.out.println(ageIterator.next());
		}
		
		System.out.println("by department");
		Collections.sort(employeeList, new EmployeeDepartmentComparator());
		
		Iterator<Employee> departmentIterator = employeeList.iterator();
		while(departmentIterator.hasNext()) {
			System.out.println(departmentIterator.next());
		}
		
		
		
	}

}
