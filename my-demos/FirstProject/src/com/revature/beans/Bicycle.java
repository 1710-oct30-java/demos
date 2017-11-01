package com.revature.beans;

import java.util.Arrays;

public class Bicycle {
	private int id;
	private Wheel[] wheels;
	private String material;
	private String color = "red";

	public Bicycle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bicycle(int id, Wheel[] wheels, String material, String color) {
		super();
		this.id = id;
		this.wheels = wheels;
		this.material = material;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Wheel[] getWheels() {
		return wheels;
	}

	public void setWheels(Wheel[] wheels) {
		this.wheels = wheels;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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
		result = prime * result + id;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + Arrays.hashCode(wheels);
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
		Bicycle other = (Bicycle) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (!Arrays.equals(wheels, other.wheels))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", wheels=" + Arrays.toString(wheels) + ", material=" + material + ", color="
				+ color + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("bike " + id + " is now being removed from memory");
	}

}
