package come.revature.question7;

public class Employee {

	public String name;
	public String department;
	public int age;

	public Employee(String name, String department, int age) {
		
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee Name: " + name + ", Employee Dept: " + department + ", Employee Age: " + age;
	}
}
