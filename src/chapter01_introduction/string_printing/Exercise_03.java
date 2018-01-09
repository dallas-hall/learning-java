package chapter01_introduction.string_printing;

/**
 * <h1>Print Messages</h1>
 * <p>
 * This program will display 2 messages, one that has been hardcoded and one from an array.
 * </p>
 * <p>
 * tags:	String printing;for loop;array;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2-3-17
 */

public class Exercise_03 {
	// Declare the array
	private static String[] message = {"  ▄▄▄▄▄ ██       ▄   ██ ", "▄▀  █   █ █       █  █ █ ", "    █   █▄▄█ █     █ █▄▄█", " ▄ █    █  █  █    █ █  █ ", "  ▀        █   █  █     █ ", "          █     █▐     █ ", "         ▀      ▐     ▀ "};
	
	// Run the program
	public static void main(String[] args) {
		System.out.println("\nHardcoded Version\n");
		System.out.println("  ▄▄▄▄▄ ██       ▄   ██ ");
		System.out.println("▄▀  █   █ █       █  █ █ ");
		System.out.println("    █   █▄▄█ █     █ █▄▄█");
		System.out.println(" ▄ █    █  █  █    █ █  █ ");
		System.out.println("  ▀        █   █  █     █ ");
		System.out.println("          █     █▐     █ ");
		System.out.println("         ▀      ▐     ▀ ");
		System.out.println("\nLoop Through String[] Version\n");
		for (int i = 0; i < message.length; i++) {
			System.out.println(message[i]);
		}
	}
}
