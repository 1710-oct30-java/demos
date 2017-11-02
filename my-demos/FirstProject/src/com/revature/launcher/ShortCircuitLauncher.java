package com.revature.launcher;

public class ShortCircuitLauncher {
	private static int i;
	public static void main(String[] args) {
		boolean one = true;
		boolean two = false;
		
		// short circuit will not check the second condition if the evaulation
		// is conclusive on the first
		if(shortCircuit(one) || shortCircuit(two)) {
			System.out.println("yes");
		} 
		
		
		System.out.println(i);
	}
	
	private static boolean shortCircuit(boolean b) {
		i++;
		return b;
	}
}
