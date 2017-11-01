package q7;

import java.util.Comparator;

public class CompareEmployees implements Comparator<Employee> {

	public int compare(Employee a, Employee b) {
		// compare name, department, and age
		int compareName = a.getName().compareTo(b.getName());
		int compareDepartment = a.getDepartment().compareTo(b.getDepartment());
		int compareAge = Integer.compare(a.getAge(), b.getAge());

		// compare name, if name is the same, compare department, if department is the
		// same, compare age
		// if not the same, return
		if (compareName == 0) {
			if (compareDepartment == 0) {
				return compareAge;
			} else {
				return compareDepartment;
			}
		} else {
			return compareName;
		}

	}
}