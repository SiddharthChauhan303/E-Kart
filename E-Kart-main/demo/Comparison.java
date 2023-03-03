package demo;
// this is the comparator which sorts the product list on the basis of increasing order of their price
import java.util.Comparator;

import ecomm.Product;

public class Comparison implements Comparator<Product>{
    public int compare(Product p1,Product p2)
    {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
