package demo.arjun;
import java.util.ArrayList;
import ecomm.Globals.Category;
import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
// this is the class of seller arjun which contains all of the products offered by the seller (modifiable)
public class Arjun extends Seller {
    private ArrayList<Product> book_list=new ArrayList<>();
    private ArrayList<Product> mobile_list=new ArrayList<>();
    private ArrayList<Product> items_list=new ArrayList<>();
    private Globals g=new Globals();
    public Arjun (String myID)
    {
        super(myID);
        Product LetUsC = new Book("LetUsC","arjun-Book1",150,10);
        Product LetUsPython=new Book("LetUsPython", "arjun-Book2", 200, 15);
        Product LetUsJava=new Book("LetUsJava","arjun-Book3",250,20);
        book_list.add(LetUsC);
        book_list.add(LetUsJava);
        book_list.add(LetUsPython);
        items_list.add(LetUsC);
        items_list.add(LetUsJava);
        items_list.add(LetUsPython);
        Product Apple=new Mobile("Apple", 85000, "arjun-Mobile1", 10);
        Product Vivo=new Mobile("Vivo", 25000, "arjun-Mobile2", 5);
        Product Oppo=new Mobile("Oppo", 15000, "arjun-Mobile3", 15);
        mobile_list.add(Apple);
        mobile_list.add(Vivo);
        mobile_list.add(Oppo);
        items_list.add(Apple);
        items_list.add(Vivo);
        items_list.add(Oppo);
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
