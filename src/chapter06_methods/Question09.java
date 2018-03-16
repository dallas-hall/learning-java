package chapter06_methods;

import java.util.Scanner;

/**
 * <h1>Conversion - Feet and Metres</h1>
 * <p>
 * This program will convert a number from feet to metres, and the same number from metres to feet.
 * </p>
 * <p>
 * tags:	static final; double; parseInt; nextLine; Scanner; try catch; Exception; do while; instanceof; NumberFormatException; IllegalArgumentException
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-16
 */
public class Question09
{
	//@@@ INSTANCE VARIABLES @@@
	private static final double FEET_TO_METRES = 0.305;
	private static final double METRES_TO_FEET = 3.279;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		int number = 0;
		
		do
		{
			try
			{
				// Reset in case of previous error
				errorFound = false;
				System.out.println("Enter a positive integer.");
				number = Integer.parseInt(stdin.nextLine());
				if (number < 0)
					throw new IllegalArgumentException("Number must be greater than 0.");
			}
			catch (Exception e)
			{
				if(e instanceof NumberFormatException)
					System.out.println("Only numbers can be entered.");
				else
					System.out.println(e.getMessage());
				errorFound = true;
			}
			
		} while (errorFound);
		System.out.println(number + " feet is " + feetToMetres(number) + " metres.");
		System.out.println(number + " metres is " + metresToFeet(number) + " feet.");
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public static double feetToMetres(double feet)
	{
		return feet * FEET_TO_METRES;
	}
	
	public static double metresToFeet(double metre)
	{
		return  metre * METRES_TO_FEET;
	}
}
