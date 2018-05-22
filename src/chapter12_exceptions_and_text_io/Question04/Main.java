package chapter12_exceptions_and_text_io.Question04;

import java.util.Scanner;

/**
 * <h1>Call Stack Driver</h1>
 * <p>
 * This is the driver for the Loan Calculator Stack class. It demonstrates how the loan calculator works.
 * </p>
 * <p>
 * tags:	try catch; Scanner; IllegalArgumentException;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2017-05-13
 */
public class Main
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Enter annual interest rate
		try {
			System.out.print("Enter annual interest rate, for example, 8.25: ");
			double annualInterestRate = input.nextDouble();
			
			// Enter number of years
			System.out.print("Enter number of years as an integer: ");
			int numberOfYears = input.nextInt();
			
			// Enter loan amount
			System.out.print("Enter loan amount, for example, 120000.95: ");
			double loanAmount = input.nextDouble();
			
			// Create a Loan object
			LoanCalculator loan = new LoanCalculator(annualInterestRate, numberOfYears, loanAmount);
			
			// Display loan date, monthly payment, and total payment
			System.out.printf("The loan was created on %s\n" + "The monthly payment is %.2f\nThe total payment is %.2f\n", loan.getLoanDate().toString(), loan.getMonthlyPayment(), loan.getTotalPayment());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
