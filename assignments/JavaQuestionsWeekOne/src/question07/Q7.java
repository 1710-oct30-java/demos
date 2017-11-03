package question07;

import java.util.ArrayList;

public class Q7 {

	// Sort two employees based on their name, department, and age using the
	// Comparator interface.

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Sam", 50, "IT"));
		employees.add(new Employee("Bob", 34, "HR"));

		// By using the lambda, we can satisfy the Comparator interface in-line rather
		// than creating three separate Comparators in our package.

		// Sort by name.
		employees.sort((emp1, emp2) -> {
			return emp1.getName().compareTo(emp2.getName());
		});

		// Sort by department.
		employees.sort((emp1, emp2) -> {
			return emp1.getDepartment().compareTo(emp2.getDepartment());
		});

		// Sort by age.
		employees.sort((emp1, emp2) -> {
			return emp1.getAge() - emp2.getAge();
		});

		// Print to console.
		for (Employee employee : employees) {
			System.out.println(employee.getName());
		}

	}

}
