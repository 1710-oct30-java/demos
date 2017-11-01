package question7;

import java.util.Comparator;

/*
 * Sort two employees based on their name, department, and age using the Comparator interface.
 */
public class Question7{

	public static class CompareName implements Comparator<Employee>
	{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	public static class CompareDepartment implements Comparator<Employee>
	{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getDepartment().compareTo(o2.getDepartment());
		}
		
	}
	public static class CompareAge implements Comparator<Employee>
	{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getAge() - o2.getAge();
		}
		
	}
	public static class CompareAll implements Comparator<Employee>
	{
		public int compare(Employee o1, Employee o2) {
			//Check names, If they are equivalent then continue on, else return;
			if(o1.getName().compareTo(o2.getName()) == 0)
			{
				//Check department, If they are equivalent then coninue on, else return;
				if(o1.getDepartment().compareTo(o2.getDepartment()) == 0)
				{
					//Can't continue on, so return employee 1's age minus employee 2's age
					return o1.getAge() - o2.getAge();
				}
				return o1.getDepartment().compareTo(o2.getDepartment());
			}
			return o1.getName().compareTo(o2.getName());
		}
	}

}
