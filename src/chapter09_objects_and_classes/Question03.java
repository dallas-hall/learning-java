package chapter09_objects_and_classes;

/**
 * <h1>Date Class</h1>
 * <p>
 * This program creates a Date object and adds milliseconds to it before displaying it as a String.
 * </p>
 * <p>
 * tags:	constructor; getter; setter; java.util.date; toString()
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-17
 */
public class Question03
{
	//@@@ INSTANCE VARIABLES @@@
	private long number;
	private java.util.Date date = new java.util.Date(number);
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question03 blah = new Question03(10000);
		blah.getDates();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question03(long number)
	{
		this.number = number;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public void getDates()
	{
		for (int i = 1; i <= 8; i++) {
			System.out.println(date.toString());
			setDate();
		}
	}
	
	//### SETTERS ###
	public void setDate()
	{
		number *= 10;
		date.setTime(number);
	}
}
