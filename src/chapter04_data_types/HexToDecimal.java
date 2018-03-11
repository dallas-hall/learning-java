package chapter04_data_types;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Convert Hex To Decimal</h1>
 * <p>
 * This program will take a hex string, check its validity, and then return a the value of that number in decimal.
 * </p>
 * <p>
 * tags:	array; Scanner; nextLine; for loop; switch; case; try-catch
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class HexToDecimal {
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		boolean debugging = false;
		System.out.println("@@@ Hex To Decimal @@@");
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		String hexInput = null;
		
		// ### Get user input ###
		do {
			try {
				// Reset in case of previous failures
				errorFound = false;
				System.out.println("Enter a hexadecimal number.");
				hexInput = stdin.nextLine().toUpperCase();
				// Check for valid input
				if (!hexInput.matches("^[0-9A-F-a-f]+$"))
					throw new Exception();
			}
			catch (Exception e) {
				System.out.println("Hexadecimal numbers can only contain [0-9A-Fa-f].");
				errorFound = true;
			}
		}
		while (errorFound);
		
		// ### Convert valid hex to decimal ###
		// *** Reverse endianess ***
		char[] hexCharsLittleEndian = hexInput.toCharArray();
		int hexCharsLittleEndianLength = hexCharsLittleEndian.length;
		int hexCharsLittleEndianMiddleIndex = hexCharsLittleEndianLength / 2;
		/*
		Switch from Big Endian (byte order is left to right e.g. one hundred and twenty three = 123) to Little Endian
		(byte order is right to left e.g. one hundred and twenty three = 321)
		 */
		char[] tempArray = new char[hexCharsLittleEndianLength];
		System.out.println(Arrays.toString(hexCharsLittleEndian));
		/*
		i is the usual for loop style, starts at 0 and increments by 1
		j is the usual for loop style, starts at length - 1 and decrements b y 1
		only loop while i is less than length - middle number, so we only process half the array otherwise we undo the start work
		 */
		for (int i = 0, j = hexCharsLittleEndianLength - 1; i < hexCharsLittleEndianLength - hexCharsLittleEndianMiddleIndex; i++, j--) {
			if(debugging) {
				System.out.println("Before swap, hexCharsLittleEndian[" + i + "] is: " + hexCharsLittleEndian[i]);
				System.out.println("Before swap,hexCharsLittleEndian[" + j + "] is: " + hexCharsLittleEndian[j]);
			}
			// Get the element towards the end and store it
			char tmpChar = hexCharsLittleEndian[j];
			// Swap the element towards the end with the element towards the start
			hexCharsLittleEndian[j] = hexCharsLittleEndian[i];
			// Insert element towards to the start into the element towards the end
			hexCharsLittleEndian[i] = tmpChar;
			if(debugging) {
				System.out.println("After swap, hexCharsLittleEndian[" + i + "] is: " + hexCharsLittleEndian[i]);
				System.out.println("After swap,hexCharsLittleEndian[" + j + "] is: " + hexCharsLittleEndian[j]);
				System.out.println();
			}
		}
		System.out.println(Arrays.toString(hexCharsLittleEndian));
		
		// *** Convert from hex to decimal ***
		int[] decimalLittleEndian = new int[hexCharsLittleEndianLength];
		for(int i = 0; i < hexCharsLittleEndianLength; i++) {
			switch(hexCharsLittleEndian[i]) {
				case '0':
					decimalLittleEndian[i] = 0;
					break;
				case '1':
					decimalLittleEndian[i] = 1;
					break;
				case '2':
					decimalLittleEndian[i] = 2;
					break;
				case '3':
					decimalLittleEndian[i] = 3;
					break;
				case '4':
					decimalLittleEndian[i] = 4;
					break;
				case '5':
					decimalLittleEndian[i] = 5;
					break;
				case '6':
					decimalLittleEndian[i] = 6;
					break;
				case '7':
					decimalLittleEndian[i] = 7;
					break;
				case '8':
					decimalLittleEndian[i] = 8;
					break;
				case '9':
					decimalLittleEndian[i] = 9;
					break;
				case 'A':
					decimalLittleEndian[i] = 10;
					break;
				case 'B':
					decimalLittleEndian[i] = 11;
					break;
				case 'C':
					decimalLittleEndian[i] = 12;
					break;
				case 'D':
					decimalLittleEndian[i] = 13;
					break;
				case 'E':
					decimalLittleEndian[i] = 14;
					break;
				case 'F':
					decimalLittleEndian[i] = 15;
					break;
			}
		}
		
		System.out.println(Arrays.toString(decimalLittleEndian));
		
		// *** Calculate decimal from hex ***
		int[] decimalBigEndian = new int[hexCharsLittleEndianLength];
		for (int i = 0, j = hexCharsLittleEndianLength - 1; i < hexCharsLittleEndianLength; i++, j--) {
			if(debugging)
				System.out.print("hexCharsLittleEndian[" + i + "] is " + hexCharsLittleEndian[i] + " ");
			// Reverse the storage order
			decimalBigEndian[i] = ((int)Math.pow(16, i)) * decimalLittleEndian[i];
		}
		System.out.println(Arrays.toString(decimalBigEndian));
		int decimalBigEndianLength = decimalBigEndian.length;
		int answer = 0;
		for(int i = 0; i < decimalBigEndianLength; i++) {
			answer += decimalBigEndian[i];
		}
		System.out.println("The hex number 0x" + hexInput + " is " + answer + " in decimal.");
	}

}
