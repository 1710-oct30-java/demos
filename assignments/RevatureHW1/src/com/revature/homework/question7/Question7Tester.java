package com.revature.homework.question7;
// sort a list of employees using the comparator interface
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question7Tester {
    public static void main(String[] args) {
        Employee e1 = new Employee("Randy", "Sales", 21);
        Employee e2 = new Employee("John", "CS", 23);
        Employee e3 = new Employee("David", "HR", 28);
        Employee e4 = new Employee("Mike", "Accounting", 20);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        int i =3;
        switch (i) {
        case 1:
        	Collections.sort(employees, new Question7NameSorter());
            System.out.println(employees.toString());
            break;
        case 2:
        	Collections.sort(employees, new Question7DeptSorter());
            System.out.println(employees.toString());
            break;
        case 3:
        	Collections.sort(employees, new Question7AgeSorter());
            System.out.println(employees.toString());
            break;
    }
    }
}

        