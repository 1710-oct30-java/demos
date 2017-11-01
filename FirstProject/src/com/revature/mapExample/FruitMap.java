package com.revature.mapExample;

import java.util.ArrayList;
import java.util.List;

public class FruitMap
{
	public static void main(String[] args)
	{
		List<Item> itemList = new ArrayList<>();
		
		for (int i =0; i < 15; i++)
		{
			itemList.add(new Item("Banana", "Fruit", 2.00));
		}
		
		for (int i = 0; i < 15; i = i+2)
		{
			itemList.add(new Item("Fridge", "Electronics", 1500.00));
			
		}
		
		for (int i = 0; i < 15; i = i+3)
		{
			itemList.add(new Item("Flops", "Shoes", 15.00));
			
		}
		
		
		System.out.println(itemList);
		
		Double totalPrice = itemList.parallelStream().filter(p -> {
			if ("Banana".equals(p.getName()))
			{
				return true;
			}
			return false;
		}).map(p -> p.getPrice())
				.reduce((acc, cur) -> acc+cur).get();
		
		System.out.println(totalPrice);
		/*Double totalPriceOfSubarus = carList.parallelStream().filter( car -> {
			if("subaru".equals(car.getMake())) {
				return true;
			}
			return false;
		})
		.map(car -> car.getPrice())
		.reduce((acc, cur) -> acc+cur).get();*/
	}
}
