package com.revature.launcher;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.revature.beans.CandyBar;

public class ReflectionLauncher {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Object
		CandyBar kitkat = new CandyBar("kitkat", 7);
		Method[] methods = CandyBar.class.getMethods();
		System.out.println("methods:");
		for (Method m : methods) {
			System.out.println("\t" + m);
		}

		Field[] fields = kitkat.getClass().getDeclaredFields();
		System.out.println("fields");
		for (Field f : fields) {
			System.out.println(f);
		}

		System.out.println(kitkat);
		Field ratingField = CandyBar.class.getDeclaredField("rating");
		ratingField.setAccessible(true);
		ratingField.set(kitkat, 8);
		
		System.out.println(kitkat);
		
		

	}
}
