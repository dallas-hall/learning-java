package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will display 5 messages using a for loop and a while loop.
 * </p>
 * <p>
 * tags:	String printing;while loop;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2-3-17
 */

public class Exercise_02 {
	public static void main(String[] args) {
		// Create Strings
		String message1 = new String("Welcome to Dubai, gentlemen.");
		String message2 = new String("Welcome to Dubai, gentlemen!!!");
		
		// Print the message 5 times
		int index = 1;
		while (index <= 5) {
			System.out.println(message1);
			index++;
		}
		
		// Add a blank line
		System.out.println();
		
		// Print the message 5 times
		for (int i = 0; i < 5; i++) {
			System.out.println(message2);
		}
	}
}
