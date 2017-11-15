package com.revature.beans;

/**
 * @author USER
 *
 */
public class Car {

	private int vin;
	private int serialNumber;
	private String make;
	private String model;
	private String color;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int vin, int serialNumber, String make, String model, String color) {
		super();
		this.vin = vin;
		this.serialNumber = serialNumber;
		this.make = make;
		this.model = model;
		this.color = color;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + serialNumber;
		result = prime * result + vin;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (serialNumber != other.serialNumber)
			return false;
		if (vin != other.vin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", serialNumber=" + serialNumber + ", make=" + make + ", model=" + model + ", color="
				+ color + "]";
	}

}
