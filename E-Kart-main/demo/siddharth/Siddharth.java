package demo.siddharth;
import java.util.ArrayList;

import ecomm.Globals.Category;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import ecomm.Globals;

public class Siddharth extends Seller {
    // this is the class of seller siddharth which contains all of the products offered by the seller (modifiable)
    private ArrayList<Product> book_list=new ArrayList<>();
    private ArrayList<Product> mobile_list=new ArrayList<>();
    private ArrayList<Product> items_list=new ArrayList<>();
    private Globals g=new Globals();
    public Siddharth (String myID)
    {
        super(myID);
        Product ItEndsWithUs = new Book("ItEndsWithUs","siddharth-Book1",150,10);
        Product NormalPeople=new Book("NormalPeople", "siddharth-Book2", 200, 15);
        book_list.add(ItEndsWithUs);
        book_list.add(NormalPeople);
        items_list.add(ItEndsWithUs);
        items_list.add(NormalPeople);
        Product Apple=new Mobile("Apple", 85000, "siddharth-Mobile1", 10);
        Product Vivo=new Mobile("Vivo", 25000, "siddharth-Mobile2", 5);
        Product Oppo=new Mobile("Oppo", 15000, "siddharth-Mobile3", 15);
        Product Samsung = new Mobile("Samsung", 30000, "siddharth-Mobile4",18) ;
        Product RealMe = new Mobile("Realme", 15000, "siddharth-Mobile5", 16);        
        mobile_list.add(Apple);
        mobile_list.add(Vivo);
        mobile_list.add(Samsung);
        mobile_list.add(RealMe);
        mobile_list.add(Oppo);
        items_list.add(Apple);
        items_list.add(Vivo);
        items_list.add(Samsung);
        items_list.add(Oppo);
        items_list.add(RealMe);
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
    // get prod function
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
