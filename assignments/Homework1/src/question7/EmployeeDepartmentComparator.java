package question7;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee> {

	// compare method used to sort the department of employee
	@Override
	public int compare(Employee e1, Employee e2) {

		return e1.getDepartment().compareTo(e2.getDepartment());
	}
	
}
