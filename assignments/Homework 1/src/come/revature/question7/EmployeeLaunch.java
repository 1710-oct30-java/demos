package come.revature.question7;

import java.util.Arrays;

public class EmployeeLaunch {
	public static void main(String[] args) {

		Employee aryEmployee[] = {new Employee("Brice", "Java Cohort", 25), new Employee("Reagan", ".NET Cohort", 21)};
		EmployeeComp comparator = new EmployeeComp();
		System.out.println("Employees to sort " + Arrays.toString(aryEmployee));
		Arrays.sort(aryEmployee, comparator);
		System.out.println("Sorted Empoyees: " + Arrays.toString(aryEmployee));
	}
}
