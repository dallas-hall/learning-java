package chapter12_exceptions_and_text_io.Question04;

/**
 * <h1>Loan Calculator</h1>
 * <p>
 * This program calculates the monthly and total repayments of a loan with fixed interest over a fixed number of years.
 * </p>
 * <p>
 * tags:	java.util.Date; constructor chaining; IllegalArgumentException; Math.Pow;
 * </p>
 *
 * @author dhall
 * @version 0.0.1 - 2017-05-13
 */
public class LoanCalculator
{
	//@@@ INSTANCE VARIABLES @@@
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	
	//@@@ CONSTRUCTOR(S) @@@
	public LoanCalculator()
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
	public LoanCalculator(double annualInterestRate, int numberOfYears, double loanAmount)
	{
		if (annualInterestRate <= 0 || numberOfYears <= 0 || loanAmount <= 0) {
			throw new IllegalArgumentException("All values must be greater than 0.");
		}
		else {
			this.annualInterestRate = annualInterestRate;
			this.numberOfYears = numberOfYears;
			this.loanAmount = loanAmount;
			loanDate = new java.util.Date();
		}
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	
	public double getLoanAmount()
	{
		return loanAmount;
	}
	
	public double getMonthlyPayment()
	{
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}
	
	public double getTotalPayment()
	{
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
	
	public java.util.Date getLoanDate()
	{
		return loanDate;
	}
	
	//### SETTERS ###
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	
	public void setNumberOfYears(int numberOfYears)
	{
		this.numberOfYears = numberOfYears;
	}
	
	public void setLoanAmount(double loanAmount)
	{
		this.loanAmount = loanAmount;
	}
}
