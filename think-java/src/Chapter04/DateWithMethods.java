package Chapter04;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DateWithMethods
{
	private static final Logger logger = Logger.getLogger(DateWithMethods.class.getName());

	public DateWithMethods()
	{
		String day, date, month;
		int year;
		day = "Monday";
		date = "19th";
		month = "November";
		year = 2018;

		System.out.println(getFullDate(date, day, month, year));
		System.out.println("The European style is: " + getEuropeanDate(date, day, month, year));
		System.out.println("The American style is: " + getAmericanDate(date, day, month, year));
	}

	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Chapter 4 - Exercise 3");
		DateWithMethods dateWithMethods = new DateWithMethods();
	}

	public String getEuropeanDate(String date, String day, String month, int year)
	{
		return day + ", " + month + " " + date + ", " + year;
	}

	public String getAmericanDate(String date, String day, String month, int year)
	{
		return day + ", " + month + " " + date + ", " + year;
	}

	public String getFullDate(String date, String day, String month, int year)
	{
		return day + " the " + date + " of " + month + ", " + year;
	}
}

