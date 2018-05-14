package chapter11_inheritance.Question03;

/**
 * <h1>Savings Account</h1>
 * <p>
 * This program is my implementation of a savings account using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	inheritance; extends; super class constructor; over riding; packages;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-04
 */
public class SavingsAccount extends chapter09_objects_and_classes.Question07
{
	//@@@ INSTANCE VARIABLES @@@
	private double minimumBalance = 1000;
	
	//@@@ CONSTRUCTOR(S) @@@
	public SavingsAccount(String accountName, double accountBalance, double annualInterestRate, double minimumBalance)
	{
		super(accountName, accountBalance, annualInterestRate);
		this.minimumBalance = minimumBalance;
		
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getMinimumBalance()
	{
		return minimumBalance;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + String.format("Minimum balance:\t$%,.2f\n", getMinimumBalance());
	}
	
	@Override
	public double getAnnualInterestRate()
	{
		// convert to a percentage
		return super.getAnnualInterestRate();
	}
	
	public double getMonthlyInterestRate()
	{
		// divide yearly by 12 for monthly, convert to %
		return super.getMonthlyInterestRate();
	}
	
	public double getMonthlyInterest()
	{
		//calculate monthly interest (balance * rate) then add it to balance
		return super.getMonthlyInterest();
	}
	
	//### SETTERS ###
	@Override
	public void withdraw(double amount)
	{
		if (super.getAccountBalance() - amount >= getMinimumBalance()) {
			super.withdraw(amount);
		}
		else {
			System.out.println("Cannot withdraw, insufficient funds will remain.");
		}
		
	}
}
