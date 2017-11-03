package shoppingList;

public class Item {
	private String name;
	private Items type;
	private double price;
	private int quantity;
	
	public Item(String name, Items type, double price, int quantity) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	
	}
	public String getName() {
		return name;
	}

	public Items getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}


	
}
