package chapter12_exceptions_and_text_io;

import java.util.Scanner;

/**
 * Created by blindcant on 7/05/17.
 */
public class Test
{
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(System.in);
		int intValue = input.nextInt();
		double doubleValue = input.nextDouble();
		String line = input.nextLine();
		
		System.out.println(intValue + " " + doubleValue + " " + line);
	}
}