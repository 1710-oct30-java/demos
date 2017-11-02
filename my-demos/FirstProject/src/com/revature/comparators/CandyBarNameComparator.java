package com.revature.comparators;

import java.util.Comparator;

import com.revature.beans.CandyBar;

public class CandyBarNameComparator implements Comparator<CandyBar> {

	@Override
	public int compare(CandyBar o1, CandyBar o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
