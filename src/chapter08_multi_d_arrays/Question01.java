package chapter08_multi_d_arrays;

//import java.util.Arrays;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>2D Array & Random Numbers</h1>
 * <p>
 * This program will create a 4 x 4 2d array and fill it with numbers inputted by the user. A variety of sums will be displayed at the end.
 * </p>
 * <p>
 * tags:	int[][]; nested for loops; ThreadLocalRandom.current().nextInt; Arrays.deepToString;
 * </p>
 *
 * @author blindcant
 * @version 0.2 - 2018-04-05
 */
public class Question01
{
	//@@@ INSTANCE VARIABLES @@@
	//3 rows by 4 column array
	private final static int MAX_ROWS = 4;
	private final static int MAX_COLUMNS = 4;
	private double[][] _2dArray = new double[MAX_ROWS][MAX_COLUMNS];
	private Scanner keyboard = new Scanner(System.in);
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question01 run1 = new Question01();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question01()
	{
		//uses parseDouble, reads only one number per line a time
		//getUserInput01();
		//uses nextDouble, reads a series of numbers per line, 1 at a time
		//getUserInput02();
		createArray();
		printArray();
		printArraySum();
		printArrayRightDiagonalSum();
		printArrayLeftDiagonalSum();
		printArrayXSum();
	}
	
	//@@@ METHODS @@@
	//### Getters ###
	public void getUserInput01()
	{
		for (int row = 0; row < MAX_ROWS; row++) {
			System.out.println("Row number " + (row + 1));
			for (int column = 0; column < MAX_COLUMNS; column++) {
				System.out.println("Enter value for column " + (column + 1) + ": ");
				double inputNumber = keyboard.nextDouble();
				populateArrayManually(inputNumber, row, column);
				System.out.println();
				// Add a random number between 1 and 100 inclusive.
				populateArrayManually(ThreadLocalRandom.current().nextInt(1, 101), row, column);
			}
		}
		//System.out.println(Arrays.deepToString(_2dArray));
	}
	
	public void getUserInput02()
	{
		for (int row = 0; row < MAX_ROWS; row++) {
			System.out.println("Enter " + MAX_COLUMNS + " values separated by space for row " + (row + 1) + ": ");
			for (int column = 0; column < MAX_COLUMNS; column++) {
				double inputNumber = keyboard.nextDouble();
				populateArrayManually(inputNumber, row, column);
			}
		}
		//System.out.println(Arrays.deepToString(_2dArray));
	}
	
	public void createArray()
	{
		for (int row = 0; row < MAX_ROWS; row++) {
			for (int column = 0; column < MAX_COLUMNS; column++) {
				// Add a random number between 1 and 100 inclusive.
				populateArrayManually(ThreadLocalRandom.current().nextInt(1, 101), row, column);
			}
		}
		//System.out.println(Arrays.deepToString(_2dArray));
	}
	
	//### Setters ###
	public void populateArrayManually(double inputNumber, int row, int column)
	{
		for (int i = row; i < row + 1; i++) {
			for (int j = column; j < column + 1; j++) {
				_2dArray[row][j] = inputNumber;
			}
		}
	}
	
	//### Helpers ###
	public void printArray()
	{
		System.out.println();
		//divide MAX_COLUMNS to get 1, used to print the column numbers
		int printLength = MAX_COLUMNS / MAX_COLUMNS;
		System.out.println("\t\t" + "Column " + printLength + "\t" + "Column " + ++printLength + "\t" + "Column " + (++printLength) + "\t" + "Column " + ++printLength);
		for (int i = 0; i < MAX_ROWS; i++) {
			//use i+1 to print the current row number
			System.out.print("Row " + (i + 1) + ":\t");
			for (int j = 0; j < MAX_COLUMNS; j++) {
				System.out.printf("%s\t\t", _2dArray[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void printArraySum()
	{
		System.out.println();
		double sumTotal = 0;
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				sumTotal += _2dArray[i][j];
			}
		}
		System.out.println("The sum of all elements of the array is: " + sumTotal);
	}
	
	public void printArrayRightDiagonalSum()
	{
		System.out.println();
		double sumTotal = 0;
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				//only sum when i is the same as j, this will sum diagonally down and to the right
				if (i == j) {
					sumTotal += _2dArray[i][j];
				}
			}
		}
		System.out.println("The sum of all elements of the array / " + sumTotal);
	}
	
	public void printArrayLeftDiagonalSum()
	{
		System.out.println();
		double sumTotal = 0;
		int printControl = 1;
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				if (j == MAX_COLUMNS - printControl) {
					sumTotal += _2dArray[i][j];
					printControl++;
				}
			}
		}
		System.out.println("The sum of all elements of the array \\: " + sumTotal);
	}
	
	public void printArrayXSum()
	{
		System.out.println();
		double sumTotal = 0;
		int printControl = 1;
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				if (j == MAX_COLUMNS - printControl) {
					sumTotal += _2dArray[i][j];
					printControl++;
				}
				else if (i == j) {
					sumTotal += _2dArray[i][j];
				}
			}
		}
		System.out.println("The sum of all elements of the array X : " + sumTotal);
	}
}
