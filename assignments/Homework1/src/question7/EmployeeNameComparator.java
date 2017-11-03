package question7;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getName().charAt(0) > e2.getName().charAt(0)) {
			return 1;
		} else if(e1.getName().charAt(0) < e2.getName().charAt(0)) {
			return -1;
		}
		return 0;
	}
	
}
