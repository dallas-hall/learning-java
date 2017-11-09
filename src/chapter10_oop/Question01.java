package chapter10_oop;

/**
 * Created by blindcant on 22/04/17.
 */
public class Question01
{

	//INSTANCE VARIABLES
	private long currentHours;
	private long currentMinutes;
	private long currentSeconds;
	private byte timezoneOffset = 10;
	
	//get current time in milliseconds, since UNIX epoch (birth of UNIX)
	private long currentMilliseconds = System.currentTimeMillis();
	
	//PROGRAM EXECUTION POINT
	public static void main(String[] args)
	{
		Question01 time1 = new Question01();
		time1.printTime();
		Question01 time2 = new Question01(555550000);
		time2.printTime();
		Question01 time3 = new Question01(12, 35, 45);
		time3.printTime();
	}

	//CONSTRUCTORS
	public Question01()
	{
		//LONG WAY
		//get current time in milliseconds, since UNIX epoch (birth of UNIX)
		//convert milliseconds to seconds (divide by 1000) 1 sec = 1000ms
		long totalSeconds = currentMilliseconds / 1000;

		//get current seconds (totalSeconds % 60) the remainder is current second
		//using 60 because we want the seconds outside minutes
		this.currentSeconds = totalSeconds % 60;

		//convert seconds to minutes (divide by 60) 1 minute = 60 secs
		long totalMinutes = totalSeconds / 60;

		//get current minute (totalMinutes % 60) the remainder is current minute
		//using 60 because there are 60 minutes in an hour-
		this.currentMinutes = totalMinutes % 60;

		//convert minutes to hours (divide by 60) 1 hour = 60 mins
		long totalHours = totalMinutes / 60;

		//get current hour (totalMinutes % 24) the remainder is current hour
		//using 24 as there are 24 hours in a day
		this.currentHours = totalHours % 24;
	}

	public Question01(long inputElapsedTime)
	{
		//convert milliseconds to seconds (divide by 1000) 1 sec = 1000ms
		long totalSeconds = inputElapsedTime / 1000;

		//get current seconds (totalSeconds % 60) the remainder is current second
		//using 60 because we want the seconds outside minutes
		this.currentSeconds = totalSeconds % 60;

		//convert seconds to minutes (divide by 60) 1 minute = 60 secs
		long totalMinutes = totalSeconds / 60;

		//get current minute (totalMinutes % 60) the remainder is current minute
		//using 60 because there are 60 minutes in an hour-
		this.currentMinutes = totalMinutes % 60;

		//convert minutes to hours (divide by 60) 1 hour = 60 mins
		long totalHours = totalMinutes / 60;

		//get current hour (totalMinutes % 24) the remainder is current hour
		//using 24 as there are 24 hours in a day
		this.currentHours = totalHours % 24;
	}

	public Question01(long hours, long minutes, long seconds)
	{
		this.currentHours = hours;
		this.currentMinutes = minutes;
		this.currentSeconds = seconds;
	}

	//GETTERS
	public long getHour()
	{
		return this.currentHours;
	}

	public long getMinute()
	{
		return this.currentMinutes;
	}
	
	public long getSecond()
	{
		return this.currentSeconds;
	}

	//SETTERS
	public void setTime(long elapsedTime)
	{

	}
	
	//HELPERS
	
	public void printTime()
	{
		System.out.println("GMT time is: " + getHour() + ":" + getMinute() + ":" + getSecond());
		System.out.println("+10 GMT time is: " + (getHour() + 10) + ":" + getMinute() + ":" + getSecond());
	}
}
