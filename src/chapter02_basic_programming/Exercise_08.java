/**
 *
 */
package chapter02_basic_programming;

import java.util.Scanner;

/**
 * <h1>Time Conversion</h1>
 * <p>
 * This program will print the current time for GMT, and then convert that to another GMT timezone based on the user's input.
 * </p>
 * <p>
 * tags:	String printing; math; Scanner; nextLong;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 5-3-17
 */
public class Exercise_08
{

	public static void main(String[] args)
	{
		//get current time in milliseconds, since UNIX epoch (birth of UNIX)
		long totalMilliseconds = System.currentTimeMillis();

		//convert milliseconds to seconds (divide by 1000) 1 sec = 1000ms
		long totalSeconds = totalMilliseconds / 1000;

		//get current seconds (totalSeconds % 60) the remainder is current second
		//using 60 because we want the seconds outside minutes
		long currentSeconds = totalSeconds % 60;

		//convert seconds to minutes (divide by 60) 1 minute = 60 secs
		long totalMinutes = totalSeconds / 60;

		//get current minute (totalMinutes % 60) the remainder is current minute
		//using 60 because there are 60 minutes in an hour-
		long currentMinutes = totalMinutes % 60;

		//convert minutes to hours (divide by 60) 1 hour = 60 mins
		long totalHours = totalMinutes / 60;

		//get current hour (totalMinutes % 24) the remainder is current hour
		//using 24 as there are 24 hours in a day
		long currentHours = totalHours % 24;


		//display results
		System.out.println("The current time in GMT is: " + currentHours + ":" + currentMinutes + ":" + currentSeconds);

		//create Scanner object
		Scanner keyboard = new Scanner(System.in);

		//get user input to offset GMT
		System.out.print("Enter your GMT timezone offset: ");
		double timeZoneOffSet = keyboard.nextDouble();

		//adjust previous calculation with offset
		double adjustedCurrentHours = currentHours + timeZoneOffSet;

		//display results
		System.out.println("The current time in +" + (int) timeZoneOffSet + " GMT is: " + (int) adjustedCurrentHours + ":" + currentMinutes + ":" + currentSeconds);
	}

}
