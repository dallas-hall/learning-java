package chapter04;

import java.util.Scanner;

/**
 * Created by blindcant on 24/04/17.
 */
public class Question08
{
	//INSTANCE VARIABLES
	private Scanner keyboard = new Scanner(System.in);
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question08 run1 = new Question08();
	}
	
	//CONSTRUCTOR(S)
	public Question08()
	{
		System.out.println("Enter an ASCII code between 0 and 127.");
		int userInput = Integer.parseInt(keyboard.nextLine());
		if (userInput >= 0 && userInput <= 127)
		{
			System.out.println("The character in ASCII code for " + userInput + " is: " + (char)userInput);
		}
		else
		{
			System.out.println("Wrong input.");
		}
	}
	//METHODS
}
