import java.util.ArrayList;
import java.util.Iterator; //ex 4.51
//import java.util.Collections; //ex4.51

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description)); //create new Lot Object, and pass into ArrayList via add method
        /**
         * lots.add(new Lot(nextLotNumber, description)); //create new Lot Object, and pass into ArrayList via add method
         *         
         * above (anonymous object creation) is the same as:
         * 
         * Lot furtherlot = new Lot(nextLotNumber, description);
         * lots.add(furtherLot);
         * 
         * If furtherLot variable isn't needed elsewhere in the method, use above, if needed, use this one.
         * 
         */
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) { //element_type (Lot object) element_name lots from collection of Lot objects called lots
            System.out.println(lot.toString());
        }
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLotsIterator() {
        Iterator<Lot> it = lots.iterator();
        /**
         * create Iterator with 'Lot' Object on 'lots' collection, store in 'it' local variable. 
         * call iterator method from Collection, returns iterator over elements in it.
         */
        while (it.hasNext()) { //while loop - boolean condition of it having another index
            Lot selectedLot = it.next(); //selectedLot variable is assigned the next object
            System.out.println(selectedLot.toString());
        }  
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        //Lot selectedLot = getLot(lotNumber); //ex 4.47
        Lot selectedLot = getLotIterator(lotNumber); //ex 4.52

        if(selectedLot != null) {
            /**
             * ex 4.47 - rewrite below as an anonymous object (page 134)
             * 
             * Bid bid = new Bid(bidder, value); //type name IS ASSIGNED THE VALUE OF result of method calls
             * boolean successful = selectedLot.bidFor(bid);
             * 
             */
            //Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));

            if(successful) {
                System.out.println("The bid for lot number " +
                    lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                    " already has a bid of: " +
                    highestBid.getValue());
            }
        }
        else
        {
            System.out.println("The lot number entered is invalid.");
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        try
        {
            if(lotNumber >= 1 && lotNumber < nextLotNumber) {
                // The number seems to be reasonable.

                Lot selectedLot = lots.get(lotNumber -1);

                // Include a confidence check to be sure we have the
                // right lot.
                if(selectedLot.getNumber() != lotNumber) {
                    System.out.println("Internal error: Lot number " +
                        selectedLot.getNumber() +
                        " was returned instead of " +
                        lotNumber);
                    // Don't return an invalid lot.
                    selectedLot = null;
                }
                return selectedLot;
            }
            else {
                System.out.println("Lot number: " + lotNumber +
                    " does not exist.");
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    /**
     * ex 4.51 - rewrite of getLot so it does not rely on a lot with a particular number being stored at the index below 
     * it (lot number - 1).  For example, if a lot is removed, all lot objects above it will be moved down one spot in 
     * the ArrayList, so n-1 won't work.  You may assume that lots are always stored in increasing order according to their
     * lot numbers.
     *  
     */

    public Lot getLotIterator(int lotNumber)
    {
        if(lotNumber >= 1 && lotNumber < nextLotNumber) { //check that input is valid

            Iterator<Lot> it = lots.iterator();
            /**
             * create Iterator with 'Lot' Object on 'lots' collection, store in 'it' local variable. 
             * call iterator method from Collection, returns iterator over elements in it.
             */

            while (it.hasNext()) { //while loop - boolean condition of it having another index
                Lot selectedLot = it.next(); //selectedLot variable is assigned the next object

                if(selectedLot.getNumber() == lotNumber) { // 
                    /**
                     * check input number == object number, if it does, return the object
                     * if it doesn't, go to next object in collection and check it
                     */    
                    return selectedLot;
                }
            }
            System.out.println("Lot number: " + lotNumber + " does not exist.");
            return null;
        }
        else { //if no lot number is found, because it has been deleted (future method to be written)
            System.out.println("Lot number: " + lotNumber + " does not exist.");
            return null;
        }
      }

    /**
     * ex 4.52 - make getLot into removeLot
     */

    public Lot removeLot(int lotNumber)
    {
        if(lotNumber >= 1 && lotNumber < nextLotNumber) { //check that input is valid

            Iterator<Lot> it = lots.iterator();
            /**
             * create Iterator with Lot Object on lots collection, store in it local variable. 
             * call iterator method from Collection, returns iterator over elements in it.
             */

            while (it.hasNext()) { //while loop - boolean condition of it having another index
                Lot selectedLot = it.next(); //selectedLot variable is assigned the next object

                if(selectedLot.getNumber() == lotNumber) { //if object's number in selectedLot matches input
                    /**
                     * check input number == object number, if it does, return the object
                     * if it doesn't, go to next object in collection and check it
                     */     
                    it.remove();
                    return selectedLot;
                }
            }
        }
        else { //if no lot number is found, because it has been deleted (future method to be written)
            System.out.println("Lot number: " + lotNumber +
                " does not exist.");
            return null;
        }
        return null; //return null if input is invalid
    }

    /**
     * ex 4.48 - add a close method. any Lots with a bid = sold, look for highestBid of null.
     * 
     */
    public void close()
    {
        System.out.println();
        for (Lot lot : lots) { //for each loop on the element type of Lot stored in loop variable lot from the lots ArrayList
            Bid sold = lot.getHighestBid();

            if (sold == null) {
                System.out.println("Lot number " + lot.getNumber() + " which was " +
                    lot.getDescription() + " was not sold.");

                /**
                 * Chaining method calls
                 * 
                 * Auction objects store anonymous Lot objects (in lots ArrayList); 
                 * each anonymous Lot object can store an anonymous Bid object (in getHighestBid); 
                 * each anonymous Bid object stores a Person object (in bidder).
                 * 
                 * Note: in this case no Bid object was stored as getHighestBid == null.
                 * 
                 * first line: asks Lot object to give the lot number.
                 * second line: asks Lot object to give the lot description.
                 * 
                 */

            }
            else {
                System.out.println("The winner is: " + lot.getHighestBid().getBidder().getName() +
                    ", with a bid of: " + lot.getHighestBid().getValue() + ". They won the: " +
                    lot.getDescription());
                /**
                 * Chaining method calls.
                 * 
                 *  Auction objects store anonymous Lot objects (in lots ArrayList); 
                 * each anonymous Lot object can store an anonymous Bid object (in getHighestBid); 
                 * each anonymous Bid object stores a Person object (in bidder).
                 * 
                 * first line: tells Lot object to get the highest bid from Bid object;
                 *             Bid object is returned, asked to return a Person object; 
                 *             Person object is returned, asked to give its name.
                 *             
                 * second line: tells lot object to get the highest bid from Bid object;
                 *              Bid object is returned, asked to give its current value.
                 *              
                 * third line: tells Lot object to give its current description.             
                 * 
                 */

            }
        }
    }

    /**
     * ex 4.49 - unsold method to get all Lot objects with highestBid == null
     */

    //public @SuppressWarnings("unchecked") ArrayList<Lot> getUnsold() //stupid java compile warning, fuka u
    public ArrayList<Lot> getUnsold()
    {
        /**
         * Chaining method calls.
         * 
         * Auction objects store anonymous Lot objects (in lots ArrayList); 
         * each anonymous Lot object can store an anonymous Bid object (in getHighestBid); 
         * each anonymous Bid object stores a Person object (in bidder).
         * 
         */

        System.out.println(); //print new line for readability
        //ArrayList<Lot> unsold; //define new ArrayList of Lot in unsold
        //unsold = new ArrayList<Lot>(); //create new ArrayList in unsold

        ArrayList<Lot> unsold = new ArrayList<Lot>(); //same as above - taken from video solution
        //create an ArrayList called 'unsold' that holds the 'Lot' object.
        for (Lot lot : lots) { //for each loop over the ArrayList lots, Lot Object stored in lot temporarilty
            Bid bid = lot.getHighestBid(); //stores the Bid object's highest bid in bid (taken from lot variable)  

            if (bid == null) { //checks if sold == null 
                //unsold.add(new Lot(lot.getNumber(), lot.getDescription()));
                //add the unsold lot to the unsold ArrayList
                unsold.add(lot); //same as above - taken from video solution
                /**
                 * Anonymous object statement
                 * 
                 * unsold ArrayList uses its method add to create a new Lot object
                 * which uses the lot variable for its constructor, getting the lot number and description
                 * 
                 */
                System.out.println(lot.toString()); //test for each loop
            }
        }
        return unsold;
    }
}
