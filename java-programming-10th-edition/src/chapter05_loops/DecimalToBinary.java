package chapter05_loops;

/**
 * <h1>Decimal to Binary</h1>
 * <p>
 * This program will convert decimal 0-255 (ASCII range) into binary.
 * </p>
 * <p>
 * tags: for loop;modulo;integer division;StringBuffer;binary;base2;ASCII
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2018-03-07
 */
public class DecimalToBinary
{
	//@@@ INSTANCE VARIABLES @@@
	// ASCII range is 0-127, 'extended' is 128-255
	public static final int START_NUMBER = 0;
	public static final int FINAL_NUMBER = 255;
	public static final int RADIX = 2;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		DecimalToBinary runtime = new DecimalToBinary();
		int printCounter = 0;
		for (int i = START_NUMBER; i <= FINAL_NUMBER; i++)
		{
			System.out.print(runtime.getBinary(i) + " ");
			// Print a new line every 10th number
			printCounter++;
			if (printCounter % 10 == 0)
			{
				System.out.println();
			}
		}
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public DecimalToBinary()
	{
		System.out.println("@@@ ASCII Range As Binary @@@");
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public static String getBinary(int current_number)
	{
		StringBuffer aStringBuffer = new StringBuffer();
		
		if (current_number == 0)
		{
			aStringBuffer.append('0');
		}
		
		while (current_number > 0)
		{
			int answer = current_number / RADIX;
			if (current_number % 2 != 0)
			{
				aStringBuffer.append('1');
				current_number = answer;
			}
			else
			{
				aStringBuffer.append('0');
				current_number = answer;
			}
		}
		// Pad with zeros to make a byte
		int length = aStringBuffer.length();
		for (int i = length; i < 8; i++)
		{
			aStringBuffer.append('0');
		}
		aStringBuffer.reverse();
		return String.format("%-8s", aStringBuffer.toString());
	}
}
