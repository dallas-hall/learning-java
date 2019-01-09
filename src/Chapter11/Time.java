package Chapter11;
/**
 * <h1>Time</h1>
 * <p>
 * This program shows how to build useful classes. It uses constructors, getters, setters, equal, toString, and other
 * helper methods. This example uses time.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */


public class Time
{
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int hours;
	private int minutes;
	private double seconds;

	//@@@ CONSTRUCTOR(S) @@@
	public Time()
	{
		hours = 0;
		minutes = 0;
		seconds = 0.0;
	}
	
	public Time(int hours, int minutes, double seconds)
	{
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		adjustTime();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getHours()
	{
		return hours;
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	public double getSeconds()
	{
		return seconds;
	}
	
	//### SETTERS ###
	public void setHours(int hours)
	{
		this.hours = hours;
		adjustTime();
	}
	
	public void setMinutes(int minutes)
	{
		this.minutes = minutes;
		adjustTime();
	}
	
	public void setSeconds(double seconds)
	{
		this.seconds = seconds;
		adjustTime();
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return String.format("%02d:%02d:%04.1f", hours, minutes, seconds);
	}
	
	public void printTime()
	{
		System.out.println(this.toString());
	}
	
	public boolean equals(Time that)
	{
		return this.hours == that.hours &&
			this.minutes == that.minutes &&
			this.seconds == that.seconds;
	}
	
	public Time addTime(Time t)
	{
		Time sum = new Time();
		sum.hours = this.hours + t.hours;
		sum.minutes = this.minutes + t.minutes;
		sum.seconds = this.seconds + t.seconds;
		
		// Adjust time where necessary
		if(sum.seconds >= 60) {
			sum.minutes += this.seconds / 60;
			sum.seconds %= 60;
		}
		if (sum.minutes >= 60) {
			sum.hours += this.minutes / 60;
			sum.minutes %= 60;
		}
		if (sum.hours > 23) {
			sum.hours %= 24;
		}
		return sum;
	}
	
	private void adjustTime()
	{
		if(this.seconds >= 60) {
			this.minutes += this.seconds / 60;
			this.seconds %= 60;
			
		}
		if (this.minutes >= 60) {
			this.hours += this.minutes / 60;
			this.minutes %= 60;
		}
		if (this.hours > 23) {
			this.hours %= 24;
		}
	}
	
	public void incrementSeconds(double seconds)
	{
		this.seconds += seconds;
		adjustTime();
	}
	
	public void incrementMinutes(int minutes)
	{
		this.minutes += minutes;
		adjustTime();
	}
	
	public void incrementHours(int hours)
	{
		this.hours += hours;
		adjustTime();
	}
}
