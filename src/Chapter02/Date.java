package Chapter02;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Date
{
	private static final Logger logger = Logger.getLogger(Date.class.getName());

	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Chapter 2 - Exercise 1");
		String day, date, month, fullDate, americanDate, europeanDate;
		int year;
		day = "Monday";
		date = "19th";
		month = "November";
		year = 2018;

		fullDate = day + " the " + date + " of " + month + ", " + year;
		americanDate = day + ", " + month + " " + date + ", " + year;
		europeanDate = day + " " + date + " " + month + " " + year;

		System.out.println("");
		System.out.println(fullDate);
		System.out.println(americanDate);
		System.out.println(europeanDate);
	}
}
