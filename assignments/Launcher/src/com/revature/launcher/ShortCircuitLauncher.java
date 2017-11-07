package com.revature.launcher;

public class ShortCircuitLauncher {
	private static int i;
	public static void main(String[] args) {
		boolean one = true;
		boolean two = false;
		if ( one || two) {
			System.out.println("yes");
		}
	}
}
