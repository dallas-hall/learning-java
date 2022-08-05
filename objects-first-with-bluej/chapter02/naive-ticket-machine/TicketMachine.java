/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The status field from exercise 2.17
    private int status;
         
    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    
    
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }
    
    //exercuse 2.43 / 2.44- ticket machine price is always 1000
    public TicketMachine()
    {
        price = 1000;
        balance = 0;
        total = 0;
    }
    
    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    //exercise 2.33 - setting a new price+-
    public void setPrice(int newPrice)
    {
        //assign the new price of the ticket
        price = newPrice;
    }
        
    //exercise 2.35 - applying a discount
    public void setDiscount(int discountAmount)
    {
        //apply a discount to the current prive
        price -= discountAmount;
        //price = price - discountAmount;
    }
    
    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    //execercise 2.26 - returning the current total
    public int getTotal()
    {
        return total;
    }
    
    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        // Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        // Update the total collected with the balance.
        //total = total + balance;
        total += balance;
        
        // Clear the balance.
        balance = 0;
    }
          
    //exercise 2.37 - prompt dat guy for da moneyz
    public void prompt()
    {
        System.out.println("plz insert yo modda fuckin money dawg, we need " + (price - balance) + " amount of shizzle ma nizzle");
    }
    
    //exercise 2.41 - show da price
    public void showPrice()
    {
        System.out.println("da price of da fukn ticket iz " + price + ", get rekt");
    }
    
    //exercise 2.45 - get rid of da moneyz
    public void empty()
    {
        total = 0;
        System.out.println("all da moneyz is gone now bra");
    }
    
    public void exponentWhile(int inputNumber) 
    {
        //enter a number to be used for calculating exponents
        int number = inputNumber;
        int exponent = 0;
        int endNum = 16;
        int index = 0;
        
        while(index != endNum) {
            System.out.println(Math.pow(number, exponent));
            exponent++; //plus 1 I.E. - exponent = exponent + 1;
            index++; //plus 1
        }
     }
     
    public void exponentFor(int inputNumber)
    {
        //enter a number to be used for calculating exponents
        int number = inputNumber;
        int exponent = 0;
        int endNumber = 16;
        int index;
       
        for (index = 0; index != endNumber; index++) {
            System.out.println(Math.pow(number, exponent));
            exponent++;
        }
    }
}
