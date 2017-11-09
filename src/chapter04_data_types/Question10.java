package chapter04_data_types;

import java.util.Scanner;

/**
 * Created by blindcant on 24/04/17.
 */
public class Question10
{
	
	//INSTANCE VARIABLES
	private Scanner keyboard = new Scanner(System.in);
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question10 run1 = new Question10();
	}
	
	//CONSTRUCTOR(S)
	Question10()
	{
		System.out.println("Decimal to hexadecimal converter (between 0 and 15.");
		int userInput = Integer.parseInt(keyboard.nextLine());
		//convert decimal to hex
		if (userInput >= 0 && userInput <= 15)
		{
			if (userInput >= 0 && userInput <= 9)
			{
				System.out.println("The hex value for " + userInput + " is: " + userInput);
			}
			else if (userInput == 10)
			{
				//A = 65
				System.out.println("The hex value for " + userInput + " is: " + (char)65);
			}
			else if (userInput == 11)
			{
				//B = 66
				System.out.println("The hex value for " + userInput + " is: " + (char)66);
			}
			else if (userInput == 12)
			{
				//C = 67
				System.out.println("The hex value for " + userInput + " is: " + (char)67);
			}
			else if (userInput == 13)
			{
				//D = 68
				System.out.println("The hex value for " + userInput + " is: " + (char)68);
			}
			else if (userInput == 14)
			{
				//E = 69
				System.out.println("The hex value for " + userInput + " is: " + (char)69);
			}
			else
			{
				//F = 70
				System.out.println("The hex value for " + userInput + " is: " + (char)70);
			}
		}
		else
		{
			System.out.println("Invalid input.");
		}
	}
	
	//METHODS
}
