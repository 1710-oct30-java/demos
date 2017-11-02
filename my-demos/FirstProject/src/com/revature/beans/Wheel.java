package com.revature.beans;

public class Wheel {
	private int radius;
	private int width;
	private String material;

	public Wheel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wheel(int radius, int width, String material) {
		super();
		this.radius = radius;
		this.width = width;
		this.material = material;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + radius;
		result = prime * result + width;
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
		Wheel other = (Wheel) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (radius != other.radius)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wheel [radius=" + radius + ", width=" + width + ", material=" + material + "]";
	}

}
