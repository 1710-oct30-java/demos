package com.revature.question7;


import java.util.ArrayList;
import java.util.Collections;


public class UseComparator {
    public static void main(String[] args) {
 
        Employee emp1=new Employee("Brandon","47", "Front Office" );
        Employee emp2=new Employee("Russ","49", "Ticket Sales");
        Employee emp3=new Employee("Sal","37", "Media");

        ArrayList<Employee> list=new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
      
        System.out.println("This is the list of employees: \n"+list);
 
        Collections.sort(list,new Employee().new ComparatorName());
        System.out.println("Sort based on name: \n"+ list);
 
        Collections.sort(list,new Employee.ComparatorAge());
        System.out.println("Sort based on Age \n " +list);
        
        Collections.sort(list,new Employee.ComparatorDepartment());
        System.out.println("Sort based on Department \n" + list);
       
    }
}

	
		

	


