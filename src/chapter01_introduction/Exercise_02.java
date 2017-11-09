/**
 *
 */
package chapter01_introduction;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 2-3-17
 * @program: display 5 messages
 */
public class Exercise_02
{
	
	public static void main(String[] args)
	{
		
		//Create Strings
		String message1 = new String("Welcome to Dubai, gentlemen.");
		String message2 = new String("Welcome to Dubai, gentlemen!!!");
		int index = 1;
		
		//print the message 5 times
		while (index <= 5)
		{
			System.out.println(message1);
			index++;
		}
		
		System.out.println();
		
		for (int i = 0; i < 5; i++)
		{
			System.out.println(message2);
		}
		
	}
	
}
