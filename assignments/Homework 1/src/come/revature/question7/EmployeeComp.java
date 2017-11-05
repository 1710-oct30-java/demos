package come.revature.question7;

import java.util.Comparator;

public class EmployeeComp implements Comparator<Employee> {
	
	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName()) 
				+ emp1.getDepartment().compareTo(emp2.getDepartment())
				+ (emp1.getAge() - emp2.getAge());
	}
}
