/**
 *
 */
package chapter02_basic_programming;

import java.util.Scanner;

/**
 * <h1>Feet to Meters</h1>
 * <p>
 * This program will convert feet to meters, using the users input.
 * </p>
 * <p>
 * tags: math; Scanner; nextDouble;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-03-13
 */
public class Exercise_03
{
	public static void main(String[] args)
	{
		//create variables
		final double ONE_FOOT_IN_METER = 0.305;
		
		//create Scanner object
		Scanner keyboard = new Scanner(System.in);
		
		//get user inputs
		System.out.print("Enter a value in feet: ");
		double inputFeet = keyboard.nextDouble();
		
		//calculations
		double meters = inputFeet * ONE_FOOT_IN_METER;
		
		//display answer
		System.out.println(inputFeet + " feet is " + meters + " in meters");
	}
}
