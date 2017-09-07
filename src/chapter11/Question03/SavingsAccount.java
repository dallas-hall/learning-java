package chapter11.Question03;

/**
 * Created by blindcant on 4/05/17.
 */
public class SavingsAccount extends chapter09.Question07
{
	//INSTANCE VARIABLES
	private double minimumBalance = 1000;
	
	//CONSTRUCTOR(S)
	public SavingsAccount(String accountName, double accountBalance, double annualInterestRate, double minimumBalance)
	{
		super(accountName, accountBalance, annualInterestRate);
		this.minimumBalance = minimumBalance;
		
	}
	//METHODS
	public double getMinimumBalance()
	{
		return minimumBalance;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + String.format("Minimum balance:\t$%,.2f\n"
		,getMinimumBalance());
	}
	
	@Override
	public void withdraw(double amount)
	{
		if (super.getAccountBalance() - amount >= getMinimumBalance())
		{
			super.withdraw(amount);
		}
		else
		{
			System.out.println("Cannot withdraw, insufficient funds will remain.");
		}

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
}
