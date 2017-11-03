package com.question07;

// Sort two employees based on their name, department, and age using the Comparator interface.

public class Question7
{
	public static void main(String[] args)
	{
		Employee mark = new Employee("Mark", "Acquisitions", 25);
		Employee chris = new Employee("Chris", "IT", 25);
		
		NameComparator nc = new NameComparator();
		DepComparator dc = new DepComparator();
		AgeComparator ac = new AgeComparator();
		
		int nameDiff = nc.compare(mark, chris);
		int DepDiff = dc.compare(mark, chris);
		int ageDiff = ac.compare(mark, chris);
		
		System.out.println("Difference in names between " + mark.getName() + " and " + chris.getName()
				+ " is " + nameDiff);
		
		System.out.println("Difference in departments between " + mark.getName() + " and "
				+ chris.getName() + " is " + DepDiff);
		
		System.out.println("Difference in ages between " + mark.getName() + " and " + chris.getName()
				+ " is " + ageDiff);
	}
}
