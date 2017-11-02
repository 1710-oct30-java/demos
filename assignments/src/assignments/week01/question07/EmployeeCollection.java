package assignments.week01.question07;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * represents a collection of employees
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class EmployeeCollection {
	
	/*
	 * the encapsulated collection and point of the class
	 */
	protected ArrayList<Employee> collection;
	
	/*
	 * encapsulated comparator for sorting employees
	 */
	protected Comparator<Employee> comparator;
	
	
	public EmployeeCollection()
	{
		super();
		
		this.collection = new ArrayList<>();
		this.comparator = new EmployeeComparator();
	}
	
	/**
	 * add an employee to the collection
	 * 
	 * @param Employee e
	 * 
	 * @return self 
	 */
	public EmployeeCollection add(Employee e)
	{
		this.collection.add(e);
		return this;
	}
	
	/**
	 * sort the stored employees using the logic of
	 * the comparator
	 * 
	 */
	public void sort()
	{
		this.collection.sort( this.comparator );
	}
	
	/**
	 * return a string representation of the employee
	 * collection
	 * 
	 * return String
	 */
	public String toString()
	{
		return String.valueOf( this.collection );
	}
	
}
