package com.revature.spring.beans;

public class House {
	private String name;
	private Wall wall;
	private int numWalls;

	public House(String name, Wall wall, int numWalls) {
		super();
		this.name = name;
		this.wall = wall;
		this.numWalls = numWalls;
	}

	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wall getWall() {
		return wall;
	}

	public void setWall(Wall wall) {
		this.wall = wall;
	}

	public int getNumWalls() {
		return numWalls;
	}

	public void setNumWalls(int numWalls) {
		this.numWalls = numWalls;
	}

	@Override
	public String toString() {
		return "House [name=" + name + ", wall=" + wall + ", numWalls=" + numWalls + "]";
	}

}
