package com.revature.unit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.beans.Car;
import com.revature.exceptions.SerialNumberNotFoundException;
import com.revature.factories.McLarenFactory;

public class McLarenFactoryTests {
	private final McLarenFactory mlf = new McLarenFactory();
	
	@Test
	public void serail1() throws SerialNumberNotFoundException {
		Car actual = mlf.createBySerialNumber(1);
		assertEquals("Red", actual.getColor());
		assertEquals("Make was not McLaren", "McLareafn", actual.getMake());
	}
	
	@Test(expected = SerialNumberNotFoundException.class)
	public void serial1000DoesntExist() throws SerialNumberNotFoundException {
		mlf.createBySerialNumber(1000);
	}

}
