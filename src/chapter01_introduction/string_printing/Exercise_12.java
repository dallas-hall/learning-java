package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will calculate average speed in km, starting in miles
 * 1.609 kilometers - 1 mile
 * Distance = Rate x Time
 * Rate = Distance / Time
 * Time = Distance / Rate
 * </p>
 * <p>
 * tags:	String printing; constants; math;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 4-3-17
 */

public class Exercise_12 {
	public static void main(String[] args) {
		// Variables
		final double distance_in_km = 24; //1 = 1km
		final int time_in_seconds = ((60 * 60) + (60 * 40) + 35); //1 = 1 second, formula: (60 secs * 60 mins) + (60 secs * 40 mins) + 35 secs
		final double time_in_minutes = (time_in_seconds / 60.0); //converting seconds to minutes
		final double one_mile_in_km = 1.609; //1 mile in kilometer
		
		// Calculations
		System.out.println("The runner ran " + distance_in_km + " miles in " + time_in_minutes + " (minutes) or " + time_in_seconds + " (seconds)");
		System.out.println("The average speed was: " + ((distance_in_km / time_in_seconds) * 3600) + " miles per hour"); //times by 3600 to convert to hours
		System.out.println("Converting miles to kilmeters... 1 mile is " + one_mile_in_km + " km");
		System.out.println("The runner ran " + (distance_in_km / one_mile_in_km) + " miles"); //convert to miles
		System.out.println("The average speed was: " + (((distance_in_km * one_mile_in_km) / time_in_seconds) * 3600) + " km per hour");
	}
	
}
