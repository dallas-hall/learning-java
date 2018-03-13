package chapter02_basic_programming;

import java.util.Scanner;

/**
 * <h1>ComputeArea</h1>
 * <p>
 * This program will compute the area of a circle
 * </p>
 * <p>
 * tags: math; Scanner; nextDouble;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-01-09
 */
public class ComputeArea
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// Step 1, get the radius
		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter the circle's radius: ");
		double radius = stdin.nextDouble();
		
		// Step 2, compute area
		double area = radius * radius * Math.PI;
		
		// Step 3, display answer
		System.out.println("The area of the cirlce with the radius " + radius + " is " + area);
	}
}
