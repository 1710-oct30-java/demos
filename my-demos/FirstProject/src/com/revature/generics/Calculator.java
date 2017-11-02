package com.revature.generics;

public class Calculator<T extends Number> {
	public T add(T one, T two) {
		Number sum = one.doubleValue() + two.doubleValue();
		return (T) sum;
	}
}
