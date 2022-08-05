import java.util.ArrayList;
import java.util.Iterator; //ex 4.57

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    public void printAll()
    {
        /*
         * create Iterator with Product Object in stock collection, store in it local variable. 
         * call iterator method from Collection, returns iterator over elements in it.
         */
        Iterator<Product> it = stock.iterator(); 
                
        while (it.hasNext()) { // while loop - boolean condition of having another index
            Product product = it.next(); //product variable is assigned the next object
            System.out.println(product.toString());
        }
    }
    
    /** ex 4.60.2 - modify this so a new product cant use an exiting ID - for each
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProductVer2(Product item)
    {
        int check = item.getID();
        for (Product product : stock) {
            if (product.getID() == check) {
                System.out.println("Sorry that ID number already exists.");
                return;
            }
        }
        stock.add(item);
    }
    
    /** ex 4.60.2 - modify this so a new product cant use an existing ID - iterator
     * Add a product to the list.
     * @param item The item to be added.
     */
    
    public void addProductVer3(Product item)
    {
        Iterator<Product> it = stock.iterator();
        
        while(it.hasNext()) {
            Product product = it.next();
            
            if (product.getID() == item.getID()) {
                System.out.println("Sorry that ID number already exists.");
                return;
            }
        }
        stock.add(item);
    }
    
    /** ex 4.59
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        
        if (product == null) {
            return;
        }
        else {
            product.increaseQuantity(amount);
        }
        
    }
    
    /** ex 4.57
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Iterator<Product> it = stock.iterator(); 
        
        /**
             * create Iterator with Product Object in stock collection, store in it local variable. 
             * call iterator method from Collection, returns iterator over elements in it.
             */
        
        while (it.hasNext()) { // while loop - boolean condition of having another index
            Product product = it.next(); //product variable is assigned the next object
            
            if (product.getID() == id) { //if object's id in product matchs input check
                return product; //return the object
            }
        }
        return null; //return null if nothing is found
    }
    
    /** ex 4.58
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        
        if (product == null) {
            return -1;
        }
        else if (product.getQuantity() != 0) {
            return product.getQuantity();
        }
        else {
        return 0;
        }
    }

    /** ex 4.57
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product product : stock) { // for each loop - Element type, variable : collection
            System.out.println(product.toString()); //print toString method from object in product
        }
    }
    
    /**
     * ex 4.60.1 - print details of all products with stock levels below inputted threshold
     */
    
    public void printLowStock(int threshold)
    {
        for (Product product : stock) {
            if (product.getQuantity() < threshold)
            {
                System.out.println(product.toString());
            }
        }
    }
    
    /** ex 4.60.3 -string searches
     * 
     */
    
    public Product findProductExact(String name)
    {
        Iterator<Product> it = stock.iterator();
        String s1 = name;
        while(it.hasNext()) {
            Product product = it.next();
            String s2 = product.getName();
            if (s1.equals(s2)) {
                return product;
            }
        }
        return null;    
    }
    
        public Product findProductContains(String name)
    {
        Iterator<Product> it = stock.iterator();
        String s1 = name;
        while(it.hasNext()) {
            Product product = it.next();
            String s2 = product.getName();
            if (s2.contains(s1)) {
                return product;
            }
        }
        return null;    
    }
}
