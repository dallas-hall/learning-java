package chapter12_exceptions_and_text_io.Question03;

import java.util.Scanner;

/**
 * <h1>Array Index Exception</h1>
 * <p>
 * This program creates an int array with random values and asks the user to enter an index to print. It will throw Exceptions for invalid input for the index or if the index is out of bounds.
 * </p>
 * <p>
 * tags:	try catch block; IndexOutOfBoundsException; NumberFormatException; Scanner; Math.random;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-07
 */
public class ArrayIndexException
{
	//@@@ INSTANCE VARIABLES @@@
	private Scanner keyboard = new Scanner(System.in);
	private int[] randomArray = new int[100];
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		ArrayIndexException runtime = new ArrayIndexException();
		runtime.printFullArray();
		runtime.printArrayViaUserInput();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	ArrayIndexException()
	{
		populateArray();
	}
	
	//@@@ METHODS @@@
	//### SETTERS ###
	public void populateArray()
	{
		for (int i = 0; i < randomArray.length; i++) {
			//generate random number between 100 and 999
			// (a + Math.random() * b) returns random number between a and a+b, excluding a+b
			randomArray[i] = (int) (100 + Math.random() * 900);
		}
	}
	
	//### HELPERS ###
	public void printFullArray()
	{
		//loop printing control variables
		int printPosition = 1;
		final int PRINTS_PER_LINE = 10;
		
		for (int i = 0; i < randomArray.length; i++) {
			System.out.print(randomArray[i] + "\t");
			//print a new line after printing 10 indices
			if (printPosition < PRINTS_PER_LINE) {
				printPosition++;
			}
			else if (printPosition % PRINTS_PER_LINE == 0) {
				System.out.println();
				printPosition = 1;
			}
		}
	}
	
	public void printArrayViaUserInput()
	{
		try {
			System.out.println("\nEnter an index to be printed: ");
			int userInput = Integer.parseInt(keyboard.nextLine());
			System.out.println("The value of :" + userInput + " is " + randomArray[userInput]);
		}
		catch (NumberFormatException e) {
			System.out.println("NumberFormatException encountered: You can only enter integers.");
			printArrayViaUserInput();
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException encountered: Tried to access " + e.getMessage() + " but last element is " + (randomArray.length - 1));
			printArrayViaUserInput();
		}
	}
}
