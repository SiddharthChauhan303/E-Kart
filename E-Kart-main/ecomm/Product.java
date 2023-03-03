package ecomm;
// this is the abstract Product class which is the parent class for all the objects 
public abstract class Product {

	public int Quantity;
	// common queries to get category, unique name, price, and number available
	public abstract Globals.Category getCategory();
	public abstract String getName();
	public abstract String getProductID();
	public abstract float getPrice();
	public abstract int getQuantity();
}


