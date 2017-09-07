/**
 *
 */
package chapter09;

import java.util.Date;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 17 Apr 2017
 * @program:
 */
public class Question03
{
	
	/**
	 * @param args
	 */
	
	private long number;
	private java.util.Date date = new java.util.Date(number);
	
	public Question03(long number)
	{
		this.number = number;
	}
	
	public void setDate()
	{
		number *= 10;
		date.setTime(number);
	}
	
	public void getDates()
	{
		for (int i = 1; i <= 8; i++)
		{
			System.out.println(date.toString());
			setDate();
		}
	}
	
	public static void main(String[] args)
	{
		Question03 blah = new Question03(10000);
		blah.getDates();
	}
	
}
