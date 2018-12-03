package Chapter03;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CelsiusToFahrenheit
{
	private static final Logger logger = Logger.getLogger(CelsiusToFahrenheit.class.getName());

	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Chapter 3 - Exercise 2");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the temperature in Celsius.");
		double celsius = scanner.nextDouble();
		// Consume the trailing newline.
		scanner.nextLine();

		// °C to °F 	Multiply by 9, then divide by 5, then add 32 - https://www.mathsisfun.com/temperature-conversion.html
		double fahrenheit = celsius * 9 / 5 + 32;
		System.out.println(celsius + " °C is " + fahrenheit + " °F");
	}
}
