package chapter09_objects_and_classes;

/**
 * <h1>Account Class</h1>
 * <p>
 * This program creates an Account object, which can deposit and withdraw money. There is also a monthly and annual interest rate calculated against it.
 * </p>
 * <p>
 * tags:	constructor; getter; setter; java.util.date; toString()
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-17
 */
public class Question07
{
	//@@@ INSTANCE VARIABLES @@@
	private int accountID = 0;
	private String accountName;
	private double accountBalance = 0.0;
	private double annualInterestRate = 0.0;
	private java.util.Date dateCreated;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question07(String accountName, double accountBalance, double annualInterestRate)
	{
		this.accountID++;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new java.util.Date();
	}
	
	public Question07()
	{
	
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getAccountID()
	{
		return this.accountID;
	}
	
	public String getAccountName()
	{
		return this.accountName;
	}
	
	public double getAccountBalance()
	{
		return this.accountBalance;
	}
	
	public double getAnnualInterestRate()
	{
		// convert to a percentage
		return this.annualInterestRate / 100;
	}
	
	public String getCreatedDate()
	{
		return this.dateCreated.toString();
	}
	
	public double getMonthlyInterestRate()
	{
		// divide yearly by 12 for monthly, convert to %
		return (this.annualInterestRate / 12) / 100;
	}
	
	public double getMonthlyInterest()
	{
		//calculate monthly interest (balance * rate) then add it to balance
		System.out.println("Adding monthly interest.");
		return this.accountBalance += accountBalance * getMonthlyInterestRate();
	}
	
	//### SETTERS ###
	public void withdraw(double amount)
	{
		System.out.println("Withdrawing " + amount + "\n");
		this.accountBalance -= amount;
	}
	
	public void deposit(double amount)
	{
		System.out.println("Depositing " + amount + "\n");
		this.accountBalance += amount;
	}
	
	//### HELPERS ###
	public String toString()
	{
		return String.format("Account ID:\t\t\t%s\nOpen date:\t\t\t%s\nAccount holder:\t\t%s\nAccount Balance:\t$%,.2f\nInterest rate:\t\t%,.2f\n", getAccountID(), getCreatedDate(), getAccountName(), getAccountBalance(), getMonthlyInterestRate());
	}
	
}
