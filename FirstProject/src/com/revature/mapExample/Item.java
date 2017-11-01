package com.revature.mapExample;

public class Item
{
	private String name;
	private String type;
	private double price;
	public Item()
	{
		super();
		// TODO Auto-generated constructor stub
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
		return "Item [name=" + name + ", type=" + type + ", price=" + price
				+ "]";
	}
	
	
}
