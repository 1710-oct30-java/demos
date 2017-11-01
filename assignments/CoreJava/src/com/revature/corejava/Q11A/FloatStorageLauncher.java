package com.revature.corejava.Q11A;

// Author: Micah West
// Date: 10/31/2017
// Purpose: Display two floating point values stored in a separate package's class.
//          Solves Question 11 in the Revature Core Java homework assigned Week 1.
// Input: none
// Output: Cylinder height: 500.0
//         Cylinder radius: 10.0

import com.revature.corejava.Q11B.FloatStorage;

public class FloatStorageLauncher {
	
	public static void main(String[] args) {
		
		// These lines print out the starting values for the class
		// that stores the data of a cylinder.
		System.out.println("Cylinder height: " + FloatStorage.getCylinderHeight());
		System.out.println("Cylinder radius: " + FloatStorage.getCylinderRadius());
	}
}
