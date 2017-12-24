/**
 *
 */
package chapter01_introduction.string_printing;

/**
 * @author: blindcant
 * @version: 0.1
 * @date: 2-3-17
 * @program: display a message across multiple lines
 * @tags: String printing; arrays; for loop
 */
public class Exercise_03
{
	private static String[] message = {"  ▄▄▄▄▄ ██       ▄   ██ ", "▄▀  █   █ █       █  █ █ ", "    █   █▄▄█ █     █ █▄▄█", " ▄ █    █  █  █    █ █  █ ", "  ▀        █   █  █     █ ", "          █     █▐     █ ", "         ▀      ▐     ▀ "};
	
	
	public static void main(String[] args)
	{
		
		System.out.println("\nHardcoded Version\n");
		
		System.out.println("  ▄▄▄▄▄ ██       ▄   ██ ");
		System.out.println("▄▀  █   █ █       █  █ █ ");
		System.out.println("    █   █▄▄█ █     █ █▄▄█");
		System.out.println(" ▄ █    █  █  █    █ █  █ ");
		System.out.println("  ▀        █   █  █     █ ");
		System.out.println("          █     █▐     █ ");
		System.out.println("         ▀      ▐     ▀ ");
		
		System.out.println("\nLoop Through String[] Version\n");
		for (int i = 0; i < message.length; i++)
		{
			System.out.println(message[i]);
		}
		
	}
	
}
