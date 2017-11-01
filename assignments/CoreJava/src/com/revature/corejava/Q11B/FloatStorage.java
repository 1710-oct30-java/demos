//Author: Micah West
//Date: 10/31/2017
//Purpose: Store two floating point values to be accessed in the FloatStorageLauncher class in
//         the Q11A package. The other part of my solution to Question 11 of the Revature Core
//         Java homework assigned on Week 1.
//Input: none
//Output: none

package com.revature.corejava.Q11B;

public class FloatStorage {
	
	// These values are static because the problem specifically asked to
	// access variables from the class itself, not necessarily an object
	// created from that class.
	private static float cylinderRadius = 10.0f;
	private static float cylinderHeight = 500.0f;
	
	// I just had Eclipse auto-generate the following methods.
	// 
	public static float getCylinderRadius() {
		return cylinderRadius;
	}
	public static void setCylinderRadius(float cylinerRadius) {
		FloatStorage.cylinderRadius = cylinerRadius;
	}
	public static float getCylinderHeight() {
		return cylinderHeight;
	}
	public static void setCylinderHeight(float cylinderHeight) {
		FloatStorage.cylinderHeight = cylinderHeight;
	}
}
