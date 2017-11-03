package com.revature.launcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.utility.Serializer;

public class SerializeLauncher {
	private static Serializer<List<Car>> carListSerializer = new Serializer<>();
	
	public static void main(String[] args) {
		List<Car> carList = carListSerializer.readObject("cars.txt");
		
		System.out.println(carList);
//		Car firstCar = new Car(1, "green", "toyota", "corolla");
//		carList.add(firstCar);
//		carList.add(new Car(2, "red", "McLaren", "F1"));
//		carList.add(new Car(3, "blue", "subaru", "outback"));
//		carList.add(firstCar);
//		
//		carListSerializer.writeObject(carList, "cars.txt");
		
	}
}
