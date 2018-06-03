package chapter13_abstract_classes_and_interfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <h1>CalendarAndDateExample</h1>
 * <p>
 * This program gives an example of java.util.Date and java.util.Calendar
 * </p>
 * <p>
 * tags:	GregorianCalendar(); Calendar; Date;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-03
 */
public class CalendarAndDateExample
{
	//@@@ CLASS VARIABLES @@@
	
	//@@@ INSTANCE VARIABLES @@@
	private java.util.Date date;
	private Calendar calendar;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		CalendarAndDateExample runtime = new CalendarAndDateExample();
		runtime.printDate();
		runtime.printCalendar();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public CalendarAndDateExample()
	{
		date = new Date();
		calendar = new GregorianCalendar();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Date getDate()
	{
		return date;
	}
	
	public Calendar getCalendar()
	{
		return calendar;
	}
	
	
	//### SETTERS ###
	
	//### HELPERS ###
	public void printDate()
	{
		System.out.println("toString() is: " + date.toString());
		System.out.println("getTime() is: " + date.getTime());
	}
	
	public void printCalendar()
	{
		System.out.println("Current time is " + new Date());
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));
		System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
	}
}
