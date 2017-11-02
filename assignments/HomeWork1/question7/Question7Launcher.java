package question7;

import java.util.LinkedList;
import java.util.List;

public class Question7Launcher {
	public static void main(String[] args) {
		Employee john = new Employee(26, "John", "Marketing");
		Employee johnb = new Employee(34, "John", "Marketing");
		Employee johnc = new Employee(26, "John", "R&D");
		Employee jane = new Employee(24, "Jane", "R&D");
		Employee bob = new Employee(87, "bob", "CE");
		Employee zack = new Employee(12, "zack", "waterboy");
		Employee zoe = new Employee(18, "zoe", "greeter");
		Employee avery = new Employee(34, "Avery", "Person");
		List<Employee> people = new LinkedList<>();
		people.add(john);
		people.add(jane);
		people.add(bob);
		people.add(zack);
		people.add(zoe);
		people.add(avery);
		people.add(johnb);
		people.add(johnc);

		people.sort(new Question7.CompareAll());
		System.out.println(people);
	}
}
