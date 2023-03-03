package demo;
import java.util.*;
import java.io.*;
import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import ecomm.Globals.Category;
// this is the demo platform which is the java side of the client
public class DemoPlatform extends Platform {
    ArrayList<Seller> seller_list = new ArrayList<Seller>();
	@Override
	public boolean addSeller(Seller aSeller) {
		seller_list.add(aSeller);
		return true;
	}
	// this function reads the PortalToPlatform file
	@Override
	public void processRequests() {
		try
		{
			// file handling begins here 
			Scanner sc = new Scanner(new File("PortalToPlatform.txt"));
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				String arr[]=line.split(" ");
				String PortalID=arr[0];
				String RequestID=arr[1];
				
				if (arr.length==3)//case of Start command
				{
					String response = PortalID + " " + RequestID + " " + "Mobile " + "Book ";
					try {
						FileWriter writer = new FileWriter("PlatformToPortal.txt", true);
						writer.write(response);
						writer.write("\r\n"); 
						writer.close();
					} 
					// error handling
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				// this is the file handling part
				else if (arr.length==4)//case of List Command
				{
					ArrayList<Product> ListOfProducts=new ArrayList<>();
					String category=arr[3];
					// enum Category declared in ecomm/Globals.java
					Category categoryType=null;
					if (category.equals("Book"))
					{
						categoryType=Category.Book;
					}
					if (category.equals("Mobile"))
					{
						categoryType=Category.Mobile;
					}
					// this retrieves the List of books or mobiles from each seller depending upon request
					for (int i=0;i<seller_list.size();i++)
					{
						ArrayList<Product> ProductsFromSellers=new ArrayList<>();
						ProductsFromSellers = seller_list.get(i).findProducts(categoryType);
						for (int j=0;j<ProductsFromSellers.size();j++)
						{
							ListOfProducts.add(ProductsFromSellers.get(j));
						}
					}
					// sorting done using comparator in increasing order of price
					Collections.sort(ListOfProducts,new Comparison());
					// file writing is performed over all the products offered by sellers
					try {
						FileWriter writer = new FileWriter("PlatformToPortal.txt", true);
						for(int i=0;i<ListOfProducts.size();i++)
						{
							String response=PortalID+" "+RequestID+" "+ListOfProducts.get(i).getName()+" "+ListOfProducts.get(i).getProductID()+
							" "+ListOfProducts.get(i).getPrice()+" "+ListOfProducts.get(i).getQuantity();
							writer.write(response);
							writer.write("\r\n"); 
						}
						writer.close();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (arr.length ==5)//Case of Buy Command
				{
					// this checks if the buy request is performed or not
					String response = PortalID + " " + RequestID + " " + "Failure";
					for (int i = 0; i < seller_list.size(); i++)
					{
						if (seller_list.get(i).buyProduct(arr[3], Integer.parseInt(arr[4])))
						{
							response = PortalID + " " + RequestID + " " + "Success";
						}
					}
					// error handling
					try {
						FileWriter writer = new FileWriter("PlatformToPortal.txt", true);
						writer.write(response);
						writer.write("\r\n"); 
						writer.close();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
				}						
			}
			// file deletion (cleaning)
			File f = new File("PortalToPlatform.txt");
			f.delete();
		}
		catch(FileNotFoundException e) 
		{
			;
		}
	}
}
