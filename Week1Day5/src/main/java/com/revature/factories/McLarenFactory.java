package com.revature.factories;

import com.revature.bean.Car;
import com.revature.bean.SerialNumberNotFoundException;

public class McLarenFactory {
	private static int currentVin = 0;
	
	public Car createBySerialNumber(int serial) throws SerialNumberNotFoundException {
		if(serial >= 1 && serial <= 4) {
			
			Car c = new Car(currentVin++, serial, "McLaren", "McLaren", "");
			if(serial == 1) c.setColor("red");
			else if(serial == 2) c.setColor("magenta");
			else {
				c.setColor("green");
			}
			
			return c;
		}

		
		throw new SerialNumberNotFoundException();
	}
}
