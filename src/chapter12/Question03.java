package chapter12;

import java.util.Scanner;

/**
 * Created by blindcant on 7/05/17.
 */
public class Question03
{
	//INSTANCE VARIABLES
	private Scanner keyboard = new Scanner(System.in);
	private int[] randomArray = new int[100];
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question03 run1 = new Question03();
	}
	
	//CONSTRUCTOR(S)
	Question03()
	{
		populateArray();
		printFullArray();
		printArrayViaUserInput();
	}
	
	//METHODS
	public void populateArray()
	{
		for (int i = 0; i < randomArray.length; i++)
		{
			//generate random number between 1 and 100
			// (a + Math.random() * b) returns random number between a and a+b, excluding a+b
			randomArray[i] = (int) (1 + Math.random() * 100);
		}
	}
	
	public void printFullArray()
	{
		//loop printing control variables
		int printPosition = 1;
		final int PRINTS_PER_LINE = 10;
		
		for (int i = 0; i < randomArray.length; i++)
		{
			System.out.print(randomArray[i] + "\t");
			//print a new line after printing 10 indices
			if (printPosition < PRINTS_PER_LINE)
			{
				printPosition++;
			}
			else if (printPosition % PRINTS_PER_LINE == 0)
			{
				System.out.println();
				printPosition = 1;
			}
		}
	}
	
	public void printArrayViaUserInput()
	{
		try
		{
			System.out.println("\nEnter an index to be printed: ");
			int userInput = Integer.parseInt(keyboard.nextLine());
			System.out.println("The value of :" + userInput + " is " + randomArray[userInput]);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("IndexOutOfBoundsException encountered: Tried to access " + e.getMessage() + " but last element is " + (randomArray.length - 1));
			printArrayViaUserInput();
		}
	}
}
