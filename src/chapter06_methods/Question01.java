package chapter06_methods;

/**
 * <h1>>Pentagonal Number Printing</h1>
 * <p>
 * This program will print pentagonal numbers up to the specified amount. A pentagonal number is a number that can represent a pentagon or nested pentagons in a series of dots.
 * </p>
 * <p>
 * tags: for loop; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-24
 */
public class Question01
{
	//INSTANCE VARIABLES
	
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question01 runtime = new Question01();
	}
	
	//CONSTRUCTOR(S)
	Question01()
	{
		printPentagonalNumbers(20);
	}
	
	//METHODS
	//https://www.mathsisfun.com/definitions/pentagonal-number.html
	//http://mathworld.wolfram.com/PentagonalNumber.html
	public int getPentagonalNumber(int n)
	{
		return n * (3 * n - 1) / 2;
	}
	
	public void printPentagonalNumbers(int amount)
	{
		int printCounter = 1;
		for (int i = 0; i < amount; i++)
		{
			// Print each number right justified with a width of 6
			System.out.format("%-6d", getPentagonalNumber(i));
			// Print 10 to a line
			if (printCounter % 10 == 0)
				System.out.println();
			printCounter++;
			
		}
	}
}
