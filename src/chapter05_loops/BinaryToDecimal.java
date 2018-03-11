package chapter05_loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Binary To Decimal</h1>
 * <p>
 * This program takes a valid binary number and converts it to decimal.
 * </p>
 * <p>
 * tags:	Scanner; nextLine; for loop; Math.pow;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class BinaryToDecimal {
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		System.out.println("@@@ Binary To Hexadecimal @@@");
		boolean errorFound = false;
		Scanner stdin = new Scanner(System.in);
		String stringBinaryNumber = "0";
		
		do {
			errorFound = false;
			try {
				System.out.println("Enter a binary number, leading zeros are optional.");
				stringBinaryNumber = stdin.nextLine();
				if (!stringBinaryNumber.matches("^[01]+$"))
					throw new Exception();
			}
			catch (Exception e) {
				System.out.println("Binary numbers can only contain 0 and 1.");
				errorFound = true;
			}
		}
		while (errorFound);
		
		System.out.println(stringBinaryNumber);
		int stringBinaryNumberLength = stringBinaryNumber.length();
		
		int total = 0;
		for (int i = 0, j = stringBinaryNumberLength - 1; i < stringBinaryNumberLength; i++, j--) {
			//System.out.println("i is " + i + " and i's value is " + charArrayBinaryNumber[i] + " and j is " + j);
			// Calculate the current power, and multiple that with the integer value of the char array index
			total += ((int) Math.pow(2, j)) * Integer.parseInt(String.valueOf(stringBinaryNumber.charAt(i)));
		}
		System.out.println("The binary number " + stringBinaryNumber + " is " + total + " in decimal.");
	}
}
