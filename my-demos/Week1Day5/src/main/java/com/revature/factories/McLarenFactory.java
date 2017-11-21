package com.revature.factories;

import com.revature.beans.Car;
import com.revature.exceptions.SerialNumberNotFoundException;

public class McLarenFactory {
	private static int currentVin = 1;

	public Car createBySerialNumber(int serial) throws SerialNumberNotFoundException {
		if(serial >= 1 && serial <= 3) {
			Car c = new Car(currentVin++, serial, "McLaren", "F1", "");
			if(serial == 1) {
				c.setColor("Red");
			} else if (serial == 2) {
				c.setColor("Magenta");
			} else if (serial == 3){
				c.setColor("Blue");
			}			
			
			return c;
		} 
		throw new SerialNumberNotFoundException();
	}

}
