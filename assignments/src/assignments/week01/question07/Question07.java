package assignments.week01.question07;

public class Question07 {
	
	public static void main(String[] args) {
		
		EmployeeCollection employees = new EmployeeCollection();
		
		generateEmployeeData( employees );
		
		employees.sort();
		
		System.out.println( employees );
	}
	
	/**
	 * injects test employee objects into the EmployeeCollection passed 
	 * 
	 * @param EmployeeCollection employees
	 */
	public static void generateEmployeeData(EmployeeCollection employees )
	{
		employees.add( new Employee("John", 38, "Software Development") );
		employees.add( new Employee("John", 35, "Software Development") );
		employees.add( new Employee("Aaron", 29, "Training") );
		employees.add( new Employee("Aaron", 30, "Training") );
		employees.add( new Employee("Chris", 50, "Operations") );
	}

}
