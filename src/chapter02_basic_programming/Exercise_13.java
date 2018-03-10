package chapter02_basic_programming;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * <h1>Calculate Monthly Interest</h1>
 * <p>
 * This program will ask the user for an amount to save, and then calculate the interest each month. The annual interest rate is 5% so the monthly interest rate is 5/12.
 * </p>
 * <p>
 * tags:	String printing; math; Scanner; nextDouble; for loop;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class Exercise_13 {
	//@@@ INSTANCE VARIABLES @@@
	// Using concepts found here - https://stackoverflow.com/a/1359905
	// Round to 6 decimal places, using 6 as currency conversion uses 6.
	private static final BigDecimal MONTHLY_INTEREST_RATE = new BigDecimal(0.05 / 12).setScale(6, BigDecimal.ROUND_HALF_EVEN);
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		BigDecimal investmentAmount = new BigDecimal("0.00");
		int investmentMonths = 0;
		BigDecimal balance = new BigDecimal("0.00");
		// Money to 2 places
		NumberFormat aud2Places = NumberFormat.getCurrencyInstance(Locale.getDefault());
		aud2Places.setMinimumFractionDigits(2);
		aud2Places.setMaximumFractionDigits(2);
		// Money to 6 places
		NumberFormat aud6Places = NumberFormat.getCurrencyInstance(Locale.getDefault());
		aud6Places.setMinimumFractionDigits(6);
		aud6Places.setMaximumFractionDigits(6);
		
		// Get user inputs
		do {
			// Reset for each run
			errorFound = false;
			System.out.println("Please enter the amount to invest each month.");
			try {
				investmentAmount = BigDecimal.valueOf(stdin.nextDouble());
				// Round to 2 decimal places.
				investmentAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
				if (investmentAmount.doubleValue() <= 0)
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Please enter positive decimal numbers only.");
				errorFound = true;
			} finally {
				// Consume the newline character(s)
				stdin.nextLine();
			}
		} while (errorFound);
		
		do {
			// Reset for each run
			errorFound = false;
			System.out.println("Please enter how many months you will invest for.");
			try {
				investmentMonths = stdin.nextInt();
				if (investmentMonths <= 0)
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Please enter positive integers only.");
				errorFound = true;
			} finally {
				// Consume the newline character(s)
				stdin.nextLine();
			}
		} while (errorFound);
		
		// Calculate and display

		for(int i = 0; i < investmentMonths; i ++) {
			// Invest money
			balance = balance.add(investmentAmount);
			System.out.println("@@@ Month " + (i + 1) + " @@@\nCurrent balance before interest: " + aud2Places.format(balance));
			// Calculate interest (balance * rate)
			BigDecimal interest = balance.multiply(MONTHLY_INTEREST_RATE).setScale(6, BigDecimal.ROUND_HALF_EVEN);
			System.out.println("Interest before rounding: " + aud6Places.format(interest));
			System.out.println("Interest after rounding: " + aud2Places.format(interest));
			// Update balance
			balance = balance.add(interest.setScale(2, BigDecimal.ROUND_HALF_EVEN));
			System.out.println("Current balance after interest: " + aud2Places.format(balance) + "\n");
		}
		System.out.println("Total money earnt was " + aud2Places.format(balance));
		
	}
}
