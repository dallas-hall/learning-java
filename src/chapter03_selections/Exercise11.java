package chapter03_selections;

import java.util.Scanner;

/**
 * <h1>Days In Month</h1>
 * <p>
 * This program will work out the days in the month, including leap years.
 * </p>
 * <p>
 * tags:	switch; case; array; Scanner; nextInt; do while
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class Exercise11
{
	//@@@ INSTANCE VARIABLES @@@
	private static final int[] daysInMonthNormalYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		boolean errorFound = false;
		boolean leapYearFound = false;
		int month = 0;
		int year = 0;
		int days = 0;
		Scanner stdin = new Scanner(System.in);
		do
		{
			// Reset in case of previous failure
			errorFound = false;
			try
			{
				System.out.println("Enter the month as a number. Example: January is 1 and December is 12.");
				month = stdin.nextInt();
				if (month < 1 || month > 12)
				{
					throw new Exception();
				}
			}
			catch (Exception e)
			{
				System.out.println("The month must be an integer between 1 and 12");
				errorFound = true;
			}
			finally
			{
				// Scanner bug fix
				stdin.nextLine();
			}
		}
		while (errorFound);
		
		do
		{
			// Reset in case of previous failure
			errorFound = false;
			try
			{
				System.out.println("Enter the year. Example: 2000.");
				year = stdin.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("The year must be an integer.");
				errorFound = true;
			}
			finally
			{
				// Scanner bug fix
				stdin.nextLine();
			}
		}
		while (errorFound);
		
		// Work out if its a leap year, if the year is divisible by 4 and not by a 100 or divisible by 400 it is a leap year
		leapYearFound = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		
		// Print days
		switch (month)
		{
			case 1:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 2:
				if (leapYearFound)
				{
					days = 29;
				}
				else
				{
					days = daysInMonthNormalYear[month - 1];
				}
				break;
			case 3:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 4:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 5:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 6:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 7:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 8:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 9:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 10:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 11:
				days = daysInMonthNormalYear[month - 1];
				break;
			case 12:
				days = daysInMonthNormalYear[month - 1];
				break;
		}
		
		if (leapYearFound)
		{
			System.out.println("Did you know " + year + " was a leap year? The number of days in " + monthNames[month - 1] + " that year was " + days + ".");
		}
		else
		{
			System.out.println("Did you know " + year + " was a not leap year? The number of days in " + monthNames[month - 1] + " that year was " + days + ".");
		}
	}
}
