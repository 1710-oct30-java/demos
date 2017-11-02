package com.revature.my.objects;

public class Dog {
	public static int dogCount;
	
	private String name;
	private String color;
	private String breed;
	private int age;
	private String gender;

	public Dog() {
		super();
		breed = "ok";
		dogCount ++;
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, String color, String breed, int age, String gender) {
		this();
		this.name = name;
		this.color = color;
		this.breed = breed;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", color=" + color + ", breed=" + breed + ", age=" + age + ", gender=" + gender
				+ "]";
	}
	
	

}
