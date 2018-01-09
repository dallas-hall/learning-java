package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will calculate average speed in miles, starting in km.
 * 1 mile = 1.609 kilometers
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

public class Exercise_10 {
	private static final double DISTANCE_IN_KM = 14;
	//1 = 1 second, using int because I'm only storing seconds - 60 seconds * 45 = 45 minutes in seconds + another 30 seconds
	private static final int TIME_IN_SECONDS = ((60 * 45) + 30);
	
	//converting total seconds to minutes
	private static final double TIME_IN_MINUTES = (TIME_IN_SECONDS / 60.0);
	private static final double ONE_MILE_IN_KM = 1.609;
	
	public static void main(String[] args) {
		//calculations
		System.out.println("The runner ran " + DISTANCE_IN_KM + " km in " + TIME_IN_MINUTES + " (minutes) or " + TIME_IN_SECONDS + " (seconds)");
		System.out.println("The average speed was: " + ((DISTANCE_IN_KM / TIME_IN_SECONDS) * 3600) + " km per hour"); //times by 3600 to convert to hours
		System.out.println("Converting kilometers to miles... " + ONE_MILE_IN_KM + " km is 1 mile");
		System.out.println("The runner ran " + (DISTANCE_IN_KM / ONE_MILE_IN_KM) + " miles"); //convert to miles
		System.out.println("The average speed was: " + (((DISTANCE_IN_KM / ONE_MILE_IN_KM) / TIME_IN_SECONDS) * 3600) + " miles per hour");
	}
}
