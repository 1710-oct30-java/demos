package com.revature.launcher;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.exceptions.SerialNumberNotFoundException;
import com.revature.factories.McLarenFactory;

public class CarLauncher {
	private static McLarenFactory mlf = new McLarenFactory();

	public static void main(String[] args) {
		try {
			List<Car> cars = new ArrayList<>();
			cars.add(mlf.createBySerialNumber(1));
			cars.add(mlf.createBySerialNumber(1));
			cars.add(mlf.createBySerialNumber(3));
			System.out.println(cars);
		} catch (SerialNumberNotFoundException e) {
			e.printStackTrace();
		}

	}
}
