import java.util.Scanner;

public class ShoppingCartManager {
	
	public static void printMenu() {
		System.out.println("MENU");
		System.out.println("a - Add item to cart");
		System.out.println("d - Remove item from cart");
		System.out.println("c - Change item quantity");
		System.out.println("i - Output items' descriptions");
		System.out.println("o - Output shopping cart");
		System.out.println("q - Quit");
	}
	
	public static void executeMenu(char menuInput, ShoppingCart inputShoppingCart, Scanner inputScnr) {
		if (menuInput == 'a') {
			String inputItemName;
			String inputItemDescription;
			int inputItemPrice;
			int inputItemQuantity;
			
			System.out.println("ADD ITEM TO CART");
			System.out.println("Enter the item name:");
			inputScnr.nextLine();
			inputItemName = inputScnr.nextLine();
			System.out.println("Enter the item description:");
			inputItemDescription = inputScnr.nextLine();
			System.out.println("Enter the item price:");
			inputItemPrice = inputScnr.nextInt();
			System.out.println("Enter the item quantity:");
			inputItemQuantity = inputScnr.nextInt();
			System.out.println("");
			
			ItemToPurchase newItem = new ItemToPurchase(inputItemName, inputItemDescription, inputItemPrice, inputItemQuantity);
			
			inputShoppingCart.addItem(newItem);
		}

		if (menuInput == 'd') {
			String itemToBeRemoved;
			
			System.out.println("REMOVE ITEM FROM CART");
			System.out.println("Enter name of item to remove:");
			inputScnr.nextLine();
			itemToBeRemoved = inputScnr.nextLine();
			
			inputShoppingCart.removeItem(itemToBeRemoved);
			System.out.println("");
		}
		
		if (menuInput == 'c') {
			String nameOfItemToModify;
			int updatedQuantity;
			
			System.out.println("CHANGE ITEM QUANTITY");
			System.out.println("Enter the item name:");
			inputScnr.nextLine();
			nameOfItemToModify = inputScnr.nextLine();
			System.out.println("Enter the new quantity:");
			updatedQuantity = inputScnr.nextInt();
			
			ItemToPurchase updatedItem = new ItemToPurchase();
			
			updatedItem.setName(nameOfItemToModify);
			updatedItem.setQuantity(updatedQuantity);
			inputShoppingCart.modifyItem(updatedItem);
			
			System.out.println("");
			
		}
		
		if (menuInput == 'i') {
			System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
			inputShoppingCart.printDescriptions();
			System.out.println("");
		}
		
		if (menuInput == 'o') {
			System.out.println("OUTPUT SHOPPING CART");
			inputShoppingCart.printTotal();
		}
		
		if (menuInput == 'q') {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		String customerName;
		String todaysDate;
		char userSelection;
		
		//get and print customers name and date
		System.out.println("Enter Customer's Name:");
		customerName = scnr.nextLine();
		System.out.println("Enter Today's Date:");
		todaysDate = scnr.nextLine();
		System.out.println("");
		
		System.out.println("Customer Name: " + customerName);
		System.out.println("Today's Date: " + todaysDate);
		System.out.println("");
		
		//create a new ShoppintCart with customers name and today's date
		ShoppingCart customerCart = new ShoppingCart(customerName, todaysDate);
		
		//print menu, get users choice, and execute users choice
		ShoppingCartManager.printMenu();
		System.out.println("");
		System.out.println("Choose an option:");
		userSelection = scnr.next().charAt(0);
		while(true) {
			if (userSelection != 'a' && userSelection != 'd' && userSelection != 'c' && userSelection != 'i' && userSelection != 'o' && userSelection != 'q') {
				System.out.println("Choose an option:");
				userSelection = scnr.next().charAt(0);
			}
			else {
				ShoppingCartManager.executeMenu(userSelection, customerCart, scnr);
				ShoppingCartManager.printMenu();
				System.out.println("");
				System.out.println("Choose an option:");
				userSelection = scnr.next().charAt(0);
			}
		}
	}
}
