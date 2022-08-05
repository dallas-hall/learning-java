/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
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
    //exercise 2.55
    private double saving;
    //exercise 2.56
    private double mean;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    /**
     * {
     *   if(amount > 0) {
     *       balance = balance + amount;
     *   }
     *   else {
     *       System.out.println("Use a positive amount rather than: " +
     *           amount);
     *}
    }
     */
    //exercise 2.48
    {
        if (amount <= 0) {
            System.out.println("look fukwad, pull ya fukn hed in n put sum moneyz in");
        }
        else {
            balance += amount;
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    /** zee old one before exercise 2.62
     * {
    *    if(balance >= price) {
    *        // Simulate the printing of a ticket.
    *        System.out.println("##################");
    *        System.out.println("# The BlueJ Line");
    *        System.out.println("# Ticket");
    *        System.out.println("# " + price + " cents.");
    *        System.out.println("##################");
    *        System.out.println();
    *
    *        // Update the total collected with the price.
    *        total = total + price;
    *        // Reduce the balance by the prince.
    *        balance = balance - price;
    *    }
    *    else {
    *        System.out.println("You must insert at least: " + (price - balance) + " more cents.");
    *    }
    }*/
    //exercise 2.62
    {
        int amountLeftToPay = (price - balance);
        if (amountLeftToPay <= 0) {
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();
            
            total += price;
            balance -= price;
        }
        else {
            System.out.println("yo dawg, insert " + amountLeftToPay);
        }
    }
    
    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;

    }

    //exericse 2.55
    public void exercise2point55(double discount)
    {
        saving = price * discount;
        System.out.println(saving);

    }

    //exericse 2.56
    public void exercise2point56(double count)
    {
        mean = total / count;
        System.out.println(mean);
    }

    //exericse 2.57
    public void exercise2point57(double budget)
    {
        if(price <= budget) {
            System.out.println("Just right, coz da price is " + price + " and da budget is " + budget);
        }
        else {
            System.out.println("Too expensive dawg, coz our budget is " + budget + " and da fukn price is like " + price + " which means we need to pimp hos to get another " + (price - budget));
        }
    }

    //exercise 2.61
    public int emptyMachine()
    {
        int emptyTotal;
        emptyTotal = total;
        total = 0;
        System.out.println(emptyTotal);
        return emptyTotal;
    }
}
