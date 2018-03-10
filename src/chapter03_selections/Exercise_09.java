package chapter03_selections;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>ISBN Check Digit Calculator</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class Exercise_09 {
	//@@@ MAIN METHOD @@@
	// 198526663 should be 5
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		long input = 0;
		
		boolean errorFound = false;
		do {
			// Reset incase of previous failure
			errorFound = false;
			try {
				System.out.println("Enter up to 9 integers");
				 input = stdin.nextLong();
				if (input <= 0)
					throw new Exception();
			} catch (Exception e) {
				System.out.println("There must be 1 to 9 integers entered.");
				errorFound = true;
			} finally {
				// Scanner bug
				stdin.nextLine();
			}
		} while (errorFound);
		
		// Pad with zereos
		int[] numbers = new int[9];
		String inputAsString = String.valueOf(input);
		int inputLength = inputAsString.length();
		System.out.println("inputLength: " + inputAsString.length());
		// Pad with zereos if necessary, remembering that int[] will have default of 0
		if(inputLength < 9) {
			// Convert string to char, so we can get each value and cast to int for the final array
			char[] inputNumbers = inputAsString.toCharArray();
			System.out.println("inputNumbers: " + Arrays.toString(inputNumbers));
			int startPosition = 9 - inputLength;
			
			int index = 0;
			for(int i = startPosition; i < numbers.length; i++) {
				numbers[i] = Integer.valueOf(String.valueOf(inputNumbers[index]));
				index++;
			}
		} else {
			char[] inputNumbers = inputAsString.toCharArray();
			System.out.println("inputNumbers: " + Arrays.toString(inputNumbers));
			
			for(int i = 0; i < inputNumbers.length; i++) {
				numbers[i] = Integer.valueOf(String.valueOf(inputNumbers[i]));
			}
		}
		System.out.println("numbers: " + Arrays.toString(numbers));
		
		// Calculate IBSN Check Digit - https://isbn-information.com/the-10-digit-isbn.html
		int checkDigit = 0;
		int counter = 10;
		StringBuffer aStringBuffer = new StringBuffer();
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("index: " + i + "\ncounter: " + counter);
			checkDigit += counter-- * numbers[i];
			aStringBuffer.append(numbers[i]);
		}
		System.out.println("checkDigit before modulo 11: " + checkDigit);
		checkDigit %= 11;
		System.out.println("checkDigit after modulo 11: " + checkDigit);
		
		
		switch(checkDigit) {
			case 10:
				aStringBuffer.append('X');
				break;
			default:
				aStringBuffer.append(checkDigit);
		}
		
		System.out.println("The ISBN-10 with check digit is : " + aStringBuffer.toString());
	}
}
