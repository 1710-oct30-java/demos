package question7;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		super();
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Employee o) {
		if(this.getAge() > o.getAge()) {
			return 1;
		} else if(this.getAge() < o.getAge()) {
			return -1;
		}
		return 0;
	}

	
	
}
