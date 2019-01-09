package Chapter11;
/**
 * <h1>Date</h1>
 * <p>
 * This program creates a date that contains year, month, and day. Can return and print an ISO 8601 date or just print
 * a US date. Constructor and methods take int's but uses short and byte internally.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

public class Date
{
	//@@@ INSTANCE VARIABLES @@@
	private short year;
	private byte month;
	private byte day;

	//@@@ CONSTRUCTOR(S) @@@
	public Date()
	{
		// Unix epoch
		this.year = (short) 1970;
		this.month = (byte) 1;
		this.day = (byte) 1;
	}
	
	public Date(int year, int month, int day)
	{
		this.year = (short) year;
		this.month = (byte) month;
		this.day = (byte) day;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getYear()
	{
		return (int) year;
	}
	
	public int getMonth()
	{
		return (int) month;
	}
	
	public int getDay()
	{
		return (int) day;
	}
	
	//### SETTERS ###
	public void setYear(int year)
	{
		this.year = (short) year;
	}
	
	public void setMonth(int month)
	{
		this.month = (byte) month;
	}
	
	public void setDay(int day)
	{
		this.day = (byte) day;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return String.format("%4d-%02d-%02d", year, month, day);
	}
	
	public void printIso8601()
	{
		System.out.println(this.toString());
	}
	
	public void printUsDate()
	{
		System.out.println(String.format("%4d-%02d-%02d", year, day, month));
	}
	
	public boolean equals(Date that)
	{
		return this.year == that.year &&
			this.month == that.month &&
			this.day == that.day;
	}
}
