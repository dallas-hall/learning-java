package chapter06;

/**
 * Created by blindcant on 24/04/17.
 */
public class Question01
{
	//INSTANCE VARIABLES
	
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question01 run1 = new Question01();
	}
	
	//CONSTRUCTOR(S)
	Question01()
	{
		printPentagonalNumbers(10);
	}
	
	//METHODS
	//https://www.mathsisfun.com/definitions/pentagonal-number.html
	//http://mathworld.wolfram.com/PentagonalNumber.html
	public int getPentagonalNumber(int n)
	{
		return n * (3 * n - 1) / 2;
	}
	
	public void printPentagonalNumbers(int maxNumber)
	{
		for (int i = 0; i < maxNumber; i++)
		{
			System.out.println(getPentagonalNumber(i));
		}
	}
}
