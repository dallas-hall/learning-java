package Chapter02;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Time
{
	private static final Logger logger = Logger.getLogger(Date.class.getName());
	private static final int SECONDS_IN_DAY = 60 * 60 * 24;

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 2 - Exercise 2");
		Thread.sleep(100);

		int hours, minutes, seconds;
		hours = 7;
		minutes = 48;
		seconds = 2;

		int secondsSinceMidnight = (hours * 60 * 60) + (minutes * 60) + seconds;
		int secondsUntilMidnight = SECONDS_IN_DAY - secondsSinceMidnight;
		double percentageOfDayElapsed = ((double) secondsSinceMidnight / (double) SECONDS_IN_DAY) * 100;

		System.out.print("The time is ");
		if(hours < 12) {
			System.out.print("0" + hours);
		} else {
			System.out.print(hours);
		}

		if(minutes < 10) {
			System.out.print(":0" + minutes + ":");
		} else {
			System.out.print(":" + minutes  + ":");
		}

		if(seconds < 10) {
			System.out.print("0" + seconds);
		} else {
			System.out.print(seconds);
		}
		System.out.println();

		System.out.println("The amount of seconds since midnight last night is " + secondsSinceMidnight);
		System.out.println("The amount of seconds until midnight tonight is " + secondsUntilMidnight);
		System.out.println("The percentage of the day gone is " + percentageOfDayElapsed);
	}
}
