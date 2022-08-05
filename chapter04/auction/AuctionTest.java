

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AuctionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AuctionTest
{
    private Auction auction1;
    private Lot lot1;
    private Lot lot2;
    private Lot lot3;
    private Lot lot4;
    private Person person1; 
    private Person person2;
    
    /**
     * Default constructor for test class AuctionTest
     */
    public AuctionTest()
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
        auction1 = new Auction(); //create an Auction object called 'auction1'
        //create new Lot objects through the auction1 method enterLot()
        auction1.enterLot("pink dildo");
        auction1.enterLot("melted golf club");
        auction1.enterLot("my virginity");
        auction1.enterLot("lot number 10 sign");
        auction1.enterLot("dat ass");
        //create new Person objects called 'person1' and 'person2'
        person1 = new Person("roger");
        person2 = new Person("david");
        //show the lots for auction
        auction1.showLots();
        //remove a lot
        auction1.removeLot(4);
        //create mew Bod objects through the auction1 method makeABid();
        auction1.makeABid(1, person2, 25);
        auction1.makeABid(4, person1, 25); //this will fail because lot 5 has become lot 4
        auction1.makeABid(3, person1, 25);
        auction1.makeABid(3, person2, 20);
        auction1.makeABid(3, person2, 25);
        auction1.makeABid(3, person2, 30);
        //show the current status of the Lot objects
        auction1.showLots();
        //close the auction
        auction1.close();
        //show unsold Lots
        auction1.getUnsold();
        
        
        
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
