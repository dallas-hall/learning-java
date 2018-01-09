package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will sum some numbers (1 to 9).
 * </p>
 * <p>
 * tags:	String printing; while loop; for loop
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2-3-17
 */

public class Exercise_06 {
	public static void main(String[] args) {
		// Create variables
		int finalAnswer = 0;
		int index = 1;
		
		// While loop
		System.out.println("@@@ Sum Using While Loop @@@");
		while (index < 10) {
			finalAnswer = finalAnswer + index;
			index++;
		}
		System.out.println("The answer is: " + finalAnswer);
		
		// Reset the answer
		finalAnswer = 0;
		
		// For loop
		System.out.println("\n@@@ Sum Using For Loop @@@");
		for (int i = 0; i < 10; i++) {
			finalAnswer += i;
		}
		System.out.println("The answer is: " + finalAnswer);
	}
}
