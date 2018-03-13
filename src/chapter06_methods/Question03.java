package chapter06_methods;

/**
 * <h1>>Palindrone Numbers</h1>
 * <p>
 * This program will ask for an integer and check if it is a palindrone number.
 * </p>
 * <p>
 * tags: while loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-24
 */
public class Question03
{
	//INSTANCE VARIABLES
	
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question03 run1 = new Question03(12345);
		Question03 run2 = new Question03(1221);
		Question03 run3 = new Question03(123421);
		Question03 run4 = new Question03(43211234);
		Question03 run5 = new Question03(4321234);
	}
	
	//CONSTRUCTOR(S)
	public Question03(int startNumber)
	{
		System.out.println("Start number is: " + startNumber);
		System.out.println("Reversed number is: " + reverseInt2(startNumber));
		System.out.println("Is this an integer palindrone? " + isPalindrone(Integer.toString(startNumber)));
		System.out.println();
	}
	
	//METHODS
	public int reverseInt2(int inputNumber)
	{
		//set up variables
		long reversedNumber = 0;
		long inputNumberAsLong = inputNumber;
		
		while (inputNumberAsLong != 0)
		{
			//times value by 10 to increase its place value, so we can move it up one place value (e.g. 1 becomes 10)
			//modulo input long by 10 to extract the value in the ones place and add that to our number (e.g. we get 5 and add to the 10 above, so now 15)
			reversedNumber = reversedNumber * 10 + inputNumberAsLong % 10;
			//divide by 10 to remove the value in the ones place
			inputNumberAsLong = inputNumberAsLong / 10;
		}
		
		//error handling
		if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE)
		{
			throw new IllegalArgumentException();
		}
		return (int) reversedNumber;
	}
	
	public boolean isPalindrone(String inputString)
	{
		//the index of the first char in the string
		int low = 0;
		//the index of the last char in the string, which is the length - 1
		int high = inputString.length() - 1;
		
		while (low < high)
		{
			if (inputString.charAt(low) != inputString.charAt(high))
			{
				return false;
			}
			//increamt low so we can check the next char
			low++;
			//decrement high so we can check the previous char
			high--;
		}
		return true;
	}
}
