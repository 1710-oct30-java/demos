package question7;

import java.util.Comparator;

public class Question7 {
	// Sort two employees based on their name, department and age using the
	// Comparator interface.
	public static void main(String[] args) {
		EmployeeComparator ec = new EmployeeComparator();
		Employee e1 = new Employee("Dennis", "Doggo Department", 30);
		Employee e2 = new Employee("Marcus", "Catten Department", 26);

		System.out.println(ec.compare(e1, e2));
	}

	// Employee class containing an employee's name, department and age.
	static class Employee {
		// Variable containing an employee's name.
		String name;

		// Variable containing an employee's department.
		String department;

		// Variable containing an employee's age.
		int age;

		// Default constructor for class Employee. Default strings are
		// empty. Default age is 0.
		public Employee() {
			name = "";
			department = "";
			age = 0;
		}

		// Alternate constructor for class Employee. Allows setting
		// initial values for Employee.
		public Employee(String n, String d, int a) {
			this.name = n;
			this.department = d;
			this.age = a;
		}

		// Returns name of an Employee.
		public String getName() {
			return this.name;
		}

		// Returns the department of an Employee.
		public String getDepartment() {
			return this.department;
		}

		// Returns the age of an Employee.
		public int getAge() {
			return this.age;
		}

		// Sets the name of an Employee to n.
		public void setName(String n) {
			this.name = n;
		}

		// Sets the department of an Employee to d.
		public void setDepartment(String d) {
			this.department = d;
		}

		// Sets the age of an Employee to a.
		public void setAge(int a) {
			this.age = a;
		}
	}

	// Static comparator class for comparing two Employee objects.
	static class EmployeeComparator implements Comparator<Object> {
		// This method overrides the compare method from the Comparator interface. It
		// compares two Employee
		// Objects based on name, then department, then age.
		@Override
		public int compare(Object o1, Object o2) {
			Employee e1 = (Employee) o1;
			Employee e2 = (Employee) o2;

			if (e1.name.compareTo(e2.name) != 0) {
				return e1.name.compareTo(e2.name);
			}
			if (e1.department.compareTo(e2.department) != 0) {
				return e1.department.compareTo(e2.department);
			}
			if (e1.age != e2.age) {
				if (e1.age < e2.age) {
					return -1;
				}
				if (e1.age > e2.age) {
					return 1;
				}
			}
			return 0;
		}
	}
}