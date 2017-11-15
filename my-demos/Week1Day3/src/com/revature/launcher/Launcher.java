package com.revature.launcher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.revature.beans.Car;

public class Launcher {
	public static void main(String[] args) {
		List<Car> carList = new LinkedList<>();
		Car firstCar = new Car(1, "green", "toyota", "corolla");
		carList.add(firstCar);
		carList.add(new Car(2, "red", "McLaren", "F1"));
		carList.add(new Car(3, "blue", "subaru", "outback"));
		carList.add(firstCar);

		System.out.println(carList);

		Set<Car> carSet = new HashSet<>();
		carSet.addAll(carList);
		System.out.println("set: ");

		for (Car each : carSet) {
			System.out.println(each);
		}
		
		// manual iteration
		System.out.println("manual iteration");
		Iterator<Car> iterate = carSet.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}

		Map<String, Car> myMap = new HashMap<>();
		myMap.put("rob", carList.get(0));
		myMap.put("bryce", carList.get(1));
		myMap.put("micah", carList.get(2));

		System.out.println("map");
		for (String key : myMap.keySet()) {
			System.out.println(key + ": " + myMap.get(key));
		}

	}
}
