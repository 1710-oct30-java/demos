package question7;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{

	// compare method to compare the names of employees
	@Override
	public int compare(Employee e1, Employee e2) {

		return e1.getName().compareTo(e2.getName());
	}

}
