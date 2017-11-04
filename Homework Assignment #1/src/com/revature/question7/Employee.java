package com.revature.question7;
import java.util.Comparator;
//Revature
//Robert Choboy
//Sort two employees based on their name, age, and department using the comparator interface
//Date: 11/3/2017


class Employee{
    String name;
    String age;
    String department;
   
    public Employee() {}
   
    public Employee(String name, String age, String department){
        this.name = name;
        this.age = age;
        this.department = department; 
    }
   
    
    @Override
    public String toString() {
        return "Employee " + "Name=" + name + ", Age=" + age + " Department=" + department ; 
        		
    }
    class ComparatorName  implements Comparator<Employee>{
       @Override
        public int compare(Employee obj1, Employee obj2) {
           //sort Employee on basis of name(ascending order)
           return obj1.name.compareTo(obj2.name);
        }
    }
   
    static class ComparatorAge  implements Comparator<Employee>{
       @Override
        public int compare(Employee obj1, Employee obj2) {
           //sort Employee on basis of age(ascending order)
           return obj1.age.compareTo(obj2.age);
        }
    }
 
    static class ComparatorDepartment  implements Comparator<Employee>{
        @Override
         public int compare(Employee obj1, Employee obj2) {
            //sort Employee by department
            return obj1.department.compareTo(obj2.department);
    
    
        }
    }
    
}