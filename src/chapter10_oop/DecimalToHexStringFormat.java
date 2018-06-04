package chapter10_oop;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>DecimalToHexStringFormat</h1>
 * <p>
 * This program uses String.format to convert decimal numbers to hex from 0-255 (ASCII range). It has a 50% chance to print in either lowercase or UPPERCASE.
 * </p>
 * <p>
 * tags:	hex conversion; String.format; ThreadLocalRandom.current().nextInt();
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-04
 */
public class DecimalToHexStringFormat
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int[] asciiRange = new int[256];
		for (int i = 0; i < asciiRange.length; i++) {
			asciiRange[i] = i;
		}
		
		int prn = ThreadLocalRandom.current().nextInt(0, 100);
		boolean printUppercase = false;
		// 50% chance to print in UPPERCASE
		if (prn <= 49) {
			printUppercase = true;
		}
		
		int printCount = 0;
		for (int i = 0; i < asciiRange.length; i++) {
			if (printUppercase) {
				System.out.print(String.format("%2X", i) + " ");
			}
			else {
				System.out.print(String.format("%2x", i) + " ");
			}
			printCount++;
			if (printCount % 10 == 0) {
				System.out.println();
			}
		}
	}
}
