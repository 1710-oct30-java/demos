package q14;

import java.util.*;

public class Switches {
	public static void main(String[] args) {
		int WhatDo = 3;
		double sqrt = 4;
		Date date = new Date();
		String s = "I am learning Core Java";
		String[] l;
		switch (WhatDo) {
		case 1:
			sqrt = Math.sqrt(sqrt);
			System.out.println(sqrt);
			break;
		case 2:
			date = Calendar.getInstance().getTime();
			System.out.println(date);
			break;
		case 3:
			l = s.split(" ");
			for (String e : l) {
				System.out.println(e);
			}
			break;
		default:
			System.out.println("invalid case");
			break;

		}

	}
}
