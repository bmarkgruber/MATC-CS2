import java.util.ArrayList;

public class ShoppingCart {
	private String customerName;
	private String currentDate;
	private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
	
	//parameterized constructor with customerName and customerDate as parameters
	public ShoppingCart(String inputCustomerName, String inputCurrentDate) {
		customerName = inputCustomerName;
		currentDate = inputCurrentDate;
	}
	
	//default constructor
	public ShoppingCart() {
		customerName = "none";
		currentDate = "January 1, 2016";
	}
	
	//customer name getter
	public String getCustomerName() {
		return customerName;
	}
	
	//date getter
	public String getDate() {
		return currentDate;
	}
	
	public void addItem(ItemToPurchase inputItem) {
		cartItems.add(inputItem);
	}
	
	public void removeItem(String itemName) {
		boolean found = false;
		int i = 0;
		
		while (i < cartItems.size() && !found) {
			if (cartItems.get(i).getName().equals(itemName)) {
				cartItems.remove(i);
				found = true;
			}
			if (i == cartItems.size() - 1 && !found) {
				System.out.println("Item not found in cart. Nothing removed.");
			}
			++i;
		}
	}
	
	public void modifyItem(ItemToPurchase itemToModify) {
		boolean found = false;
		int i = 0;
		
		while (i < cartItems.size() && !found) {
			if (cartItems.get(i).getName().equals(itemToModify.getName())) {
				found = true;
				if (!itemToModify.getDescription().equals("none")) {
					cartItems.get(i).setDescription(itemToModify.getDescription());
				}
				if (itemToModify.getPrice() != 0) {
					cartItems.get(i).setPrice(itemToModify.getPrice());
				}
				if (itemToModify.getQuantity() != 0) {
					cartItems.get(i).setQuantity(itemToModify.getQuantity());
				}
			}
			if (i == cartItems.size() - 1 && !found) {
				System.out.println("Item not found in cart. Nothing modified.");
			}
			++i;
		}
	}
	
	public int getNumItemsInCart() {
		int totalQuantity = 0;
		for (int i = 0; i < cartItems.size(); ++i) {
			totalQuantity += cartItems.get(i).getQuantity();
		}
		return totalQuantity;
	}
	
	public int getCostOfCart() {
		int costOfCart = 0;
		for (int i = 0; i < cartItems.size(); ++i) {
			costOfCart += ((cartItems.get(i)).getPrice() * cartItems.get(i).getQuantity());
		}
		return costOfCart;
	}
	
	public void printTotal() {
		int totalQuantity = 0;
		for (int i = 0; i < cartItems.size(); ++i) {
			totalQuantity += cartItems.get(i).getQuantity();
		}
		
		if (cartItems.size() == 0) {
			System.out.println(customerName + "'s Shopping Cart - " + currentDate);
			System.out.println("Number of Items: " + totalQuantity);
			System.out.println("");
			System.out.println("SHOPPING CART IS EMPTY");
			System.out.println("");
			System.out.println("Total: $0");
			System.out.println("");
		}
		else {
			System.out.println(customerName + "'s Shopping Cart - " + currentDate);
			System.out.println("Number of Items: " + totalQuantity);
			System.out.println("");
			
			//iterating though cart and calculating and printing quantity of item * price of item
			for (int i = 0; i < cartItems.size(); i++) {
				int totalCostOfItem = cartItems.get(i).getQuantity() * cartItems.get(i).getPrice();
				System.out.println(cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity() + " @ $" + cartItems.get(i).getPrice() + " = $" + totalCostOfItem);
			}
			System.out.println("");
			
			//calculating total cost of all items
			int totalCost = 0;
			for (int i = 0; i < cartItems.size(); ++i) {
				totalCost += cartItems.get(i).getQuantity() * cartItems.get(i).getPrice();
			}
			System.out.println("Total: $" + totalCost);
			System.out.println("");
		}
	}
	
	public void printDescriptions() {
		System.out.println(customerName + "'s Shopping Cart - " + currentDate);
		System.out.println("");
		System.out.println("Item Descriptions");
		for (int i = 0; i < cartItems.size(); i++) {
			System.out.println(cartItems.get(i).getName() + ": " + cartItems.get(i).getDescription());
		}
	}
}
