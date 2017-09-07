package chapter06;

import chapter10.*;

/**
 * Created by blindcant on 24/04/17.
 */
public class Question05
{
	//INSTANCE VARIABLES
	
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		//create a random number between 0 and 15
		Question05 run1 = new Question05((int)(Math.random() * 16), (int)(Math.random() * 16), (int)(Math.random() * 16));
		//create a random number between 0.n and 100.5n
		Question05 run2 = new Question05((double)(Math.random() * 101.5), (double)(Math.random() * 101.5), (double)(Math.random() * 101.5));
		//create a random number between 0 and 1000
		Question05 run3 = new Question05((int)(Math.random() * 1001), (int)(Math.random() * 1001), (int)(Math.random() * 1001));
	}
	
	//CONSTRUCTOR(S)
	Question05(double inputNumber1, double inputNumber2, double inputNumber3)
	{
		System.out.println("Starting numbers are: " + inputNumber1 + " " + inputNumber2 + " " + inputNumber3);
		System.out.println("Ascending sorted numbers are: " + displaySortedNumbers(inputNumber1, inputNumber2, inputNumber3, 'a'));
		System.out.println("Descending sortsortedStringed numbers are: " + displaySortedNumbers(inputNumber1, inputNumber2, inputNumber3, 'd'));
		System.out.println();
	}
	
	//METHODS
	public String displaySortedNumbers(double inputNumber1, double inputNumber2, double inputNumber3, char inputFlag)
	{
		double maxNumber;
		double midNumber;
		double minNumber;
		
		if (inputNumber1 > inputNumber2 && inputNumber1 > inputNumber3)
		{
			maxNumber = inputNumber1;
			if (inputNumber2 > inputNumber3)
			{
				midNumber = inputNumber2;
				minNumber = inputNumber3;
			}
			else
			{
				midNumber = inputNumber3;
				minNumber = inputNumber2;
			}
		}
		else if (inputNumber2 > inputNumber1 && inputNumber2 > inputNumber3)
		{
			maxNumber = inputNumber2;
			if (inputNumber1 > inputNumber3)
			{
				midNumber = inputNumber1;
				minNumber = inputNumber3;
			}
			else
			{
				midNumber = inputNumber3;
				minNumber = inputNumber1;
			}
		}
		else
		{
			maxNumber = inputNumber3;
			if (inputNumber1 > inputNumber2)
			{
				midNumber = inputNumber1;
				minNumber = inputNumber2;
			}
			else
			{
				midNumber = inputNumber2;
				minNumber = inputNumber1;
			}
		}
		if (inputFlag == 'a' || inputFlag == 'A')
		{
			String sortedString = minNumber + " " + midNumber + " " + maxNumber;
			return sortedString;
		}
		else if (inputFlag == 'd' || inputFlag == 'D')
		{
			String sortedString = maxNumber + " " + midNumber + " " + minNumber;
			return sortedString;
		}
		else
		{
			String sortedString = "Invalid selection.";
			return sortedString;
		}
	}
}
