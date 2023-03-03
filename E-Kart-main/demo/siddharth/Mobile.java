package demo.siddharth;

import ecomm.Globals.Category;
import ecomm.Product;
// this is mobile child class of the parent class product
public class Mobile extends Product {
    public Mobile(String Name, float Price, String ProductID, int Quantity)
    {
        this.Name = Name;
        this.Price = Price;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
    }
    // getter functions
    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public String getName() {
        return Name;
    }
    @Override
    public String getProductID() {
        return ProductID;
    }
    @Override
    public float getPrice() {
        return Price;
    }
    @Override
    public int getQuantity() {
        return Quantity;
    }
     String Name,ProductID;
     float Price;
}
