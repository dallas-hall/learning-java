package chapter10_oop.Question06;

import java.util.Scanner;

/**
 * <h1>Prime Number Printing</h1>
 * <p>
 * This program will accept a number as input and print all primes up until that number, 10 per line.
 * </p>
 * <p>
 * tags:	prime; composite; Scanner; do while;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-23
 */

public class PrimeNumberPrinting
{
	//@@@ CLASS VARIABLES @@@
	private static Scanner keyboard = new Scanner(System.in);
	
	//@@@ INSTANCE VARIABLES @@@
	private static int[] primeNumbers;
	private int userInput;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		PrimeNumberPrinting runTime = new PrimeNumberPrinting();
		runTime.printPrimeNumberArray();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public PrimeNumberPrinting()
	{
		getUserInput();
		createPrimeNumberArray(userInput);
	}
	
	//@@@ METHODS @@@
	//### SETTERS ###
	public void getUserInput()
	{
		boolean done = false;
		do {
			try {
				System.out.print("Enter a number:");
				userInput = Integer.parseInt(keyboard.nextLine());
				done = true;
			}
			catch (Exception e) {
				System.out.println("You must enter an integer only.");
			}
		}
		while (!done);
	}
	
	public void createPrimeNumberArray(int maxNumber)
	{
		//create the new array, half the size of the maxNumber.
		//this is because all even numbers > 2 aren't prime, so don't have to store them.
		primeNumbers = new int[maxNumber / 2];
		//insert primes, the first is 2.  Start with 1 but skip it as we add 2 the first round, so really start with 3 and keep checking.
		//skip even numbers > 2 because they aren't prime
		
		for (int numberToCheck = 1, i = 0; numberToCheck < maxNumber; numberToCheck += 2) {
			//add 2, the only even prime
			if (i == 0) {
				primeNumbers[i] = 2;
				i++;
			}
			else if (isPrime(numberToCheck)) {
				primeNumbers[i] = numberToCheck;
				i++;
			}
		}
	}
	
	//### HELPERS ###
	private boolean isPrime(int numberToCheck)
	{
		StringBuffer aStringBuffer = new StringBuffer();
		// LaunchSequence whether number is prime
		if (numberToCheck < 2) {
			//System.out.println(numberToCheck + " is not prime.  Only numbers >= 2 can be prime.");
			return false;
		}
		else if (numberToCheck == 2) {
			//System.out.println("2 is the only even prime.");
			return true;
		}
		else if (numberToCheck % 2 == 0) {
			//System.out.println(numberToCheck + " is not prime.  2 is the only even prime.");
			return false;
		}
		for (int divisor = 2; divisor <= numberToCheck - 1; divisor++) {
			if (numberToCheck % divisor == 0 && divisor < numberToCheck - 1) { // If true, number is not prime
				aStringBuffer.append(divisor).append(" ");
			}
			
		}
		if (aStringBuffer.length() > 0) {
			//System.out.println(numberToCheck + " is not prime, it was evenly divisibe by " + aStringBuilder.toString());
			return false;
		}
		//exhausted all checks, must be prime
		else {
			//System.out.println(numberToCheck + " is prime.  It can only be divided evenly by 1 and itself.");
			return true;
		}
	}
	
	public void printPrimeNumberArray()
	{
		System.out.println("Printing all prime numbers up until " + userInput);
		int counter = 1;
		for (int aPrime : primeNumbers) {
			if (aPrime != 0) {
				System.out.print(aPrime + "\t");
			}
			//print 10 per line
			if (counter % 10 == 0) {
				System.out.println();
			}
			counter++;
		}
	}
}
