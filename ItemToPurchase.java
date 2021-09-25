
public class ItemToPurchase {
	private String itemName;
	private String itemDescription;
	private int itemPrice;
	private int itemQuantity;
	
	//Parameterized constructor to assign itemName, itemDescription, itemPrice, and itemQuantity
	public ItemToPurchase(String inputItemName, String inputItemDescription, int inputItemPrice, int inputItemQuantity) {
		itemName = inputItemName;
		itemDescription = inputItemDescription;
		itemPrice = inputItemPrice;
		itemQuantity = inputItemQuantity;
	}
	
	//default constructor
	public ItemToPurchase() {
		itemName = "none";
		itemDescription = "none";
		itemPrice = 0;
		itemQuantity = 0;
	}
	
	//setter and getter for itemName
	public void setName(String inputName) {
		itemName = inputName;
	}
	public String getName() {
		return itemName;
	}
	
	//setter and getter for itemDescription
	public void setDescription(String inputDescription) {
		itemDescription = inputDescription;
	}
	
	public String getDescription() {
		return itemDescription;
	}
	
	//setter and getter for itemPrice
	public void setPrice(int inputPrice) {
		itemPrice = inputPrice;
	}
	public int getPrice() {
		return itemPrice;
	}
	
	//setter and getter for itemQuantity
	public void setQuantity(int inputQuantity) {
		itemQuantity = inputQuantity;
	}
	public int getQuantity() {
		return itemQuantity;
	}
	
	//print methods for ItemCost and ItemDescription
	public void printItemCost() {
		int totalPrice = itemQuantity * itemPrice;
		System.out.print(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + totalPrice);
	}
	
	public void printItemDescription() {
		System.out.print(itemName + ": " + itemDescription);
	}
}
