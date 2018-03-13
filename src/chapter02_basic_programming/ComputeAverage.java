package chapter02_basic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>ComputerAverage</h1>
 * <p>
 * This program will compute the average of numbers entered.
 * </p>
 * <p>
 * tags: Scanner; nextLine; parseInt; parseDouble; List; while-loop;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-01-09
 */
public class ComputeAverage
{
	//@@@ INSTANCE VARIABLES @@@3
	private List<Double> numbers;
	private double answer;
	private Scanner stdin;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ComputeAverage runtime = new ComputeAverage();
		System.out.println("The average is: " + runtime.getAverage());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ComputeAverage()
	{
		numbers = new ArrayList<>();
		stdin = new Scanner(System.in);
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private double getAverage()
	{
		// Local variables
		int amount = 0;
		double total = 0;
		boolean done = false;
		
		// Get the amount to work with
		while (!done)
		{
			System.out.println("Enter the amount of numbers to be calculated: ");
			String userInput = stdin.nextLine();
			
			// Check user input
			try
			{
				amount = Integer.parseInt(userInput);
				if (amount > 0)
				{
					done = true;
				}
				else
				{
					throw new Exception();
				}
			}
			catch (Exception e)
			{
				System.out.println("Invalid input, must be a positive integer.");
			}
		}
		
		// Get the numbers to work with
		for (int i = 1; i <= amount; i++)
		{
			// Reset for our while loop
			done = false;
			double number;
			while (!done)
			{
				System.out.println("Enter a number: ");
				String userInput = stdin.nextLine();
				try
				{
					number = Double.parseDouble(userInput);
					numbers.add(number);
					done = true;
				}
				catch (Exception e)
				{
					System.out.println("Invalid input, must be a number.");
				}
			}
		}
		
		// Calculate results & return
		for (int i = 0; i < numbers.size(); i++)
		{
			total += numbers.get(i);
		}
		return total / amount;
	}
}
