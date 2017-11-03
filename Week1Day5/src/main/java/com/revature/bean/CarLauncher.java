package com.revature.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.revature.factories.McLarenFactory;

public class CarLauncher {
	private static McLarenFactory mlf = new McLarenFactory();
	
	public static void main(String[] args) {
		
		List<Car> myCars = new ArrayList<>();
		
		//What a mess
		IntStream.range(1, 5000).forEach(i -> {
			try {
				myCars.add(mlf.createBySerialNumber(i));
			} catch (SerialNumberNotFoundException e) {
				e.printStackTrace();
			}
		});

		System.out.println(myCars);
	
	
	}
	
	
}
