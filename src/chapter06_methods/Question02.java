package chapter06_methods;

/**
 * Created by blindcant on 24/04/17.
 */

public class Question02
{
	//INSTANCE VARIABLES
	
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
