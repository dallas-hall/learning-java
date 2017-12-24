/**
 *
 */
package chapter01_introduction.string_printing;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 2-3-17
 * @program: display 3 messages
 * @tags: String printing
 */
public class Exercise_01
{
	public static void main(String[] args)
	{
		//create strings
		String message1 = new String("Welcome to Jave,");
		String message2 = new String("Welcome to Comp Sci,");
		String message3 = new String("Programming is coo");
		// display strings
		System.out.println(message1 + message2 + message3);
	}
}
