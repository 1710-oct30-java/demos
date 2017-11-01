package com.revature.javacore.streams;

import java.util.Comparator;

public class Item implements Comparator<Item>
{
	private String name;
	private String type;
	double price;
	
	public Item()
	{
		
	}
	
	public Item(String name, String type, double price)
	{
		super();
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return name + " - $" + price + " - " + type;
	}

	// Sorts by item price
	@Override
	public int compare(Item item1, Item item2)
	{
		if(item1.getPrice() > item2.getPrice())
		{
			return 1;
		}
		
		else if(item1.getPrice() < item2.getPrice())
		{
			return -1;
		}
		
		return 0;
	}
	
}
