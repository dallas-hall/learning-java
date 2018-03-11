package chapter04_data_types;

import java.util.Scanner;

/**
 * <h1>Convert Hex To Binary</h1>
 * <p>
 * This program will take a hex string, check its validity, and then return a nibble representing the hex string in binary.
 * </p>
 * <p>
 * tags:	array; Scanner; nextLine; for loop; switch; case; try-catch
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-10
 */
public class HexToBinary {
	//@@@ INSTANCE VARIABLES @@@
	private static final String[] HEX_CHARS_AS_BINARY_NIBBLES = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		System.out.println("@@@ Hex To Binary @@@");
		Scanner stdin = new Scanner(System.in);
		boolean errorFound = false;
		String hexInput = null;
		
		do {
			try {
				// Reset in case of previous failures
				errorFound = false;
				System.out.println("Enter a hexadecimal number.");
				hexInput = stdin.nextLine().toUpperCase();
				// Check for valid input
				if(!hexInput.matches("^[0-9A-F-a-f]+$"))
					throw new Exception();
			} catch (Exception e) {
				System.out.println("Hexadecimal numbers can only contain [0-9A-Fa-f].");
				errorFound = true;
			}
		} while(errorFound);
		
		// Convert valid hex to binary
		char[] hexChars = hexInput.toCharArray();
		int hexCharsLength = hexChars.length;
		for(int i = 0; i < hexCharsLength; i++) {
			switch(hexChars[i]) {
				case '0':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[0]);
					break;
				case '1':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[1]);
					break;
				case '2':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[2]);
					break;
				case '3':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[3]);
					break;
				case '4':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[4]);
					break;
				case '5':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[5]);
					break;
				case '6':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[6]);
					break;
				case '7':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[7]);
					break;
				case '8':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[8]);
					break;
				case '9':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[9]);
					break;
				case 'A':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[10]);
					break;
				case 'B':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[11]);
					break;
				case 'C':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[12]);
					break;
				case 'D':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[13]);
					break;
				case 'E':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[14]);
					break;
				case 'F':
					System.out.print(HEX_CHARS_AS_BINARY_NIBBLES[15]);
					break;
			}
			System.out.print(" ");
		}
	}
}
