package chapter12;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by blindcant on 7/05/17.
 */
public class Question02
{
	//INSTANCE VARIABLES
	private Scanner keyboard = new Scanner(System.in);
	private int firstNumber;
	private int secondNumber;
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question02 run1 = new Question02();
	}
	
	//CONSTRUCTOR(S)
	Question02()
	{
		boolean done = false;
		
		do
		try
		{
			System.out.println(computeSum());
			done = true;
		}
		catch (InputMismatchException e)
		{
			System.out.println("InputMismatchException encountered: Invalid user input.\n");
			//reset Scanner so the user can try again
			keyboard.nextLine();
		}
		while (!done);
	}
	
	//METHODS
	public int getFirstNumber()
	{
		return firstNumber;
	}
	
	public int getSecondNumber()
	{
		return secondNumber;
	}
	
	public void getInput()
	{
		System.out.println("Enter 2 digits separated by a space.");
		firstNumber = keyboard.nextInt();
		secondNumber = keyboard.nextInt();
	}
	
	public String computeSum() throws InputMismatchException
	{
		getInput();
		return getFirstNumber() + " + " + getSecondNumber() + " = " + (getFirstNumber() + getSecondNumber());
	}
	
}
