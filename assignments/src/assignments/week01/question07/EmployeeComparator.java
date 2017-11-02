package assignments.week01.question07;

import java.util.Comparator;

/**
 * encapsulates the sorting logic to use
 * for an EmployeeCollection
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class EmployeeComparator implements Comparator<Employee> {
	
	/**
	 * compare employees using the following election sequence:
	 * - name
	 * - age
	 * - department
	 * 
	 * @param Employee a
	 * @param Employee b
	 * 
	 * @return int
	 */
	public int compare(Employee a, Employee b)	{
		int nameComparison = this.compareNames(a, b);
		int ageComparison = this.compareAges(a, b);
		int deptComparison = this.compareDepartments(a, b);
		
		if ( nameComparison == 0 ) {
			if ( ageComparison == 0 ) {
				return deptComparison;
			} else {
				return ageComparison;
			}
		} else {
			return nameComparison;
		}
	}
	
	/**
	 * compare employees by name
	 * 
	 * @param Employee a
	 * @param Employee b
	 * 
	 * @return int
	 */
	protected int compareNames(Employee a, Employee b)
	{
		return a.name.compareTo(b.name);
	}
	
	/**
	 * compare employees by age
	 * 
	 * @param Employee a
	 * @param Employee b
	 * 
	 * @return int
	 */
	protected int compareAges(Employee a, Employee b)
	{
		return Integer.compare(a.age, b.age);
	}
	
	/**
	 * compare employees by department
	 * 
	 * @param Employee a
	 * @param Employee b
	 * 
	 * @return int
	 */
	protected int compareDepartments(Employee a, Employee b)
	{
		return a.department.compareTo(b.department);
	}
}
