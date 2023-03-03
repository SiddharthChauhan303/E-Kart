package demo.kushal;
import java.util.ArrayList;
import ecomm.Globals;

import ecomm.Globals.Category;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
// this is the class of seller kushal which contains all of the products offered by the seller (modifiable)
public class Kushal extends Seller{
    private ArrayList<Product> book_list=new ArrayList<>();
    private ArrayList<Product> mobile_list=new ArrayList<>();
    private ArrayList<Product> items_list=new ArrayList<>();
    private Globals g=new Globals();
    public Kushal (String myID)
    {
        super(myID);
        Product Datastructures = new Book("DataStructures","kushal-Book1",300,8);
        Product DM=new Book("DiscreteMath", "kushal-Book2", 500, 17);
        Product ItStarsWithUs=new Book("ItStarsWithUs","kushal-Book3",190,25);
        book_list.add(Datastructures);
        book_list.add(ItStarsWithUs);
        book_list.add(DM);
        items_list.add(Datastructures);
        items_list.add(ItStarsWithUs);
        items_list.add(DM);
        Product Realme=new Mobile("RealME", 149000, "kushal-Mobile1", 10);
        Product Oneplus=new Mobile("OnePlus", 30000, "kushal-Mobile2", 5);
        Product Oppo=new Mobile("Oppo", 13500, "kushal-Mobile3", 15);
        Product NothingPhone=new Mobile("NothingPhone", 19000, "Kushal-Mobile4", 7);
        mobile_list.add(Realme);
        mobile_list.add(Oneplus);
        mobile_list.add(Oppo);
        mobile_list.add(NothingPhone);
        items_list.add(Realme);
        items_list.add(Oneplus);
        items_list.add(Oppo);
        items_list.add(NothingPhone);
    }
    @Override
    public void addPlatform(Platform thePlatform) {
        thePlatform.addSeller(this);
    }
    // find prod function
    @Override
    public ArrayList<Product> findProducts(Category whichOne) {
        
        String Item=g.getCategoryName(whichOne);   
        if (Item.equals("Book"))
        {
            return book_list;
        }
        else if (Item.equals("Mobile"))
        {
            return mobile_list;
        }
        return null;
    }
    // buy prod function
    @Override
    public boolean buyProduct(String productID, int quantity) {
        for (int i=0;i<items_list.size();i++)
        {
            if (items_list.get(i).getProductID().equals(productID) && items_list.get(i).getQuantity()>=quantity)
            {
                items_list.get(i).Quantity=items_list.get(i).Quantity-quantity;
                return true;
            }
        }
        return false;
    }

}
