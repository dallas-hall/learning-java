package Chapter03;

import java.util.Scanner;

public class Convert
{
	public static void main(String[] args)
	{
		double cm;
		int feet, inches, remainder;
		final double CM_PER_INCH = 2.54;
		final int IN_PER_FOOT = 12;
		Scanner scanner = new Scanner(System.in);

		// Get input
		System.out.println("Enter centimeter amount.");
		cm = scanner.nextDouble();

		// Calculate results
		// Parenthesis is ensuring division happens before the int cast.
		inches = (int) (cm / CM_PER_INCH);
		feet =  inches / IN_PER_FOOT;
		remainder = inches % IN_PER_FOOT;

		// Format and print results
		System.out.printf("%.2f cm = %d ft, %d in", cm, feet, remainder);
	}
}
