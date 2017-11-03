package com.revature.launcher;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.beans.Car;
import com.revature.beans.FunctionImpl;

public class LambdaLauncher {
	public static void main(String[] args) {
		System.out.println(5>10?"true":"false");
		
		List<Car> carList = new LinkedList<>();
		Car firstCar = new Car(1, "green", "toyota", "corolla", 7000);
		carList.add(firstCar);
		carList.add(new Car(4, "green", "subaru", "outback", 15000));
		carList.add(new Car(2, "red", "mcLaren", "F1", 2500000));
		carList.add(new Car(3, "blue", "subaru", "outback", 13000));
		carList.add(new Car(5, "orange", "subaru", "outback", 14500));
		carList.add(new Car(6, "silver", "mcLaren", "F1", 100000));
		for(int i = 7; i < 2500; i++) {
			carList.add(new Car(i, "red", "mcLaren", "F1", 3000000));
		}
		carList.add(firstCar);
		
		List<Double> filteredList = carList.parallelStream().filter( car -> {
			if("subaru".equals(car.getMake())) {
				return true;
			}
			return false;
		})
		.map( car -> {
			return car.getPrice();
		})
		.collect(Collectors.toList());
		
		Double totalPriceOfSubarus = carList.parallelStream().filter( car -> {
			if("subaru".equals(car.getMake())) {
				return true;
			}
			return false;
		})
		.map(car -> car.getPrice())
		.reduce((acc, cur) -> acc+cur).get();
		
		System.out.println(filteredList);
		System.out.println("total: " + totalPriceOfSubarus);
	}
	
	
	private static void Sort(List<Car> carList) {
		carList.sort((one, two) -> {
			return one.getMake().compareTo(two.getMake());
		});
	}
}
