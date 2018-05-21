package chapter12_exceptions_and_text_io.Question02;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Input Mistmatch Exception</h1>
 * <p>
 * This program takes 2 arguments which are 2 numbers. The second number cannot be 0. This is because there are 5 random math operators to choose from and we are protecting against a division by 0 error.
 * </p>
 * <p>
 * tags:	try catch block; throws; throw; InputMismatchException; IllegalArgumentException; args; switch case;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-07
 */
public class InputMismatchException
{
	//@@@ INSTANCE VARIABLES @@@
	private Scanner keyboard = new Scanner(System.in);
	private int firstNumber;
	private int secondNumber;
	private String[] operators = {"%", "*", "/", "+", "-"};
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		InputMismatchException run1 = new InputMismatchException();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	InputMismatchException()
	{
		boolean done = false;
		
		do {
			try {
				System.out.println(computeSum());
				done = true;
			}
			catch (java.util.InputMismatchException e) {
				System.out.println("InputMismatchException encountered: Invalid user input.\n");
				//reset Scanner so the user can try again
				keyboard.nextLine();
			}
			catch (IllegalArgumentException e) {
				System.out.println("IllegalArgumentException encountered: " + e.getMessage() + "\n");
				//reset Scanner so the user can try again
				keyboard.nextLine();
			}
		}
		while (!done);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getFirstNumber()
	{
		return firstNumber;
	}
	
	public int getSecondNumber()
	{
		return secondNumber;
	}
	
	public void getInput() throws IllegalArgumentException
	{
		System.out.println("Enter 2 digits separated by a space.");
		firstNumber = keyboard.nextInt();
		secondNumber = keyboard.nextInt();
		if (secondNumber == 0)
			throw new IllegalArgumentException("Second number cannot be 0, in case we randomly get the division operator.");
	}
	
	//### HELPERS ###
	public String computeSum() throws java.util.InputMismatchException
	{
		getInput();
		int prn = ThreadLocalRandom.current().nextInt(0, operators.length);
		String operator = operators[prn];
		double answer = 0;
		try {
			switch (operator) {
				case "%":
					answer = firstNumber % secondNumber;
					break;
				case "*":
					answer = firstNumber + secondNumber;
					break;
				case "/":
					answer = firstNumber / secondNumber;
					break;
				case "+":
					answer = firstNumber + secondNumber;
					break;
				case "-":
					answer = firstNumber - secondNumber;
					break;
			}
		}
		catch (Exception e) {
			System.out.println("Something went wrong. Probably divide by 0 error.");
		}
		return firstNumber + " " + operator + " " + secondNumber + " = " + answer;
	}
}
