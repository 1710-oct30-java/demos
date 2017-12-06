package com.revature.spring.beans;

public class WallImpl implements Wall {
	private String material;

	public WallImpl() {
		super();
		System.out.println("no args constructor");
	}

	public WallImpl(String material) {
		super();
		System.out.println("args constructor");
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "WallImpl [material=" + material + "]";
	}

}
