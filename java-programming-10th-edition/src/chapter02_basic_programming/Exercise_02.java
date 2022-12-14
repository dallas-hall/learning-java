/**
 *
 */
package chapter02_basic_programming;

import java.util.Scanner;

/**
 * <h1>Circle Area and Volume</h1>
 * <p>
 * This program will accept user input for a circle's length and radius and then compute its area and volume.
 * </p>
 * <p>
 * tags: math; Scanner; nextDouble;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2017-03-13
 */
public class Exercise_02
{
	public static void main(String[] args)
	{
		//create variables
		double PI = Math.PI;
		
		//create Scanner object
		Scanner keyboard = new Scanner(System.in);
		
		//ask user for inputs
		System.out.print("Enter the radius: ");
		double radius = keyboard.nextDouble();
		System.out.print("Enter the length: ");
		double length = keyboard.nextDouble();
		
		//do calculations
		double area = radius * radius * PI;
		double volume = area * length;
		
		//Display answers
		System.out.printf("The area is:\t%.4f", area);
		System.out.printf("%nThe volume is:\t%.1f", volume);
	}
}
