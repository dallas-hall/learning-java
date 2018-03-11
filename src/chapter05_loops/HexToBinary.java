package chapter05_loops;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1>Convert Hex To Binary</h1>
 * <p>
 * This program will take a hex string, check its validity, and then return a nibble representing the hex string in binary.
 * </p>
 * <p>
 * tags:	Scanner; nextLine; for loop; HashMap; try-catch
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class HexToBinary {
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		Map<Character, String> hexToBinary = new HashMap<>();
		hexToBinary.put('0', "0000");
		hexToBinary.put('1', "0001");
		hexToBinary.put('2', "0010");
		hexToBinary.put('3', "0011");
		hexToBinary.put('4', "0100");
		hexToBinary.put('5', "0101");
		hexToBinary.put('6', "0110");
		hexToBinary.put('7', "0111");
		hexToBinary.put('8', "1000");
		hexToBinary.put('9', "1001");
		hexToBinary.put('a', "1010");
		hexToBinary.put('b', "1011");
		hexToBinary.put('c', "1100");
		hexToBinary.put('d', "1101");
		hexToBinary.put('e', "1110");
		hexToBinary.put('f', "1111");
		
		System.out.println("@@@ Hex To Binary @@@");
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		String hexInput = null;
		
		do {
			try {
				// Reset in case of previous failures
				errorFound = false;
				System.out.println("Enter a hexadecimal number.");
				hexInput = stdin.nextLine().toLowerCase();
				// Check for valid input
				if (!hexInput.matches("^[0-9A-F-a-f]+$")) {
					throw new Exception();
				}
			}
			catch (Exception e) {
				System.out.println("Hexadecimal numbers can only contain [0-9A-Fa-f].");
				errorFound = true;
			}
		}
		while (errorFound);
		
		// Convert valid hex to binary
		int hexInputLength = hexInput.length();
		for (int i = 0; i < hexInputLength; i++) {
			System.out.print(hexToBinary.get(hexInput.charAt(i)) + " ");
		}
	}
}
