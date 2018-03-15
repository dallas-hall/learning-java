package chapter05_loops;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1>Gregorian Calender</h1>
 * <p>
 * This program will display a Gregorian calendar for an inputted year and will align the days based on the first day of the year.
 * </p>
 * <p>
 * tags:	HashMap, Scanner, do while; Byte.parseByte; nextLine; Exception; try catch
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-15
 */
public class Exercise_29
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		int year = 0;
		
		do
		{
			try
			{
				// Reset in case of previous error
				errorFound = false;
				System.out.println("Enter the year, format is ccyy.");
				year = Integer.parseInt(stdin.nextLine());
				// https://en.wikipedia.org/wiki/Gregorian_calendar
				if (year < 1582)
				{
					errorFound = true;
					throw new IllegalArgumentException("Gregorian calendar started in 1582, input year must be higher.");
				}
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		} while (errorFound);
		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		
		int firstDayOfYear = 0;
		do
		{
			try
			{
				// Reset in case of previous error
				errorFound = false;
				System.out.println("Enter the first day of the year, format is d.");
				firstDayOfYear = Integer.parseInt(stdin.nextLine());
				if (firstDayOfYear < 1 || firstDayOfYear > 7)
				{
					errorFound = true;
					throw new IllegalArgumentException("The first day of the year must be between 1 and 7.");
				}
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		} while (errorFound);
		
		Map<Integer, String> months = new HashMap<>();
		months.put(1, "January");
		months.put(2, "February");
		months.put(3, "March");
		months.put(4, "April");
		months.put(5, "May");
		months.put(6, "June");
		months.put(7, "July");
		months.put(8, "August");
		months.put(9, "September");
		months.put(10, "October");
		months.put(11, "November");
		months.put(12, "December");
		
		Map<Integer, Integer> daysInMonth = new HashMap<>();
		daysInMonth.put(1, 31);
		daysInMonth.put(2, 28);
		daysInMonth.put(3, 31);
		daysInMonth.put(4, 30);
		daysInMonth.put(5, 31);
		daysInMonth.put(6, 30);
		daysInMonth.put(7, 31);
		daysInMonth.put(8, 31);
		daysInMonth.put(9, 30);
		daysInMonth.put(10, 31);
		daysInMonth.put(11, 30);
		daysInMonth.put(12, 31);
		
		Map<Integer, String> weekDays = new HashMap<>();
		weekDays.put(1, "Sun");
		weekDays.put(2, "Mon");
		weekDays.put(3, "Tue");
		weekDays.put(4, "Wed");
		weekDays.put(5, "Thu");
		weekDays.put(6, "Fri");
		weekDays.put(7, "Sat");
		
		int monthsSize = months.size();
		int weekDaysSize = weekDays.size();
		int cursorPosition = 1;
		// Print months
		for(int month = 0; month < monthsSize; month++)
		{
			System.out.println("\t\t" + months.get(month + 1) + " " + year);
			
			// Print day names
			for(int currentDay = 0; currentDay < weekDaysSize; currentDay++)
			{
				System.out.format("%6s", weekDays.get(currentDay + 1));
			}
			System.out.println();
			
			// Print spaces
			if(month == 0)
			{
				for (int space = 1; space <= firstDayOfYear; space++, cursorPosition++)
				{
					System.out.format("%6s", "x");
				}
			}
			else
			{
				for (int space = 1; space < cursorPosition; space++)
				{
					System.out.format("%6s", "x");
				}
			}
			
			// Print numbers
			int daysInCurrentMonth = daysInMonth.get(month + 1);
			if(month == 1 && isLeapYear)
				daysInCurrentMonth = daysInMonth.get(month + 1) + 1;
			for(int day = 1; day <= daysInCurrentMonth; day++, cursorPosition++)
			{
				System.out.format("%6s", day);
				if (cursorPosition % 7 == 0)
				{
					System.out.println();
					// Set to 0 as it will become 1 again
					cursorPosition = 0;
				}
			}
			System.out.println();
		}
	}
}
