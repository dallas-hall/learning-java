package chapter07_1d_arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Bean Machine</h1>
 * <p>
 * This program will simulate the Bean Machine. Nails are placed in a triangle and beans are fed into the system, they will either bounce left or right.
 * </p>
 * <p>
 * tags:	Scanner; Exception; array; nested for loops; ThreadLocalRandom; pseudo-random numbers;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-28
 */
public class BeanMachine
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		// Setup game
		Scanner scanner = new Scanner(System.in);
		System.out.println("@@@ Bean Machine @@@");
		int beans = getPositiveIntegerInput("How many balls do you want in your Bean Machine?", scanner);
		int nailRows = getPositiveIntegerInput("How many rows of nails do you want in your Bean Machine?", scanner);
		int beanSlots = setupBeanMachine(nailRows);
		int[][] beanResults = new int[beans][1];
		int[][] finalBeanSlots =  new int[beans][1];
		
		// Run game
		for (int i = 0; i < beans; i++) {
			// Drop a bean
			System.out.println("Bean " + (i + 1) + "'s path.");
			// Insert into the index matching i of the 1D array
			beanResults[i] = dropBean(nailRows);
			System.out.println(Arrays.toString(beanResults[i]));
		}
		
		System.out.println(Arrays.deepToString(beanResults));
		
/*		for (int i = 0; i < finalBeanSlots.length; i++) {
			// Insert into the first index of the 2D array
			finalBeanSlots[i][0] = getFinalSlot(beanResults[i], beanSlots);
			System.out.println("Final slot for bean " + (i + 1) + " is : " + finalBeanSlots[i][0]);
		}*/
		
		for (int i = 0; i < finalBeanSlots.length; i++) {
			// Insert into the first index of the 2D array
			finalBeanSlots[i][0] = getFinalSlotRewrite(beanResults[i], beanSlots);
			System.out.println("Final slot for bean " + (i + 1) + " is : " + finalBeanSlots[i][0]);
		}
		
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public static int getPositiveIntegerInput(String message, Scanner scanner)
	{
		boolean errorFound = false;
		int number = 0;
		do {
			// Reset in case of previous run
			errorFound = false;
			System.out.println(message);
			try {
				number = Integer.parseInt(scanner.nextLine());
				if (number < 1) {
					throw new Exception();
				}
			}
			catch (Exception e) {
				System.out.println("Please enter positive integers only.");
				errorFound = true;
			}
		}
		while (errorFound);
		return number;
	}
	
	public static int[] dropBean(int nailRows)
	{
		int pseudoRandomNumber = 0;
		int[] results = new int[nailRows];
		for (int i = 0; i < nailRows; i++) {
			pseudoRandomNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
			// Left of middle, so -1
			if (pseudoRandomNumber <= 50) {
				results[i] = -1;
			}
			// Right of middle, so +1
			else {
				results[i] = 1;
			}
		}
		return results;
	}
	
	//### HELPERS ###
	public static int setupBeanMachine(int nailRows)
	{
		// *** Print Beach Machine ***
		System.out.println("### Your Bean Machine ###");
		int leadingSpacesToPrint = nailRows;
		// Need + 1 here to cover both sides
		int beanSlots = nailRows + 1;
		int nailsToPlace = 1;
		
		// Rows
		for (int i = 0; i < nailRows; i++) {    // Spaces
			for (int j = 0; j < leadingSpacesToPrint; j++) {
				System.out.format(" ");
			}
			
			// Nails
			for (int k = 0; k < nailsToPlace; k++) {
				// Need the additional space here for trailing nails
				System.out.print(". ");
			}
			
			// Create row
			System.out.println();
			
			// Update variables
			nailsToPlace++;
			leadingSpacesToPrint--;
		}
		
		// Slots
		for (int l = 0; l < beanSlots; l++) {
			System.out.print("_ ");
		}
		System.out.println();
		
		return beanSlots;
	}
	
	public static int getFinalSlot(int[] beanPath, int beanSlots) {
		// Add one double and divide by 2, we are in the middle then.
		double result = (beanSlots + 1d) / 2;
		
		for(int i = 0; i < beanPath.length; i++) {
			// Add a fractional component to get the right slot. This is because we have spaces between the slots.
			if(beanPath[i] == 1)
				result += 0.5;
			else
				result += -0.5;
		}
		
		// Minus one since arrays start at 0
		return (int) result - 1;
	}
	
	public static int getFinalSlotRewrite(int[] beanPath, int beanSlots) {
		// This is the middle, if we include the spaces between the slots.
		int result = beanSlots;
		
		for(int i = 0; i < beanPath.length; i++) {
			result += beanPath[i];
		}
		
		// Divide by 2 to remove the spaces.
		return (int) (result / 2);
	}
}
