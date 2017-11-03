package shoppingList;

import java.util.Arrays;
import java.util.List;


public class ShoppingList {
	
	public static void main(String[] args) {
		Item[] items = {
			/*            item name         item type           $     quantity */
				new Item("banana", 			Items.FRUIT, 		1.50, 3),
				new Item("chicken breast", 	Items.MEAT, 		4.00, 2),
				new Item("carrots", 		Items.VEGETABLE,	1.25, 5),
				new Item("pasta", 			Items.GRAIN, 		3.00, 2),
				new Item("bottled water", 	Items.BEVERAGE, 	1.00, 3),
				new Item("hamburger", 		Items.MEAT, 		4.00, 2),
				new Item("hamburger buns", 	Items.GRAIN, 		2.00, 2),
				new Item("lettuce", 		Items.VEGETABLE,	4.00, 1),
				new Item("ice cream", 		Items.SNACK, 		3.00, 1),
				new Item("crab", 			Items.MEAT, 		5.00, 2),
				new Item("broccoli", 		Items.VEGETABLE,	4.00, 2),
				new Item("onions", 			Items.VEGETABLE,	4.00, 3),
				new Item("sourdough bread", Items.GRAIN, 		4.00, 2),
				new Item("chips", 			Items.SNACK, 		3.00, 4),
				new Item("potatoes", 		Items.VEGETABLE,	4.00, 2),
				new Item("Corncobs", 		Items.GRAIN, 		4.00, 1),
				new Item("oatmeal", 		Items.GRAIN, 		2.00, 2),
				new Item("yogurt", 			Items.DAIRY, 		1.00, 2),
				new Item("milk", 			Items.DAIRY, 		4.00, 2),
				new Item("cucumber", 		Items.VEGETABLE,	4.00, 2),
				new Item("zuccini", 		Items.VEGETABLE,	4.00, 2)	
		};
		
		List<Item> myShoppingList = Arrays.asList(items);
		
		double totalPrice = myShoppingList.stream()
			.filter(i -> i.getType() == Items.VEGETABLE)
			.map(i -> (double)( i.getPrice() * i.getQuantity() ))
			.reduce((acc, cur) -> acc+cur)
			.get();
	
		System.out.printf("Total price of vegtables: $%.2f%n", totalPrice);
	}
}
