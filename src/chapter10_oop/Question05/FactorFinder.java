package chapter10_oop.Question05;

import chapter10_oop.Question03.PrimeNumberCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Factor Finder</h1>
 * <p>
 * This program will find all the factors of an inputted number. It will display the factor pairs and print which factors are prime and which are not.
 * </p>
 * <p>
 * tags:	prime; factor pairs; composite; Scanner; do while; List; ArrayList; int[]; polymorphism
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-23
 */
public class FactorFinder
{
	//@@@ CLASS VARIABLES @@@
	private static Scanner keyboard = new Scanner(System.in);
	
	//@@@ INSTANCE VARIABLES @@@
	private int[] factorsArray;
	private List<Integer> factorsList;
	private int arraySize = 0;
	private final int MAX_NUMBER = 120;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		boolean done = false;
		boolean errorFound = false;
		int userInput = 0;
		do {
			try {
				// Reset in case of previous run.
				errorFound = false;
				System.out.print("Enter an integer: ");
				userInput = Integer.parseInt(keyboard.nextLine());
			}
			catch (Exception e) {
				System.out.println("You can only enter integers. Try again.");
				errorFound = true;
			}
			if (!errorFound) {
				done = true;
			}
		}
		while (!done);
		
		PrimeNumberCheck question03 = new PrimeNumberCheck();
		FactorFinder run1 = new FactorFinder(userInput);
		run1.runTest(userInput, question03);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FactorFinder(int startNumber)
	{
		//assuming that every number will less factors than half of itself + 1
		factorsArray = new int[startNumber / 2 + 1];
		factorsList = new ArrayList<>();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getArraySize()
	{
		return this.arraySize;
	}
	
	public int getMaxValue(int[] inputArray)
	{
		int arraySize = getArraySize();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arraySize; i++) {
			if (inputArray[i] > max) {
				max = inputArray[i];
			}
		}
		return max;
	}
	
	//### SETTERS ###
	public void setFactorsIntoArray(int inputNumber)
	{
		for (int i = 0, divisor = 1; divisor <= inputNumber; divisor++) {
			if (inputNumber % divisor == 0) {
				factorsArray[i] = divisor;
				this.arraySize++;
				i++;
			}
		}
	}
	
	public void setFactorsIntoList(int inputNumber)
	{
		for (int divisor = 1; divisor <= inputNumber; divisor++) {
			if (inputNumber % divisor == 0) {
				factorsList.add(divisor);
			}
		}
	}
	
	//### HELPERS ###
	public void printFactorsFromArray(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++) {
			System.out.print(inputArray[i] + " ");
		}
		System.out.println();
	}
	
	public void printFactorsFromList()
	{
		for (Integer anInt : factorsList) {
			System.out.print(anInt + " ");
		}
		System.out.println();
	}
	
	public void printFactorPairsFromArray(int[] inputArray)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++) {
			// Use i to get the corresponding factor pairs. E.g. 0 and size -1, 1 and size - 2, etcetera.
			System.out.print(inputArray[i] + " & " + inputArray[arraySize - (i + 1)] + ". ");
		}
		System.out.println();
	}
	
	public void printFactorPairsFromList()
	{
		int i = 0;
		for (Integer anInt : factorsList) {
			System.out.print(factorsList.get(i) + " & " + factorsList.get(factorsList.size() - (i + 1)) + ". ");
			i++;
		}
		System.out.println();
	}
	
	public void printPrimeFactorsFromArray(int[] inputArray, PrimeNumberCheck question03)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++) {
			if (question03.isPrime2(inputArray[i])) {
				System.out.print(inputArray[i] + " ");
			}
		}
		System.out.println();
	}
	
	public void printPrimeFactorsFromList(PrimeNumberCheck question03)
	{
		for (Integer anInt : factorsList) {
			if (question03.isPrime2(anInt)) {
				System.out.print(anInt + " ");
			}
		}
		System.out.println();
	}
	
	public void printNonPrimeFactorsFromArray(int[] inputArray, PrimeNumberCheck question03)
	{
		int arraySize = getArraySize();
		for (int i = 0; i < arraySize; i++) {
			if (!question03.isPrime2(inputArray[i])) {
				System.out.print(inputArray[i] + " ");
			}
		}
		System.out.println();
	}
	
	public void printNonPrimeFactorsFromList(PrimeNumberCheck question03)
	{
		for (Integer anInt : factorsList) {
			if (!question03.isPrime2(anInt)) {
				System.out.print(anInt + " ");
			}
		}
		System.out.println();
	}
	
	public void runTest(int startNumber, PrimeNumberCheck question03)
	{
		System.out.println("\n@@@ Array Test @@@");
		setFactorsIntoArray(startNumber);
		System.out.println("All factors for " + startNumber + " are:");
		printFactorsFromArray(this.factorsArray);
		System.out.println("The factor pairs for " + startNumber + " are:");
		printFactorPairsFromArray(this.factorsArray);
		System.out.println("The prime factors for " + startNumber + " are:");
		printPrimeFactorsFromArray(this.factorsArray, question03);
		System.out.println("The non-prime factors for " + startNumber + " are:");
		printNonPrimeFactorsFromArray(this.factorsArray, question03);
		
		System.out.println("\n@@@ ArrayList Test @@@");
		setFactorsIntoList(startNumber);
		System.out.println("All factors for " + startNumber + " are:");
		printFactorsFromList();
		System.out.println("The factor pairs for " + startNumber + " are:");
		printFactorPairsFromList();
		System.out.println("The prime factors for " + startNumber + " are:");
		printPrimeFactorsFromList(question03);
		System.out.println("The non-prime factors for " + startNumber + " are:");
		printNonPrimeFactorsFromList(question03);
	}
}
