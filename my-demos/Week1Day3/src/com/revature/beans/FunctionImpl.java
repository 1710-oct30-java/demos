package com.revature.beans;

import java.util.Arrays;
import java.util.function.Function;

public class FunctionImpl implements Function<Car, Double> {

	@Override
	public Double apply(Car car) {
		return car.getPrice();
	}
	
	public static void main(String[] args) {
		char[] cool = "hello".toCharArray();
		System.out.println(Arrays.toString(cool));
	}
}
