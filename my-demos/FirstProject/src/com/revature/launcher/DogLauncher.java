package com.revature.launcher;

import com.revature.my.objects.Dog;

public class DogLauncher {
	public static void main(String[] args) {
		System.out.println("number of dogs: " + Dog.dogCount);
		Dog fido = new Dog("fido", "green", "boxer", 3, "female");
		fido.setAge(4);
		fido.setColor("brown");
		
		System.out.println(fido);
		
		Dog charlie = new Dog();
		System.out.println(charlie);
		
		charlie.setAge(4);
		charlie.setName("charlie");
		charlie.setColor("brown and red");
		charlie.setGender("male");
		charlie.setBreed("blood hound");
		
		System.out.println(charlie);
		
		System.out.println("number of dogs: " + Dog.dogCount);
		
	}
}
