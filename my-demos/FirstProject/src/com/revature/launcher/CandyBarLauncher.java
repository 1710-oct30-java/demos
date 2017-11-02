package com.revature.launcher;

import java.util.Arrays;

import com.revature.beans.CandyBar;
import com.revature.comparators.CandyBarNameComparator;
import com.revature.comparators.Sorter;

public class CandyBarLauncher {
	public static void main(String[] args) {
		CandyBar[] candyBars = { new CandyBar("butterfinger", 5), new CandyBar("resses", 6),
				new CandyBar("hersheys cookies and creme", 10), new CandyBar("three musketeers", 6) };

		// System.out.println(candyBars[0].compareTo(candyBars[1]));
//		Arrays.sort(candyBars);
//		System.out.println(Arrays.toString(candyBars));

		Arrays.sort(candyBars, new CandyBarNameComparator());
		System.out.println(Arrays.toString(candyBars));

		Sorter.sort(candyBars);
		System.out.println(Arrays.toString(candyBars));
	}
}
