package question07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Question 7: Sort two employees based on their name, department, and age 
 * using the Comparator interface.
 *
 * Comparator used for solution in {@link Employee}
 * 
 * @author Mitch Goshorn
 *
 */
public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		//compare names
		if(o1.getName().compareTo(o2.getName()) == 0) {
			 //names are the same, so compare department
			if(o1.getDepartment().compareTo(o2.getDepartment()) == 0) {
				//departments are the same, so compare birthdate
				if(o1.getDateofbirth() == o2.getDateofbirth()) {
					return 0;
				}
				//Not equal, so return 1 or -1 dependent upon which is greater
				return o1.getDateofbirth() > o2.getDateofbirth() ? 1 : -1;
			}
			
			//Departments are different, so return compareTo value of departments
			return o1.getDepartment().compareTo(o2.getDepartment());
		}
		//Names not equal so use compareTo result
		return o1.getName().compareTo(o2.getName());
	}
	
	public static void main(String[] args) {
		Employee charlie = new Employee("charlie", 	"accounting", 382856400);
		Employee unix = new Employee(	"unix", 		"IT",		  	  0);

		
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(unix);
		employees.add(charlie);
		
		Collections.sort(employees, new EmployeeComparator());
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}


}
