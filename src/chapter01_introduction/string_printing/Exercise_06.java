/**
 *
 */
package chapter01_introduction.string_printing;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 2 Mar 2017
 * @program: Sum some numbers (1 to 9)
 * @tags: String printing; while loop; for loop
 */
public class Exercise_06
{
	
	public static void main(String[] args)
	{
		// create variable
		int finalAnswer = 0;
		int index = 1;
		
		System.out.println("@@@ Sum Using While Loop @@@");
		
		while (index < 10)
		{
			finalAnswer = finalAnswer + index;
			index++;
		}
		System.out.println("The answer is: " + finalAnswer);
		
		System.out.println("\n@@@ Sum Using For Loop @@@");
		//reset the answer
		finalAnswer = 0;
		
		for (int i = 0; i < 10; i++)
		{
			finalAnswer+=i;
		}
		System.out.println("The answer is: " + finalAnswer);
	}
}
