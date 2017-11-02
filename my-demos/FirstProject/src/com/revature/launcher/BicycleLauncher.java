package com.revature.launcher;

import java.util.Arrays;

import com.revature.beans.Bicycle;
import com.revature.beans.Wheel;

public class BicycleLauncher {
	public static void main(String[] args) {
		
		Wheel one = new Wheel(200, 15, "aluminum");
		Wheel two = new Wheel(200, 15, "carbon");

		Wheel[] wheels = { one, two };
		final Bicycle myBike = new Bicycle(1, wheels, "steel", "blue");
		myBike.setColor("red");
		
//		
//		for(int i = 0; i < 1000000000; i++) {
//			Wheel one = new Wheel(200, 15, "aluminum");
//			Wheel two = new Wheel(200, 15, "carbon");
//
//			Wheel[] wheels = { one, two };
//			new Bicycle(i, wheels, "steel", "blue");
//		}
//		System.out.println("created bikes");
////		System.gc();
//		while(true) {
//			
//		}
	}
}
