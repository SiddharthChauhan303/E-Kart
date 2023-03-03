package demo.kushal;

import ecomm.Globals.Category;
import ecomm.Product;
// this is book child class of the parent class product
public class Book extends Product{
    
    public Book(String Name,String ProductID,float Price,int Quantity) 
    {
        this.Name = Name;
        this.Quantity = Quantity;
        this.ProductID = ProductID;
        this.Price=Price;
    }
    // getter functions
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
