

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StockManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StockManagerTest
{
    private StockDemo stockDem1;
    private StockManager stockMan1;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;

    
    
    
    
    

    
    
    
    
    

    /**
     * Default constructor for test class StockManagerTest
     */
    public StockManagerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        stockDem1 = new StockDemo();
        stockMan1 = new StockManager();
        product1 = new Product(1, "rubber duckys");
        product2 = new Product(2, "plungers");
        product3 = new Product(3, "newspapers");
        stockMan1.addProduct(product1);
        stockMan1.addProduct(product2);
        stockMan1.addProduct(product3);
        stockMan1.delivery(1, 10);
        stockMan1.delivery(2, 4);
        product4 = new Product(1, "duplicate");
        product5 = new Product(10, "free willy");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
