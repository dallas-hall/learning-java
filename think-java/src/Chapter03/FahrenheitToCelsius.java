package Chapter03;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FahrenheitToCelsius
{
	private static final Logger logger = Logger.getLogger(FahrenheitToCelsius.class.getName());

	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Chapter 3 - Exercise 2");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the temperature in Fahrenheit.");
		double fahrenheit = scanner.nextDouble();
		// Consume the trailing newline.
		scanner.nextLine();

		// °F to °C 	Deduct 32, then multiply by 5, then divide by 9 - https://www.mathsisfun.com/temperature-conversion.html
		double celsius = (fahrenheit - 32) * 5 / 9;
		System.out.println(fahrenheit + " °F is " + celsius + " °C");
	}
}
