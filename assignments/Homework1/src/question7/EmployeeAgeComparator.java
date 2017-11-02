package question7;

import java.util.Comparator;

/*
 * Class used to implement the age comparator
 */
public class EmployeeAgeComparator implements Comparator<Employee> {

	// compare method that sorts by youngest first
	@Override
	public int compare(Employee e1, Employee e2) {

		return e1.getAge() - e2.getAge();
	}

}
