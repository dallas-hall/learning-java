package chapter12_exceptions_and_text_io;

/**
 * Created by blindcant on 13/05/17.
 */
public class Question04
{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	
	/**
	 * Default constructor
	 */
	public Question04()
	{
		this(2.5, 1, 1000);
	}
	
	/**
	 * Construct a loan with specified annual interest rate,
	 * no-arg constructor
	 * 10.2 Class Abstraction and Encapsulation 369
	 * 13 number of years, and loan amount
	 * 14
	 */
	public Question04(double annualInterestRate, int numberOfYears, double loanAmount)
	{
		if (annualInterestRate <= 0 || numberOfYears <= 0 || loanAmount <= 0)
		{
			throw new IllegalArgumentException("All values must be greater than 0.");
		}
		else
		{
			this.annualInterestRate = annualInterestRate;
			this.numberOfYears = numberOfYears;
			this.loanAmount = loanAmount;
			loanDate = new java.util.Date();
		}
	}
	
	/**
	 * Return annualInterestRate
	 */
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	/**
	 * Set a new annualInterestRate
	 */
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	/**
	 * Return numberOfYears
	 */
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	
	/**
	 * Set a new numberOfYears
	 */
	public void setNumberOfYears(int numberOfYears)
	{
		this.numberOfYears = numberOfYears;
	}
	
	/**
	 * Return loanAmount
	 */
	public double getLoanAmount()
	{
		return loanAmount;
	}
	
	/**
	 * Set a new loanAmount
	 */
	public void setLoanAmount(double loanAmount)
	{
		this.loanAmount = loanAmount;
	}
	
	/**
	 * Find monthly payment
	 */
	public double getMonthlyPayment()
	{
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}
	
	/**
	 * Find total payment
	 */
	public double getTotalPayment()
	{
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
	
	/**
	 * Return loan date
	 */
	public java.util.Date getLoanDate()
	{
		return loanDate;
	}
}
