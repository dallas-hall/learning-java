
/**
 * Write a description of class TestData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestData
{
    // instance variables - replace the example below with your own
    private Auction auction1;
    private Person person1;
    private Person person2;
    
    /**
     * Constructor for objects of class TestData
     */
    public TestData()
    {
        auction1 = new Auction(); //create an Auction object called 'auction1'
        //create new Lot objects through the auction1 method enterLot()
        System.out.println("\n### Create 3 lot objects ###");
        auction1.enterLot("lot one - used pink dildo");
        auction1.enterLot("lot two - new fidget spinner");
        auction1.enterLot("lot three - some slut's phone number");
        //create new Person objects called 'person1' and 'person2'
        System.out.println("\n### Create 2 person objects ###");
        person1 = new Person("roger \"cranky\" waters");
        person2 = new Person("david \"the filler\" gilmour");
        //show the lots for auction
        System.out.println("\n### show all lots ###");
        auction1.showLots();
        System.out.println("\n### add bid object to lot 3 ###");       
        auction1.makeABid(3, person1, 55);
        System.out.println("\n*** show all lots (iterator) ***");
        auction1.showLotsIterator();
        //remove a lot
        System.out.println("\n### remove lot 2 ###");
        auction1.removeLot(2);
        //show the lots for auction
        System.out.println("\n### add another bid object to lot 3 and 2  ###");       
        auction1.makeABid(3, person2, 60);
        auction1.makeABid(2, person2, 60);
        System.out.println("\n### show all lots ###");
        auction1.showLots();
        System.out.println("\n*** show all lots (iterator) ***");
        auction1.showLotsIterator();
        auction1.close();
        auction1.getUnsold();
    }
}