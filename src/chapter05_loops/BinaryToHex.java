package chapter05_loops;

import java.util.*;

/**
 * <h1>Binary To Hexadecimal</h1>
 * <p>
 * This program takes a valid binary number and converts it to hexadecimal.
 * </p>
 * <p>
 * tags:	Scanner; nextLine; for loop; Math.pow; char[]
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class BinaryToHex {
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		Map<Integer, String> decimalToBinary = new HashMap<>();
		decimalToBinary.put(0, "0");
		decimalToBinary.put(1, "1");
		decimalToBinary.put(2, "2");
		decimalToBinary.put(3, "3");
		decimalToBinary.put(4, "4");
		decimalToBinary.put(5, "5");
		decimalToBinary.put(6, "6");
		decimalToBinary.put(7, "7");
		decimalToBinary.put(8, "8");
		decimalToBinary.put(9, "9");
		decimalToBinary.put(10, "a");
		decimalToBinary.put(11, "b");
		decimalToBinary.put(12, "c");
		decimalToBinary.put(13, "d");
		decimalToBinary.put(14, "e");
		decimalToBinary.put(15, "f");
		
		List<int[]> binaryIntArrays = new ArrayList<>();
		System.out.println("@@@ Binary To Decimal @@@");
		boolean errorFound = false;
		Scanner stdin = new Scanner(System.in);
		String stringBinaryNumber = "0";
		boolean debugging = false;
		
		// Get user input
		do {
			errorFound = false;
			try {
				System.out.println("Enter a binary number, leading zeros are optional.");
				stringBinaryNumber = stdin.nextLine();
				// Check user input
				if (!stringBinaryNumber.matches("^[01]+$")) {
					throw new Exception();
				}
			}
			catch (Exception e) {
				System.out.println("Binary numbers can only contain 0 and 1.");
				errorFound = true;
			}
		}
		while (errorFound);
		System.out.println(stringBinaryNumber);
		int stringBinaryNumberLength = stringBinaryNumber.length();
		
		// Convert binary numbers in nibbles
		int[] tempIntArray = new int[4];
		int counter = tempIntArray.length - 1;
		for (int i = stringBinaryNumberLength - 1; i >= 0; i--, counter--) {
			if (debugging) {
				System.out.println(stringBinaryNumber.charAt(i));
			}
			tempIntArray[counter] = Integer.parseInt(String.valueOf(stringBinaryNumber.charAt(i)));
			if (counter == 0 || i == 0) {
				// Add the nibble, reset the current array, and the counter
				binaryIntArrays.add(tempIntArray);
				tempIntArray = new int[4];
				// Need to be 4 here because of counter--
				counter = 4;
			}
		}
		
		// Iterate through each nibble and calculate its decimal value
		StringBuffer aStringBuffer = new StringBuffer();
		int subtotal = 0;
		for (int[] anIntArray : binaryIntArrays) {
			int anIntArrayLength = anIntArray.length;
			if (debugging) {
				System.out.println(Arrays.toString(anIntArray));
			}
			for (int i = 0; i < anIntArrayLength; i++) {
				if (i == 0 && anIntArray[i] != 0) {
					subtotal += 8;
				}
				else if (i == 1 && anIntArray[i] != 0) {
					subtotal += 4;
				}
				else if (i == 2 && anIntArray[i] != 0) {
					subtotal += 2;
				}
				else if (i == 3 && anIntArray[i] != 0) {
					subtotal += 1;
				}
			}
			
			// Convert decimal to hex
			aStringBuffer.append(decimalToBinary.get(subtotal));
			subtotal = 0;
		}
		
		System.out.println("The binary number " + stringBinaryNumber + " is 0x" + aStringBuffer.reverse().toString() + " in hexadecimal.");
	}
}
