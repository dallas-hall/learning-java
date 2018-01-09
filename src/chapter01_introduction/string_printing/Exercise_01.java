package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will display 3 messages.
 * </p>
 * <p>
 * tags:	String printing;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2-3-17
 */

public class Exercise_01 {
	public static void main(String[] args) {
		//create strings
		String message1 = new String("Welcome to Java,\n");
		String message2 = new String("Welcome to Comp Sci,\n");
		String message3 = new String("Programming is coo.");
		
		// display strings
		System.out.println(message1 + message2 + message3);
	}
}
