package com.revature.javacore.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamLauncher
{
	static List<Item> items = new ArrayList();
	
	public static void main(String[] args)
	{
		
		
		items.add(new Item("Banana", "Fruit", 0.15));
		items.add(new Item("Tomato", "Vegetable", 0.3));
		items.add(new Item("Apple", "Fruit", 0.25));
		items.add(new Item("Laptop", "Electronic", 800));
		items.add(new Item("Cell Phone", "Electronic", 299));
		
		items.add(new Item("Peach", "Fruit", 0.35));
		items.add(new Item("Doritos", "Snack", 2.5));
		items.add(new Item("Watermelon", "Fruit", 0.2));
		items.add(new Item("Lays", "Snack", 3));
		items.add(new Item("Nikon Camera", "Electronic", 700));
		
		items.add(new Item("Nikon Lens", "Electronic", 2160));
		items.add(new Item("Canon Camera", "Electronic", 399));
		items.add(new Item("Orange", "Fruit", 0.4));
		items.add(new Item("Lettuce", "Vegetable", 0.45));
		items.add(new Item("Avocado", "Vegetable", 0.5));
		
		//Collections.sort(items, new Item());
		//displayList(items);
		
		Double totalPriceOfFruits = items.parallelStream().filter( fruit -> {
			if(fruit.getType().equals("Fruit"))
			{
				return true;
			}
			return false;
		})
		.map(fruit -> fruit.getPrice())
		.reduce( (acc, curr) -> acc + curr).get();
		
		System.out.println(totalPriceOfFruits);
	}
	
	// Display list of items
	public static void displayList(List<Item> items)
	{
		for(Item item:items)
		{
			System.out.println(item);
		}
	}
}
