package chapter06_methods;

/**
 * <h1>>Digit Addition</h1>
 * <p>
 * This program will ask for an integer and sum its digits. It uses modulo by 10 to extract each digit from the 1's place and integer division by 10 to remove the digit in the 1's place.
 * </p>
 * <p>
 * tags: for loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-24
 */

public class Question02
{
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question02 run1 = new Question02(234); //should be 9
		Question02 run2 = new Question02(888); //should be 24
		Question02 run3 = new Question02(369); //should be 18
	}
	
	//CONSTRUCTOR(S)
	public Question02(int startNumber)
	{
		System.out.println(sumDigits(startNumber));
	}
	
	//METHODS
	public int sumDigits(int startNumber)
	{
		int sum = 0;
		int n = startNumber;
		int numberOfDigits = Integer.toString(n).length();
		for (int i = 0; i < numberOfDigits; i++)
		{
			//use modulo 10 to extract the tens column each time
			sum += n % 10;
			//use divsion by 10 to remove the tens column each time
			n = n / (10);
		}
		return sum;
	}
}
